package com.gxuwz.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.hql.ast.QueryTranslatorImpl;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.hibernate.type.Type;
import org.jboss.weld.bootstrap.api.helpers.ServiceRegistries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import org.hibernate.*;

import com.gxuwz.Market.business.entity.TestPaperTopic;
import com.gxuwz.core.dao.BaseDao;
import com.gxuwz.core.pagination.Result;

/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common methods that they might all use. Can be used for standard CRUD
 * operations.
 * 
 * @version $ BaseDaoImpl.java 2015-7-13 10:50:44
 */
@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public T save(T entity) {
		try {
			getHibernateTemplate().saveOrUpdate(entity);
		}catch (Exception e) {
			logger.error("save failed 数据重复，不插入");
			throw e;
		}
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public T save1(TestPaperTopic testPaperTopic) {
		try {
			getHibernateTemplate().saveOrUpdate(testPaperTopic);
		}catch (Exception e) {
			logger.error("save failed 数据重复，不插入");
			throw e;
		}
		return (T) testPaperTopic;
	}

	@Override
	public T merge(T entity) {
		getHibernateTemplate().merge(entity);
		return entity;
	}

	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public T get(Class<T> clazz, Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}
	
	@Override
	public void remove(Class<T> clazz, Serializable id) {
		getHibernateTemplate().delete(get(clazz, id));
	}

	@Override
	public void remove(T entity) {
		getHibernateTemplate().delete(entity);
	}

	@Override
	public void evict(T entity) {
		getHibernateTemplate().evict(entity);

	}

	@Override
	public List<T> getAll(final Class<T> clazz) {
		Object result = getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from " + clazz.getName();
						Query query = session.createQuery(hql);
						return query.list();
					}
				});
		return (List) result;
	}

	@Override
	public List<T> findByHql(String queryString, Object[] params) {
		return (List<T>) getHibernateTemplate().find(queryString, params);
	}

	@Override
	public T findByHql(final String hql) {
		return (T) getHibernateTemplate().execute(
				new HibernateCallback<T>() {
					public T doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						
						return (T) query.uniqueResult();
					}
				});
	}
	
	@Override
	public List<T> findByHql(final String queryString, final Object[] values,
			final int start, final int limit) {
		return (List) getHibernateTemplate().execute(
				new HibernateCallback<List>() {
					public List doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(queryString);
						query.setFirstResult(start).setMaxResults(limit);
						if (values != null) {
							for (int i = 0; i < values.length; i++) {
								query.setParameter(i, values[i]);
							}
						}
						return query.list();
					}
				});
	}

	@Override
	public void flush() {
		getHibernateTemplate().flush();
	}

	@Override
	public Long update(final String queryString, final Object[] values) {

		int c = getHibernateTemplate().executeWithNativeSession(
				new HibernateCallback<Integer>() {
					public Integer doInHibernate(Session session)
							throws HibernateException {
						Query queryObject = session.createQuery(queryString);

						if (values != null) {
							for (int i = 0; i < values.length; i++) {
								queryObject.setParameter(i, values[i]);
							}
						}
						return queryObject.executeUpdate();
					}
				});
		return new Long(c);
	}

	public Result find(
		
			final String queryString, final Object[] values,
			final Type[] types, final int start, final int limit) {
		try{
		Result result = new Result(start, limit);

		if ( start != -1 && limit != -1) {
			result.setTotal(getTotalItems(queryString, values).intValue());
		}

		HibernateTemplate ht = getHibernateTemplate();

		List data = ht.executeFind(new HibernateCallback<List>() {
			public List doInHibernate(Session session)
					throws HibernateException {
				Query queryObject = session.createQuery(queryString);

				setParameters(queryObject, values, types);

				if (start >= 0) {
					queryObject.setFirstResult(start);
				}

				if (limit >= 0) {
					//queryObject.setMaxResults(limit + 1);
					queryObject.setMaxResults(limit);
				}

				return queryObject.list();
			}
		});

		result.setData(data);

		if (start == -1 && limit == -1) {
			result.setTotal(data.size());
		}

		return result;
	}catch (RuntimeException e) {
		throw e;
	}
	}



	/**
	 * 因为获取总数很慢，但是没有深究，所以直接去掉不读取总数。2016-03-16庞光垚
	 * @param queryString
	 * @param values
	 * @param types
	 * @param start
	 * @param limit
	 * @return
	 */
	public Result findNotTotal(
		
			final String queryString, final Object[] values,
			final Type[] types, final int start, final int limit) {
		try{
		Result result = new Result(start, limit);

		//有可能出错，空等的情况
		if ( start != -1 && limit != -1) {
			String queryStringT = "SELECT COUNT(id) "+queryString;
			Object tTemp = findByHql(queryStringT);
			result.setTotal(Integer.parseInt(tTemp.toString()));
		}

		HibernateTemplate ht = getHibernateTemplate();

		List data = ht.executeFind(new HibernateCallback<List>() {
			public List doInHibernate(Session session)
					throws HibernateException {
				Query queryObject = session.createQuery(queryString);

				setParameters(queryObject, values, types);

				if (start >= 0) {
					queryObject.setFirstResult(start);
				}

				if (limit >= 0) {
					//queryObject.setMaxResults(limit + 1);
					queryObject.setMaxResults(limit);
				}

				return queryObject.list();
			}
		});

		result.setData(data);

		if (start == -1 && limit == -1) {
			result.setTotal(data.size());
		}

		return result;
	}catch (RuntimeException e) {
		throw e;
	}
}

	/**
	 * 
	 * @param queryString
	 * @param values
	 * @param types
	 * @return
	 * @throws DataAccessException
	 */
	protected int bulkUpdate(final String queryString, final Object[] values,
			final Type[] types) throws DataAccessException {

		Integer updateCount = (Integer) getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
					public Integer doInHibernate(Session session)
							throws HibernateException {
						Query queryObject = session.createQuery(queryString);
						setParameters(queryObject, values, types);
						return new Integer(queryObject.executeUpdate());
					}
				});
		return updateCount.intValue();
	}

	/**
	 * SQL 
	 * 
	 * @param queryObject
	 * @param values
	 * @param types
	 */
	static void setParameters(Query queryObject, Object[] values, Type[] types) {
		if (values != null) {
			if (types != null) {
				for (int i = 0; i < values.length; i++) {
					queryObject.setParameter(i, values[i], types[i]);
				}
			} else {
				for (int i = 0; i < values.length; i++) {
					queryObject.setParameter(i, values[i]);
				}
			}
		}
	}

	/**
	 * 
	 * @param sql
	 * @param entityAlias
	 * @param entityClass
	 * @param values
	 * @param types
	 * @return
	 */
	protected List findBySQL(final String sql, final String entityAlias,
			final Class<T> entityClass, final Object[] values,
			final Type[] types) {
		return findBySQL(sql, entityAlias, entityClass, values, types, -1, -1)
				.getData();
	}

	protected Result findBySQL(final String sql, final String entityAlias,
			final Class<T> entityClass, final Object[] values,
			final Type[] types, final int start, final int limit) {
		return findBySQL(sql, entityAlias, entityClass, values, types, start,
				limit, true);
	}

	@SuppressWarnings("rawtypes")
	protected Result findBySQL(final String sql, final String entityAlias,
			final Class entityClass, final Object[] values, final Type[] types,
			final int start, final int limit, boolean readOnly) {

		HibernateTemplate ht = getHibernateTemplate();

		Result result = new Result(start, limit);

		if (start != -1 && limit != -1) {

			Number count = getTotalItems(sql, values);
			result.setTotal(count.intValue());
		}

		List data = ht.executeFind(new HibernateCallback<List>() {
			public List doInHibernate(Session session)
					throws HibernateException {
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(entityAlias, entityClass);
				query.setParameters(values, types);

				if (start >= 0) {
					query.setFirstResult(start);
				}

				if (limit >= 0) {
					query.setMaxResults(limit + 1);
				}

				return query.list();
			}
		});

		result.setData(data);

		if (start == -1 && limit == -1) {
			result.setTotal(data.size());
		}

		return result;
	}

	/**
	 * 
	 * @param queryString
	 * @param values
	 * @return
	 */
	public Long getTotalItems(String queryString, final Object[] values) {
		int orderByIndex = queryString.toUpperCase().indexOf(" ORDER BY ");

		if (orderByIndex != -1) {
			queryString = queryString.substring(0, orderByIndex);
		}

		QueryTranslatorImpl queryTranslator = new QueryTranslatorImpl(
				queryString, queryString, Collections.EMPTY_MAP,
				(SessionFactoryImplementor) getHibernateTemplate().getSessionFactory());
		queryTranslator.compile(Collections.EMPTY_MAP, false);
		final String sql = "select count(*) from (" 
				+ queryTranslator.getSQLString() + ") tmp_count_t";

		Object reVal = getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						SQLQuery query = session.createSQLQuery(sql);
						if (values != null) {
							for (int i = 0; i < values.length; i++) {
								query.setParameter(i, values[i]);
							}
						}
						return query.uniqueResult();
					}
				});
		return new Long(reVal.toString());
	}
	
	/**
	 * SQL查询
	 * @author 涛 
	 * @date 2016年12月2日
	 * @param queryString
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findBySql(final String queryString,final Object[] values){
		return (List)getHibernateTemplate().execute(new HibernateCallback<List>() {
			@Override
			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				SQLQuery sqlQuery = session.createSQLQuery(queryString);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						sqlQuery.setParameter(i, values[i]);
					}
				}
				return sqlQuery.list();
			}
		});
	}
	
	
	public static Session getSession() {
		Session session = null;
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		session = factory.getCurrentSession();
		return session;
	}
	

}




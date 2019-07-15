package com.gxuwz.Market.business.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.Group;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;
/**
 * 
 *<p>Title:ClassDAO</p>
 *<p>Description:</p>
 * @author zhaoyanmei
 * @date 2019年1月26日下午11:25:37
 */
@Repository("GroupDAO")
public class GroupDAO extends BaseDaoImpl<Group>{

	/**
	 * 根据条件查找分页
	 * @param group 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Group> find(Group group, int page, int row){
		String queryString="from Group where 1=1";//此处的Group为实体类的名字而不是表的名字
		if(null != group.getClassName()){
			queryString = queryString + " and className like '%"+group.getClassName()+"%'";
		}//如果group的className属性不为空，执行查询语句
		int start=(page-1)*row;
		int limit =row;
		return (Result<Group>)super.find(queryString, null, null, start, limit);
	 }
	/**
	 * 查询所有班级
	 * @return
	 */
	public List<Group> getAllGroup() {
		// TODO Auto-generated method stub
		String queryString="from Group where 1=1";//此处的Group为实体类的名字而不是表的名字
		return (List<Group>) getHibernateTemplate().find(queryString);
	}
	/**
	 * 查询所有班级名称
	 * @return
	 */
	public List<String> getAllClassName() {
		// TODO Auto-generated method stub
		String queryString="select className from Group where 1=1";
		return (List<String>) getHibernateTemplate().find(queryString);
	}
	/**
	 * 查询对应班级的学生人数
	 * @return
	 */
	/*public List<Student> getAllStudentNum(Integer classId,Integer classId1) {
		// TODO Auto-generated method stub
		String sql="update Group g set g.studentNumber = (select count(*) from Student s where s.classId=?) where g.classId=? ";
		Integer[] value = new Integer[]{classId, classId1};
		try{
		return (List<Student>) getHibernateTemplate().find(sql,value);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("getMessage:"+e.getMessage());
		}
		return null;
	}*/
	public List<Student> getAllStudentNum(final Integer classId,Integer classId1) {
		// TODO Auto-generated method stub
		 final String queryString ="update Group g set g.studentNumber = (select count(*) from Student s where s.classId=?) where g.classId=? ";
		 final Integer[] value = new Integer[]{classId, classId1};
		try{
			final List list = getHibernateTemplate().execute(new HibernateCallback<List>() {
				@Override
				public List doInHibernate(Session session) throws HibernateException,SQLException {
					SQLQuery sqlQuery = session.createSQLQuery(queryString);
					sqlQuery.setInteger(0, classId);
					sqlQuery.setInteger(1, classId);
					System.out.println("sqlQuery=="+sqlQuery);
					return sqlQuery.list();
				}
			});
			System.out.println("countDataBikeSharing，list.size()="+list.size());
			return list;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("getMessage:"+e.getMessage());
		}
		return null;
	}
}

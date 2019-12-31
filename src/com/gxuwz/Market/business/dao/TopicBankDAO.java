package com.gxuwz.Market.business.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.*;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

/**
 *<p>Title:TopicBankDAO</p>
 *<p>Description:</p>
 * @author zhaoyanmei
 * @date 2019年1月20日下午11:38:09
 */

@Repository("TopicBankDAO")
public class TopicBankDAO extends BaseDaoImpl<TopicBank>{
	
	/**
	 * 根据条件查找分页
	 * @param topicBank 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<TopicBank> find(TopicBank topicBank, int page, int row){
		String queryString="from TopicBank where 1=1";//此处的TopicBank为实体类的名字而不是表的名字
		if(null != topicBank.getTopicBankName()){
			queryString = queryString + " and topicBankName like '%"+topicBank.getTopicBankName()+"%'";
		}//如果topicBank的topicBankName属性不为空，执行查询语句
		int start=(page-1)*row;
		int limit =row;
		return (Result<TopicBank>)super.find(queryString, null, null, start, limit);
	 }
	
	/**
	 * 查询所有题库
	 * @return
	 */
	public List<TopicBank> getAllTopicBank() {
		// TODO Auto-generated method stub
		String queryString="from TopicBank where 1=1";//此处的TopicBank为实体类的名字而不是表的名字
		return (List<TopicBank>) getHibernateTemplate().find(queryString);
	}
	/**
	 * 查询所有题库名称
	 * @return
	 */
	public List<String> gettopicBankNameAll() {
		// TODO Auto-generated method stub
		String queryString="select topicBankName from TopicBank where 1=1";
	    return (List<String>) getHibernateTemplate().find(queryString);
	}

	/**
	 * 二级联动查询题库名称
	 * @return
	 */
	public List<String> gettopicBankName() {
		// TODO Auto-generated method stub
		String queryString = "select topicBankName from TopicBank where courseId in(select courseId from Course where courseName=)";
		 return (List<String>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 查询对应题库name的试题数量12.30
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int getAllTopicNum(String topicBankName){
		// TODO Auto-generated method stub
		String queryString ="select count(*) from Topic where topicBankName = ?";
		List list =(List)getHibernateTemplate().find(queryString, topicBankName);
		Number num = (Number) list.get(0);
		return num.intValue();
	}
	
  }

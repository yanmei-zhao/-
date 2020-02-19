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
	@SuppressWarnings("unchecked")
	public List<TopicBank> getAllTopicBank() {
		// TODO Auto-generated method stub
		String queryString="from TopicBank where 1=1";//此处的TopicBank为实体类的名字而不是表的名字
		return (List<TopicBank>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 查询所有题库名称
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> gettopicBankNameAll() {
		// TODO Auto-generated method stub
		String queryString="select topicBankName from TopicBank where 1=1";
	    return (List<String>) getHibernateTemplate().find(queryString);
	}

	/**
	 * 二级联动查询题库名称
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> gettopicBankName(String type) {
		// TODO Auto-generated method stub
		//String queryString = "select topicBankName from TopicBank where courseId in(select courseId from Course where courseName=)";
		String queryString = "select topicBankName from TopicBank where topicBankType='"+type+"'";
		return (List<String>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 查询对应题库name的试题数量12.30
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public int getAllTopicNum(int topicBankId){
		// TODO Auto-generated method stub
		//统计三个表里符合该题库名字的试题数量
		String queryString ="select count(*) from ChoiceTopic where topicBankId = ?";
		String queryString1 ="select count(*) from Topic where topicBankId = ?";
		String queryString2 ="select count(*) from FillTopic where topicBankId = ?";
		String queryString3 ="select count(*) from JudgeTopic where topicBankId = ?";
		String queryString4 ="select count(*) from MultipleTopic where topicBankId = ?";
		List list =(List)getHibernateTemplate().find(queryString, topicBankId);
		Number num = (Number) list.get(0);
		List list1 =(List)getHibernateTemplate().find(queryString1, topicBankId);
		Number num1 = (Number) list1.get(0);
		List list2 =(List)getHibernateTemplate().find(queryString2, topicBankId);
		Number num2 = (Number) list2.get(0);
		List list3 =(List)getHibernateTemplate().find(queryString3, topicBankId);
		Number num3 = (Number) list3.get(0);
		List list4 =(List)getHibernateTemplate().find(queryString4, topicBankId);
		Number num4 = (Number) list4.get(0);
		Number num0 = (num.intValue()+num1.intValue()+num2.intValue()+num3.intValue()+num4.intValue());
		return num0.intValue();
	}

	public TopicBank findByName(String topicBankName) {
		// TODO Auto-generated method stub
		String queryString ="from TopicBank where 1=1 and topicBankName = '"+topicBankName+"'";
		return (TopicBank) getHibernateTemplate().find(queryString).get(0);
	}
	
	/**
	 * 查询题库数量
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public int gettopicBankNum(){
		String queryString="select count(*) from TopicBank where 1=1";
		List list =(List)getHibernateTemplate().find(queryString);
		Number num = (Number) list.get(0);
		return num.intValue();
	}
	
  }

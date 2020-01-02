package com.gxuwz.Market.business.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.FillTopic;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

@Repository("topicDAO")
public class TopicDAO extends BaseDaoImpl<Topic>{
	
	/**
	 * 根据条件查找分页
	 * @param SysRole 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Topic> find(Topic topic, int page, int row){
		String queryString="from Topic where 1=1";
		System.out.println("topic.getTopicId()"+topic.getTopicId());
		System.out.println("topic.getTopicBankName()"+topic.getTopicBankName());
		System.out.println("topic.getTopicName()"+topic.getQuestion());
		if(null !=topic.getTopicId()){
			queryString = queryString +" and topicId like '%"+topic.getTopicId() +"%' ";
		}
		else if(null != topic.getQuestion()){
			queryString = queryString + " and topicName like '%"+topic.getQuestion()+"%'";
		}
		else if(null != topic.getTopicBankName()){
			queryString = queryString + "and topicBankName like '%"+ topic.getTopicBankName() +"%'";
		}
		int start=(page-1)*row;
		int limit =row;
		return (Result<Topic>)super.find(queryString, null, null, start, limit);
	}
	/**
	 * 查询所有试题
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Topic> getAllTopic(){
		String queryString="from Topic where 1=1";
		return (List<Topic>) getHibernateTemplate().find(queryString);
	}
	
	public void delete(Integer topicId){
		String hql = "delete from Topic topic where topic.topicId='"+topicId+"'";
		this.getHibernateTemplate().bulkUpdate(hql);
	}
	
	/**
	 * 查询所有题库名称 2019.12.29 16.50
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getTopicBankNameAll() {
		// TODO Auto-generated method stub
		String queryString="select topicBankName from TopicBank where 1=1";
		return (List<String>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 根据题库id查询试题列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Topic> getlistByTopicBankName(Topic topic, int page, int row,String topicBankName){
		String queryString="from Topic where 1=1 and topicBankName = '"+topicBankName+"'";//此处的Topic为实体类的名字而不是表的名字
		int start=(page-1)*row;
		int limit =row;
		return (Result<Topic>)super.find(queryString, null, null, start, limit);
	 }
	
}

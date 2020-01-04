package com.gxuwz.Market.business.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.FillTopic;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

@Repository("fillTopicDAO")
public class FillTopicDAO extends BaseDaoImpl<FillTopic>{
	
	/**
	 * 根据条件查找分页
	 * @param SysRole 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<FillTopic> find(FillTopic fillTopic, int page, int row){
		String queryString="from FillTopic where 1=1";
		if(null !=fillTopic.getId()){
			queryString = queryString +" and id like '%"+fillTopic.getId() +"%' ";
		}
		else if(null != fillTopic.getDescription()){
			queryString = queryString + " and description like '%"+fillTopic.getDescription()+"%'";
		}
		else if(null != fillTopic.getTopicBankName()){
			queryString = queryString + "and topicBankName like '%"+ fillTopic.getTopicBankName() +"%'";
		}
		int start=(page-1)*row;
		int limit =row;
		return (Result<FillTopic>)super.find(queryString, null, null, start, limit);
	}
	/**
	 * 查询所有试题
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<FillTopic> getAllTopic(){
		String queryString="from FillTopic where 1=1";
		return (List<FillTopic>) getHibernateTemplate().find(queryString);
	}
	
	public void delete(Integer id){
		String hql = "delete from FillTopic fillTopic where fillTopic.id='"+id+"'";
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
	public Result<FillTopic> getlistByTopicBankName(FillTopic fillTopic, int page, int row,String topicBankName){
		String queryString="from FillTopic where 1=1 and topicBankName = '"+topicBankName+"'";//此处的Topic为实体类的名字而不是表的名字
		int start=(page-1)*row;
		int limit =row;
		return (Result<FillTopic>)super.find(queryString, null, null, start, limit);
	 }
	
}

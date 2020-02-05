package com.gxuwz.Market.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

/**
 *<p>Title:ChoiceTopicDAO</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年1月4日下午4:49:16
 */
@Repository("choiceTopicDAO")
public class ChoiceTopicDAO extends BaseDaoImpl<ChoiceTopic>{

	/**
	 * 根据条件查找分页
	 * @param ChoiceTopic 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<ChoiceTopic> find(ChoiceTopic choiceTopic, int page, int row){
		String queryString="from ChoiceTopic where 1=1";
		if(null !=choiceTopic.getId()){
			queryString = queryString +" and id like '%"+choiceTopic.getId() +"%' ";
		}
		else if((null != choiceTopic.getDescription())&&(null != choiceTopic.getTopicBankName())){
			queryString = queryString + " and description like '%"+choiceTopic.getDescription()+"%'and topicBankName like '%"+ choiceTopic.getTopicBankName() +"%'";
		}
		int start=(page-1)*row;
		int limit =row;
		return (Result<ChoiceTopic>)super.find(queryString, null, null, start, limit);
	}
	
	/**
	 * 查询所有试题
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ChoiceTopic> getAllTopic(){
		String queryString="from ChoiceTopic where 1=1";
		return (List<ChoiceTopic>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 根据id删除试题
	 * @return
	 */
	public void delete(Integer id){
		String hql = "delete from ChoiceTopic choiceTopic where choiceTopic.id='"+id+"'";
		this.getHibernateTemplate().bulkUpdate(hql);
	}
	
	/**
	 * 查询所有题库名称 
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
	public Result<ChoiceTopic> getlistByTopicBankName(ChoiceTopic choiceTopic, int page, int row,String topicBankName){
		String queryString="from ChoiceTopic where 1=1 and topicBankName = '"+topicBankName+"'";//此处的Topic为实体类的名字而不是表的名字
		int start=(page-1)*row;
		int limit =row;
		return (Result<ChoiceTopic>)super.find(queryString, null, null, start, limit);
	 }
	
	/**
	 * 查询单选题数量
	 * @param topicBankId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public int getAllChoiceTopicNum(){
		String queryString="select count(*) from ChoiceTopic where 1=1";
		List list =(List)getHibernateTemplate().find(queryString);
		Number num = (Number) list.get(0);
		System.out.println("num.intValue()=="+num.intValue());
		return num.intValue();
	}
	
}

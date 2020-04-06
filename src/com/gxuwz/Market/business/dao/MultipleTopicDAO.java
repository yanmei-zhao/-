package com.gxuwz.Market.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.MultipleTopic;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

/**
 *<p>Title:MultipleTopicDAO</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年2月18日下午7:13:07
 */
@Repository("multipleTopicDAO")
public class MultipleTopicDAO extends BaseDaoImpl<MultipleTopic>{
	/**
	 * 根据条件查找分页
	 * @param MultipleTopic 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<MultipleTopic> find(MultipleTopic multipleTopic, int page, int row){
		String queryString="from MultipleTopic where 1=1";
		if(null !=multipleTopic.getId()){
			queryString = queryString +" and id like '%"+multipleTopic.getId() +"%' ";
		}
		else if((null != multipleTopic.getDescription())&&(null != multipleTopic.getTopicBankName())&&(null!=multipleTopic.getDifficulty())){
			queryString = queryString + " and description like '%"+multipleTopic.getDescription()+"%'and topicBankName like '%"+ multipleTopic.getTopicBankName() +"%'and difficulty like '%"+multipleTopic.getDifficulty()+"%'";
		}else if(null != multipleTopic.getDescription()){
			queryString = queryString +" and description like '%"+multipleTopic.getDescription() +"%' ";
		}
		int start=(page-1)*row;
		int limit =row;
		return (Result<MultipleTopic>)super.find(queryString, null, null, start, limit);
	}
	
	/**
	 * 查询所有试题
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<MultipleTopic> getAllTopic(){
		String queryString="from MultipleTopic where 1=1";
		return (List<MultipleTopic>) getHibernateTemplate().find(queryString);
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
	public Result<MultipleTopic> getlistByTopicBankName(MultipleTopic multipleTopic, int page, int row,String topicBankName){
		String queryString="from MultipleTopic where 1=1 and topicBankName = '"+topicBankName+"'";//此处的Topic为实体类的名字而不是表的名字
		int start=(page-1)*row;
		int limit =row;
		return (Result<MultipleTopic>)super.find(queryString, null, null, start, limit);
	 }
	
	/**
	 * 查询多选题数量
	 * @param topicBankId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public int getAllMultipleTopicNum(){
		String queryString="select count(*) from MultipleTopic where 1=1";
		List list =(List)getHibernateTemplate().find(queryString);
		Number num = (Number) list.get(0);
		return num.intValue();
	}

	/**
	 * 练习多选题
	 * @param MultipleTopic
	 * @param page1
	 * @param row1
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<MultipleTopic> find1(String difficulty, String topicBankName, String way,int page, int row1) {
		// TODO Auto-generated method stub
		String queryString;
		if(way.equals("顺序练习")){
			queryString="from MultipleTopic where difficulty='"+difficulty+"' and topicBankName = '"+topicBankName+"'order by rand()";
		}else{
			queryString="from MultipleTopic where difficulty='"+difficulty+"' and topicBankName = '"+topicBankName+"'";
		}
		int start=(page-1)*row1;
		int limit =row1;
		return (Result<MultipleTopic>)super.find(queryString, null, null, start, limit);
	}
}

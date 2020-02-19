package com.gxuwz.Market.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.JudgeTopic;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

/**
 *<p>Title:JudgeTopicDAO</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年2月18日下午7:12:57
 */
@Repository("judgeTopicDAO")
public class JudgeTopicDAO extends BaseDaoImpl<JudgeTopic>{
	/**
	 * 根据条件查找分页
	 * @param JudgeTopic 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<JudgeTopic> find(JudgeTopic judgeTopic, int page, int row){
		String queryString="from JudgeTopic where 1=1";
		if(null !=judgeTopic.getId()){
			queryString = queryString +" and id like '%"+judgeTopic.getId() +"%' ";
		}
		else if((null != judgeTopic.getDescription())&&(null != judgeTopic.getTopicBankName())&&(null!=judgeTopic.getDifficulty())){
			queryString = queryString + " and description like '%"+judgeTopic.getDescription()+"%'and topicBankName like '%"+ judgeTopic.getTopicBankName() +"%'and difficulty like '%"+judgeTopic.getDifficulty()+"%'";
		}else if(null != judgeTopic.getDescription()){
			queryString = queryString + " and description like '%"+judgeTopic.getDescription()+"%'";
		}
		int start=(page-1)*row;
		int limit =row;
		return (Result<JudgeTopic>)super.find(queryString, null, null, start, limit);
	}
	
	/**
	 * 查询所有试题
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<JudgeTopic> getAllTopic(){
		String queryString="from JudgeTopic where 1=1";
		return (List<JudgeTopic>) getHibernateTemplate().find(queryString);
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
	public Result<JudgeTopic> getlistByTopicBankName(JudgeTopic judgeTopic, int page, int row,String topicBankName){
		String queryString="from JudgeTopic where 1=1 and topicBankName = '"+topicBankName+"'";//此处的Topic为实体类的名字而不是表的名字
		int start=(page-1)*row;
		int limit =row;
		return (Result<JudgeTopic>)super.find(queryString, null, null, start, limit);
	 }
	
	/**
	 * 查询判断题数量
	 * @param topicBankId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public int getAllChoiceTopicNum(){
		String queryString="select count(*) from JudgeTopic where 1=1";
		List list =(List)getHibernateTemplate().find(queryString);
		Number num = (Number) list.get(0);
		return num.intValue();
	}

	/**
	 * 练习判断题
	 * @param judgeTopic
	 * @param page1
	 * @param row1
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<JudgeTopic> find1(String difficulty, String topicBankName, int page, int row1) {
		// TODO Auto-generated method stub
		String queryString="from JudgeTopic where difficulty='"+difficulty+"' and topicBankName = '"+topicBankName+"'";
		int start=(page-1)*row1;
		int limit =row1;
		return (Result<JudgeTopic>)super.find(queryString, null, null, start, limit);
	}
}

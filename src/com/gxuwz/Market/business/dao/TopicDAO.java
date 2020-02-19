package com.gxuwz.Market.business.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.entity.FillTopic;
import com.gxuwz.Market.business.entity.JudgeTopic;
import com.gxuwz.Market.business.entity.MultipleTopic;
import com.gxuwz.Market.business.entity.TestPaperTopic;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;


/**
 *<p>Title:TopicDAO</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年1月3日下午7:27:22
 */
@Repository("topicDAO")
public class TopicDAO extends BaseDaoImpl<Topic>{
	@Resource
	protected SessionFactory sessionFactory;
	@Resource
	private TopicDAO topicDAO;
	/**
	 * 根据条件查找分页
	 * @param Topic 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Topic> find(Topic topic, int page, int row){
		String queryString="from Topic where 1=1";
		if(null !=topic.getId()){
			queryString = queryString +" and id like '%"+topic.getId() +"%' ";
		}
		else if((null != topic.getDescription())&&(null != topic.getTopicBankName())&&(null!=topic.getDifficulty())){
			queryString = queryString + " and description like '%"+topic.getDescription()+"%' and topicBankName like '%"+ topic.getTopicBankName() +"%'and difficulty like '%"+topic.getDifficulty()+"%'";
		}else if(null != topic.getDescription()){
			queryString = queryString + " and description like '%"+topic.getDescription()+"%' ";
		}
		int start=(page-1)*row;
		int limit =row;
		return (Result<Topic>)super.find(queryString, null, null, start, limit);
	}
	
	/**
	 * 练习简答题
	 * @param topic
	 * @param page
	 * @param row
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Topic> find1(String difficulty, String topicBankName, int page, int row1) {
		// TODO Auto-generated method stub
		String queryString="from Topic where difficulty= '"+difficulty+"' and topicBankName='"+topicBankName+"'";
		int start=(page-1)*row1;
		int limit =row1;
		return (Result<Topic>)super.find(queryString, null, null, start, limit);
	}
	
	/**
	 * 查询所有简答题
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Topic> getAllTopic(){
		String queryString="from Topic where 1=1";
		return (List<Topic>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 查询所有选择题
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ChoiceTopic> getAllChoiceTopic(){
		String queryString="from ChoiceTopic where 1=1";
		return (List<ChoiceTopic>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 查询所有填空题
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<FillTopic> getAllFillTopic(){
		String queryString="from FillTopic where 1=1";
		return (List<FillTopic>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 查询所有多选题
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<MultipleTopic> getAllMultipleTopic(){
		String queryString="from MultipleTopic where 1=1";
		return (List<MultipleTopic>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 查询所有判断题
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<JudgeTopic> getAllJudgeTopic(){
		String queryString="from JudgeTopic where 1=1";
		return (List<JudgeTopic>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 根据id删除试题
	 * @return
	 */
	public void delete(Integer id){
		String hql = "delete from Topic topic where topic.id='"+id+"'";
		this.getHibernateTemplate().bulkUpdate(hql);
	}
	
	/**
	 * 查询所有单选题库名称 2019.12.29 16.50
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getChoiceTopicBankNameAll() {
		// TODO Auto-generated method stub
		String topicBankType = "单选题";
		String queryString="select topicBankName from TopicBank where topicBankType = '"+topicBankType+"' ";
		return (List<String>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 查询所有简答题库名称 2019.12.29 16.50
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getTopicBankNameAll() {
		// TODO Auto-generated method stub
		String topicBankType = "简答题";
		String queryString="select topicBankName from TopicBank where topicBankType = '"+topicBankType+"' ";
		return (List<String>) getHibernateTemplate().find(queryString);
	}

	/**
	 * 查询所有填空题库名称 2019.12.29 16.50
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getFillTopicBankNameAll() {
		// TODO Auto-generated method stub
		String topicBankType = "填空题";
		String queryString="select topicBankName from TopicBank where topicBankType = '"+topicBankType+"' ";
		return (List<String>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 查询所有判断题库名称 12.29 16.53
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getJudgeTopicBankNameAll() {
		// TODO Auto-generated method stub
		String topicBankType = "判断题";
		String queryString="select topicBankName from TopicBank where topicBankType = '"+topicBankType+"' ";
		return (List<String>) getHibernateTemplate().find(queryString);
	}

	/**
	 * 查询所有多选题库名称 12.29 16.53
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getMultipleTopicBankNameAll() {
		// TODO Auto-generated method stub
		String topicBankType = "多选题";
		String queryString="select topicBankName from TopicBank where topicBankType = '"+topicBankType+"' ";
		return (List<String>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 根据题库id查询单选题列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<ChoiceTopic> getChoicelistByTopicBankId(ChoiceTopic choiceTopic, int page, int row,int topicBankId){
		String queryString="from ChoiceTopic where 1=1 and topicBankId = '"+topicBankId+"'";//此处的Topic为实体类的名字而不是表的名字
		int start=(page-1)*row;
		int limit =row;
		return (Result<ChoiceTopic>)super.find(queryString, null, null, start, limit);
	 }

	/**
	 * 根据题库id查询填空题列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<FillTopic> getFilllistByTopicBankId(FillTopic fillTopic, int page, int row,int topicBankId){
		String queryString="from FillTopic where 1=1 and topicBankId = '"+topicBankId+"'";//此处的Topic为实体类的名字而不是表的名字
		int start=(page-1)*row;
		int limit =row;
		return (Result<FillTopic>)super.find(queryString, null, null, start, limit);
	 }
	
	/**
	 * 根据题库id查询简答题列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Topic> getlistByTopicBankId(Topic topic, int page, int row,int topicBankId){
		String queryString="from Topic where 1=1 and topicBankId = '"+topicBankId+"'";//此处的Topic为实体类的名字而不是表的名字
		int start=(page-1)*row;
		int limit =row;
		return (Result<Topic>)super.find(queryString, null, null, start, limit);
	 }
	
	/**
	 * 根据题库id查询多选题列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<MultipleTopic> getMultiplelistByTopicBankId(MultipleTopic multipleTopic, int page, int row,int topicBankId){
		String queryString="from MultipleTopic where 1=1 and topicBankId = '"+topicBankId+"'";//此处的Topic为实体类的名字而不是表的名字
		int start=(page-1)*row;
		int limit =row;
		return (Result<MultipleTopic>)super.find(queryString, null, null, start, limit);
	 }
	
	/**
	 * 根据题库id查询判断题列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<JudgeTopic> getJudgelistByTopicBankId(JudgeTopic judgeTopic, int page, int row,int topicBankId){
		String queryString="from JudgeTopic where 1=1 and topicBankId = '"+topicBankId+"'";//此处的JudgeTopic为实体类的名字而不是表的名字
		int start=(page-1)*row;
		int limit =row;
		return (Result<JudgeTopic>)super.find(queryString, null, null, start, limit);
	 }
	
	/**
	 * 查询简答题数量
	 * @param topicBankId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public int getAllTopicNum(){
		String queryString="select count(*) from Topic where 1=1";
		List list =(List)getHibernateTemplate().find(queryString);
		Number num = (Number) list.get(0);
		return num.intValue();
	}
	
	/**
	 * 随机抽题（组卷）
	 * @param testpaper
	 * @param choiceTopicNum
	 * @param fillTopicNum
	 * @param topicNum
	 * @param judgeTopicNum
	 * @param MultipleTopicNum
	 */
	public void composeExamRandom(Testpaper testpaper, int choiceTopicNum, int fillTopicNum, int topicNum,int judgeTopicNum,int MultipleTopicNum) {
		// TODO Auto-generated method stub
		//获取题库各题型题目
		List<ChoiceTopic> listChoice = topicDAO.getAllChoiceTopic();
		List<FillTopic> listBlankFilling = topicDAO.getAllFillTopic();
		List<Topic> listTopic = topicDAO.getAllTopic();
		List<JudgeTopic> listJudge = topicDAO.getAllJudgeTopic();
		List<MultipleTopic> listMultiple = topicDAO.getAllMultipleTopic();
		
		List<ChoiceTopic> listChoiceExtracted = extractRandomQuestions(listChoice,choiceTopicNum);
		List<FillTopic> listBlankFillingExtracted = extractRandomQuestions(listBlankFilling,fillTopicNum);
		List<Topic> listTopicExtracted = extractRandomQuestions(listTopic,topicNum);
		List<JudgeTopic> listJudgeExtracted = extractRandomQuestions(listJudge,judgeTopicNum);
		List<MultipleTopic> listMultipleExtracted = extractRandomQuestions(listMultiple,MultipleTopicNum);
		
		logger.debug("listChoiceExtracted="+listChoiceExtracted);
		logger.debug("listBlankFillingExtracted="+listBlankFillingExtracted);
		logger.debug("listJudgeExtracted="+listJudgeExtracted);
		logger.debug("listJudgeExtracted="+listJudgeExtracted);
		logger.debug("listMultipleExtracted="+listMultipleExtracted);
	
		for(ChoiceTopic q:listChoiceExtracted){
			String topicType = "选择题";
			int score=0;	/*score此句是为了先应付错误*/
			topicDAO.save1(new TestPaperTopic(testpaper.getTestpaperId(),null,q.getId(),null,null,null,topicType,score));
		}
		for(FillTopic q:listBlankFillingExtracted){
			String topicType = "填空题";
			int score=0;
			topicDAO.save1(new TestPaperTopic(testpaper.getTestpaperId(),null,null,q.getId(),null,null,topicType,score));
		}
		for(Topic q:listTopicExtracted){
			String topicType = "简答题";
			int score=0;
			topicDAO.save1(new TestPaperTopic(testpaper.getTestpaperId(),q.getId(),null,null,null,null,topicType,score));
		}
		for(JudgeTopic q:listJudgeExtracted){
			String topicType = "判断题";
			int score=0;
			topicDAO.save1(new TestPaperTopic(testpaper.getTestpaperId(),null,null,null,q.getId(),null,topicType,score));
		}
		for(MultipleTopic q:listMultipleExtracted){
			String topicType = "多选题";
			int score=0;
			topicDAO.save1(new TestPaperTopic(testpaper.getTestpaperId(),null,null,null,null,q.getId(),topicType,score));
		}
	}
	
	/*
	 * 从某类型（填空、选择、判断）题目list中随机抽取num个不重复的题
	 */
	private static <T> List<T> extractRandomQuestions(List<T> list,int num){
		int szOriginal = list.size();
		List<T> listExtracted = new ArrayList<>();
		if(szOriginal >= num){
			Random random = new Random();
			for(int i=0; i<num; i++){
				T q=list.get(random.nextInt(szOriginal-i));
				listExtracted.add(q);
				list.remove(q);
			}
		}else{
			System.out.println("抽取的试题数量过多");
		}
		return listExtracted;
	}

	
}

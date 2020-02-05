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
		else if((null != topic.getDescription())&&(null != topic.getTopicBankName())){
			queryString = queryString + " and description like '%"+topic.getDescription()+"%' and topicBankName like '%"+ topic.getTopicBankName() +"%'";
		}
		int start=(page-1)*row;
		int limit =row;
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
	 * 查询简答题数量
	 * @param topicBankId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public int getAllTopicNum(){
		String queryString="select count(*) from Topic where 1=1";
		List list =(List)getHibernateTemplate().find(queryString);
		Number num = (Number) list.get(0);
		System.out.println("num.intValue()=="+num.intValue());
		return num.intValue();
	}
	
	/**
	 * 随机抽题（组卷）
	 * @param testpaper
	 * @param choiceTopicNum
	 * @param fillTopicNum
	 * @param topicNum
	 */
	public void composeExamRandom(Testpaper testpaper, int choiceTopicNum, int fillTopicNum, int topicNum) {
		// TODO Auto-generated method stub
		//获取题库各题型题目
		List<ChoiceTopic> listChoice = topicDAO.getAllChoiceTopic();
		List<FillTopic> listBlankFilling = topicDAO.getAllFillTopic();
		List<Topic> listTopic = topicDAO.getAllTopic();
		
		List<ChoiceTopic> listChoiceExtracted = extractRandomQuestions(listChoice,choiceTopicNum);
		List<FillTopic> listBlankFillingExtracted = extractRandomQuestions(listBlankFilling,fillTopicNum);
		List<Topic> listJudgeExtracted = extractRandomQuestions(listTopic,topicNum);
		
		logger.debug("listChoiceExtracted="+listChoiceExtracted);
		logger.debug("listBlankFillingExtracted="+listBlankFillingExtracted);
		logger.debug("listJudgeExtracted="+listJudgeExtracted);
		
		for(ChoiceTopic q:listChoiceExtracted){
			String topicType = "选择题";
			topicDAO.save1(new TestPaperTopic(testpaper.getTestpaperId(),null,q.getId(),null,topicType));
		}
		for(FillTopic q:listBlankFillingExtracted){
			String topicType = "填空题";
			topicDAO.save1(new TestPaperTopic(testpaper.getTestpaperId(),null,null,q.getId(),topicType));
		}
		for(Topic q:listJudgeExtracted){
			String topicType = "简答题";
			topicDAO.save1(new TestPaperTopic(testpaper.getTestpaperId(),q.getId(),null,null,topicType));
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
//			logger.debug("抽取的题目数量:"+num+"，超过了题库中的该题型["
//								+list.get(0).getClass().getSimpleName()+"]的题目数:"
//								+szOriginal+"，该题型暂不抽题");
			System.out.println("抽取的试题数量过多");
		}
		System.out.println("listExtracted=="+listExtracted);
		return listExtracted;
	}

	
}

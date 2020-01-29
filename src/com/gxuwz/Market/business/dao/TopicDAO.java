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
		else if(null != topic.getDescription()){
			queryString = queryString + " and description like '%"+topic.getDescription()+"%'";
		}
		else if(null != topic.getTopicBankName()){
			queryString = queryString + "and topicBankName like '%"+ topic.getTopicBankName() +"%'";
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

	/**
	 * 随机组卷
	 * @param testpaper
	 * @param choiceTopicNum
	 * @param fillTopicNum
	 * @param topicNum
	 */
	public void composeExamRandom(Testpaper testpaper, int choiceTopicNum, int fillTopicNum, int topicNum) {
		// TODO Auto-generated method stub
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
			topicDAO.save1(new TestPaperTopic(testpaper.getTestpaperId(),null,q.getId(),null));
		}
		for(FillTopic q:listBlankFillingExtracted){
			topicDAO.save1(new TestPaperTopic(testpaper.getTestpaperId(),null,null,q.getId()));
		}
		for(Topic q:listJudgeExtracted){
			topicDAO.save1(new TestPaperTopic(testpaper.getTestpaperId(),q.getId(),null,null));
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
	
	/**
	 * 1.28新加的
	 * @param composeFlag
	 * @return
	 
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<ChoiceTopic> findChoiceWithComposeFlag(int composeFlag) {
		Query q = sessionFactory.getCurrentSession().createQuery("from BankChoiceQuestion where composeFlag=:c0");
		q.setInteger("c0", composeFlag);
		@SuppressWarnings("unchecked")
		List<ChoiceTopic> list=(List<ChoiceTopic>)(q.list());
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<FillTopic> findBlankFillingWithComposeFlag(int composeFlag) {
		Query q = sessionFactory.getCurrentSession().createQuery("from BankBlankFillingQuestion where composeFlag=:c0");
		q.setInteger("c0", composeFlag);
		@SuppressWarnings("unchecked")
		List<FillTopic> list=(List<FillTopic>)(q.list());
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Topic> findJudgeWithComposeFlag(int composeFlag) {
		Query q = sessionFactory.getCurrentSession().createQuery("from BankJudgeQuestion where composeFlag=:c0");
		q.setInteger("c0", composeFlag);
		@SuppressWarnings("unchecked")
		List<Topic> list=(List<Topic>)(q.list());
		return list;
	}
	*/
	
}

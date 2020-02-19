package com.gxuwz.Market.business.dao;



import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.entity.FillTopic;
import com.gxuwz.Market.business.entity.JudgeTopic;
import com.gxuwz.Market.business.entity.MultipleTopic;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;


@Repository("TestpaperDAO")
public class TestpaperDAO extends BaseDaoImpl<Testpaper>{
	protected final Log logger = LogFactory.getLog(getClass());
	
	/**
	 * 根据条件查找分页
	 * @param SysRole 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Testpaper> find(Testpaper testpaper, int page, int row){
		String queryString="from Testpaper where 1=1";
//		if(null != testpaper.getTestpaperId()){
//			queryString = queryString + " and testpaperId like '%"+testpaper.getTestpaperId()+"%'";
//		}
		if(null != testpaper.getTestpaperName()){
			queryString = queryString + " and testpaperName like '%"+testpaper.getTestpaperName()+"%'";
		}
		int start=(page-1)*row;
		int limit =row;
		return (Result<Testpaper>)super.find(queryString, null, null, start, limit);
	}
	
	/**
	 * 查询所有的试卷名称
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Testpaper> getAllTestpaper(){
		String queryString="from Testpaper where 1=1";
		return (List<Testpaper>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 查询所有试卷名称
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getTestpaperNameAll() {
		// TODO Auto-generated method stub
		String queryString="select testpaperName from Testpaper where 1=1";
	    return (List<String>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 *  通过试卷id查询单选题id展示试卷
	 * @param testpaperId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<ChoiceTopic> getAllChoiceTopic(Integer testpaperId, int page, int row){
		 String queryString="select distinct t2.description,t2.type,t2.optionA,t2.optionB,t2.optionC,t2.optionD,t2.id,t2.answer,t1.score from Testpaper t0,TestPaperTopic t1,ChoiceTopic t2 where t0.testpaperId = t1.testpaperId "
		 		+ "and t1.testpaperId=" + " '"+testpaperId+"' and t1.choicetopicId = t2.id"; 
		 int start=(page-1)*row;
		 int limit =row;
		 return (Result<ChoiceTopic>) super.find(queryString, null, null, start, limit);
	}
	
	/**
	 *  通过试卷id查询填空题id展示试卷
	 * @param testpaperId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<FillTopic> getAllFillTopic(Integer testpaperId, int page, int row){
		 String queryString="select distinct t2.description,t2.type,t2.id,t2.answer,t1.score from Testpaper t0,TestPaperTopic t1,FillTopic t2 where t0.testpaperId = t1.testpaperId "
		 		+ "and t1.testpaperId=" + " '"+testpaperId+"' and t1.filltopicId = t2.id"; 
		 int start=(page-1)*row;
		 int limit =row;
		 return (Result<FillTopic>) super.find(queryString, null, null, start, limit);
	}
	
	/**
	 *  通过试卷id查询简答题id展示试卷
	 * @param testpaperId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Topic> getAllTopic(Integer testpaperId, int page, int row){
		 String queryString="select distinct t2.description,t2.type,t2.id,t2.answer,t1.score from Testpaper t0,TestPaperTopic t1,Topic t2 where t0.testpaperId = t1.testpaperId "
		 		+ "and t1.testpaperId=" + " '"+testpaperId+"' and t1.topicId = t2.id"; 
		 int start=(page-1)*row;
		 int limit =row;
		 return (Result<Topic>) super.find(queryString, null, null, start, limit);
	}
	
	/**
	 *  通过试卷id查询判断题id展示试卷
	 * @param testpaperId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<JudgeTopic> getAllJudgeTopic(Integer testpaperId, int page, int row) {
		// TODO Auto-generated method stub
		 String queryString="select distinct t2.description,t2.type,t2.id,t2.answer,t1.score from Testpaper t0,TestPaperTopic t1,JudgeTopic t2 where t0.testpaperId = t1.testpaperId "
			 		+ "and t1.testpaperId=" + " '"+testpaperId+"' and t1.judgetopicId = t2.id"; 
		 int start=(page-1)*row;
		 int limit =row;
		 return (Result<JudgeTopic>) super.find(queryString, null, null, start, limit);
	}
	
	/**
	 *  通过试卷id查询多选题id展示试卷
	 * @param testpaperId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<MultipleTopic> getAllMultipleTopic(Integer testpaperId, int page, int row) {
		// TODO Auto-generated method stub
		String queryString="select distinct t2.description,t2.type,t2.optionA,t2.optionB,t2.optionC,t2.optionD,t2.id,t2.answer,t1.score from Testpaper t0,TestPaperTopic t1,MultipleTopic t2 where t0.testpaperId = t1.testpaperId "
		 		+ "and t1.testpaperId=" + " '"+testpaperId+"' and t1.multipletopicId = t2.id"; 
		 int start=(page-1)*row;
		 int limit =row;
		 return (Result<MultipleTopic>) super.find(queryString, null, null, start, limit);
	}
	
	/**
	 * 查询试卷数量
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public int gettestPaperNum(){
		String queryString="select count(*) from Testpaper where 1=1";
		List list =(List)getHibernateTemplate().find(queryString);
		Number num = (Number) list.get(0);
		return num.intValue();
	}
	
	/**根据试卷id查询试卷
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Testpaper> findById(int testpaperId){
		String queryString = "from Testpaper where testpaperId = '"+testpaperId;
		return (List<Testpaper>) this.getHibernateTemplate().find(queryString);
	}
	
//	public List<String> getAllTopicId(Integer testpaperId){
//	 List b = new ArrayList();
//	 List c = new ArrayList();  //  用来存题目的数组
//	// List d = new ArrayList();  //用来判断题目类型的数
//  String queryString="select topicId from TestPaperTopic where testpaperId= '"+testpaperId+"'";
//  List<Testpaper> list = (List<Testpaper>) getHibernateTemplate().find(queryString);
//                         
//  for(Testpaper testpaper:list){
//	   if(list.size()>0){
//	   List a = new ArrayList();
//    {
//      a.add(testpaper.getTopicId());
//   //   System.out.println(a.get(0));
//      }
//      b.addAll(a);  
//      } 
//  }
//
// for(int i=0;b.size()>i;i++){
//	  // Object a = b.get(i);
//	 //  String a1 = (String)a;
//  String hql2="from Topic where topicId= '"+b.get(i)+"'";
//  List<ChoiceTopic> list2 = (List<ChoiceTopic>) getHibernateTemplate().find(hql2);
// 
// for(ChoiceTopic topic:list2){
//	   List a2 = new ArrayList();
//	   if(list2.size()>0){
//		   a2.add(topic.getDescription());
//		   a2.add(topic.getOptionA());
//		   a2.add(topic.getOptionB());
//		   a2.add(topic.getOptionC());
//		   a2.add(topic.getOptionD());
//		   System.out.println(a2.get(1));
//		 }  
//	   c.addAll(a2);
//	   }
//	  }
//return c;  
//  }
//
}

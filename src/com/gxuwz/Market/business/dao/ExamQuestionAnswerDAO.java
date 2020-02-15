package com.gxuwz.Market.business.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.Examquestionanswer;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.core.dao.impl.BaseDaoImpl;

/**
 * 
 *<p>Title:ExamQuestionAnswerDAO</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年2月1日下午4:50:38
 */
@Repository("ExamQuestionAnswerDAO")
public class ExamQuestionAnswerDAO extends BaseDaoImpl<Examquestionanswer>{
	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * 查询各题型分值
	 */
	public Testpaper getAllScore(int examId){
		String queryString = "from Testpaper where testpaperName = (select examName from Exam where examId="+examId+")";
		return (Testpaper) this.getHibernateTemplate().find(queryString).get(0);
	}

	/**
	 * 查询单选题答案
	 * @param studentId
	 * @param topicId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getAllChoiceAnswer(int studentId, int topicId,int examId) {
		// TODO Auto-generated method stub
//		String queryString="select distinct t1.answer,t1.type,t0.answer from Examquestionanswer t0,ChoiceTopic t1  where t0.studentId = "+studentId+" and t0.topicId = t1.id and t0.topicId="+topicId;
		String queryString="select distinct t1.answer,t1.type,t0.answer,t2.score from Examquestionanswer t0,ChoiceTopic t1,TestPaperTopic t2  where t0.studentId = "+studentId+" and t0.topicId = t1.id and t0.topicId="+topicId+"and t2.choicetopicId = t0.topicId and t2.testpaperId=(select testPaperId from Exam where examId="+examId+")";
		return (List<String>) getHibernateTemplate().find(queryString);
	}

	/**
	 * 查询填空题答案
	 * @param studentId
	 * @param topicId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getAllFillAnswer(int studentId, int topicId,int examId) {
		// TODO Auto-generated method stub
//		String queryString="select distinct t1.answer,t1.type,t0.answer from Examquestionanswer t0,FillTopic t1  where t0.studentId = "
//				+studentId+" and t0.topicId = t1.id and t0.topicId="+topicId; 
		String queryString="select distinct t1.answer,t1.type,t0.answer,t2.score from Examquestionanswer t0,FillTopic t1,TestPaperTopic t2  where t0.studentId = "+studentId+" and t0.topicId = t1.id and t0.topicId="+topicId+"and t2.filltopicId = t0.topicId and t2.testpaperId=(select testPaperId from Exam where examId="+examId+")";
		return (List<String>) getHibernateTemplate().find(queryString);
	}

	/**
	 * 查询简答题答案
	 * @param studentId
	 * @param topicId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getAllTopicAnswer(int studentId, int topicId,int examId) {
		// TODO Auto-generated method stub
//		String queryString="select distinct t1.answer,t1.type,t0.answer from Examquestionanswer t0,Topic t1  where t0.studentId = "
//				+studentId+" and t0.topicId = t1.id and t0.topicId="+topicId; 
		String queryString="select distinct t1.answer,t1.type,t0.answer,t2.score from Examquestionanswer t0,Topic t1,TestPaperTopic t2  where t0.studentId = "+studentId+" and t0.topicId = t1.id and t0.topicId="+topicId+"and t2.topicId = t0.topicId and t2.testpaperId=(select testPaperId from Exam where examId="+examId+")";
		return (List<String>) getHibernateTemplate().find(queryString);
	}
	
}

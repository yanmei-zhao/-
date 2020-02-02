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
	 * 查询选择题正确答案`
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public List<String> getAllAnswer(int studentId,int topicId){
		//查询试卷id
//		String queryString = "select testpaperId from Testpaper where testpaperName = (select t0.examName from Exam t0,Examquestionanswer t1 where t0.examId= t1.examId and t0.examId=" +examId+")";
//		String queryString="select distinct t1.answer,t1.type,t0.answer from Examquestionanswer t0,ChoiceTopic t1  where t0.studentId = "
//				+studentId+" and t0.topicId = t1.id and t0.topicId="+topicId+" union select distinct t1.answer,t1.type,t0.answer from Examquestionanswer t0,FillTopic t1  where t0.studentId = "
//				+studentId+" and t0.topicId = t1.id and t0.topicId="+topicId+" union select distinct t1.answer,t1.type,t0.answer from Examquestionanswer t0,Topic t1  where t0.studentId = "
//				+studentId+" and t0.topicId = t1.id and t0.topicId="+topicId  ;
		String queryString="select distinct t1.answer,t1.type from Examquestionanswer t0,ChoiceTopic t1  where t0.student_id = "
				+studentId+" and t0.topic_id = t1.id and t0.topic_id="+topicId+" union select distinct t1.answer,t1.type from Examquestionanswer t0,FillTopic t1  where t0.student_id = "
				+studentId+" and t0.topic_id = t1.id and t0.topic_id="+topicId+" union select distinct t1.answer,t1.type from Examquestionanswer t0,Topic t1 where t0.student_id = "
				+studentId+" and t0.topic_id = t1.id and t0.topic_id="+topicId  ;
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery(queryString);
		List<String> list = query.list(); 
		return list;
	}
	
	/**
	 * 查询各题型分值
	 */
	public Testpaper getAllScore(int examId){
		//String queryString = "select t0.choicePerScore,t0.fillPerScore,t0.topicPerScore from Testpaper t0,Exam t1 where t1.examId="+examId+"and t0.testpaperName = t1.examName";
//		return (List<String>) getHibernateTemplate().find(queryString);
		//String queryString = "select t0.choicePerScore,t0.fillPerScore,t0.topicPerScore from Testpaper t0,Exam t1 where t1.examId="+examId+"and t0.testpaperName = t1.examName";
//		String queryString1 = "select t0.* from Testpaper t0,Exam t1 where t1.examId="+examId+"and t0.testpaperName = t1.examName";
		String queryString = "from Testpaper where testpaperName = (select examName from Exam where examId="+examId+")";
		return (Testpaper) this.getHibernateTemplate().find(queryString).get(0);
	}
	
//	public void testopenSession() {
//		//获得配置对象
//		Configuration config=new Configuration().configure();
//		//获得服务注册对象
//		SessionFactory sessionFactory=config.buildSessionFactory();
//		Session session=sessionFactory.openSession();
//	}
}

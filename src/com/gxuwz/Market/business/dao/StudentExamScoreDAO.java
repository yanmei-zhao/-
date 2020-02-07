package com.gxuwz.Market.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.Group;
import com.gxuwz.Market.business.entity.Studentexamscore;
import com.gxuwz.Market.business.entity.Studentscore;
import com.gxuwz.Market.business.entity.Teacher;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;
/**
 * 
 *<p>Title:StudentExamScoreDAO</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年2月2日下午5:30:25
 */
@Repository("StudentExamScoreDAO")
public class StudentExamScoreDAO extends BaseDaoImpl<Studentexamscore>{

	/**
	 * 学生端查询成绩
	 * @param studentExamScore
	 * @param studentId
	 * @param page
	 * @param row
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Studentexamscore> find(Studentexamscore studentExamScore,int studentId, int page, int row) {
		// TODO Auto-generated method stub
		String q = "最终得分";
		String queryString="from Studentexamscore where 1=1 and studentId = "+studentId +" and examPhase = '"+q+"'";
		if(null != studentExamScore.getExamName()){
			queryString = queryString + " and examName like '%"+studentExamScore.getExamName()+"%'";
		}
		int start=(page-1)*row;
		int limit =row;
		return (Result<Studentexamscore>)super.find(queryString, null, null, start, limit);
	}
	
	/**
	 * 查询成绩最高分
	 * @return
	 */
	public int getMaxScore(String testpaperName){
		String queryString="select max(t0.score) from Studentexamscore t0,Exam t1,Testpaper t2 where t0.examId = t1.examId and t1.testPaperId = t2.testpaperId and t0.examName = '"+testpaperName+"'";
		List list =(List)getHibernateTemplate().find(queryString);
		Number num = (Number) list.get(0);
		return num.intValue();
	}
	
	/**
	 * 查询成绩最低分
	 * @return
	 */
	public int getMinScore(String testpaperName){
		String queryString="select min(t0.score) from Studentexamscore t0,Exam t1,Testpaper t2 where t0.examId = t1.examId and t1.testPaperId = t2.testpaperId and t0.examName = '"+testpaperName+"'";
		List list =(List)getHibernateTemplate().find(queryString);
		Number num = (Number) list.get(0);
		return num.intValue();
	}
	
	/**
	 * 查询成绩最低分
	 * @return
	 */
	public int getAvgScore(String testpaperName){
		String queryString="select avg(t0.score) from Studentexamscore t0,Exam t1,Testpaper t2 where t0.examId = t1.examId and t1.testPaperId = t2.testpaperId and t0.examName = '"+testpaperName+"'";
		List list =(List)getHibernateTemplate().find(queryString);
		Number num = (Number) list.get(0);
		return num.intValue();
	}
	
	/**
	 *  通过试卷id查询单选题id展示已交卷的试卷
	 * @param testpaperId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Studentscore> getAllChoiceTopic(int studentId,int examId, int page, int row){
		 String queryString="select t0.answer,t1.answer,t1.description,t0.topicId,t1.optionA,t1.optionB,t1.optionC,t1.optionD,t0.studentId,t0.examId from Examquestionanswer t0,ChoiceTopic t1 where t0.topicId = t1.id and t0.studentId="+studentId+"and t0.examId="+examId; 
			int start=(page-1)*row;
			int limit =row;
			return (Result<Studentscore>)super.find(queryString, null, null, start, limit);
	}
	
	/**
	 *  通过试卷id查询填空题id展示已交卷的试卷
	 * @param testpaperId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Studentscore> getAllFillTopic(int studentId,int examId,int page, int row){
		 String queryString="select t0.answer,t1.answer,t1.description,t0.topicId from Examquestionanswer t0,FillTopic t1 where t0.topicId = t1.id and t0.studentId="+studentId+"and t0.examId="+examId; 
			int start=(page-1)*row;
			int limit =row;
			return (Result<Studentscore>)super.find(queryString, null, null, start, limit);
	}
	
	/**
	 *  通过试卷id查询简答题id展示已交卷的试卷
	 * @param testpaperId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Studentscore> getAllTopic(int studentId,int examId,int page, int row){
		 String queryString="select t0.answer,t1.answer,t1.description,t0.topicId from Examquestionanswer t0,Topic t1 where t0.topicId = t1.id and t0.studentId="+studentId+"and t0.examId="+examId; 
			int start=(page-1)*row;
			int limit =row;
			return (Result<Studentscore>)super.find(queryString, null, null, start, limit);
	}
	
	/**根据考试id和学生id查询成绩
	 * @return
	 */
	public Studentexamscore findById(int studentId,int examId) {
		// TODO Auto-generated method stub
		String queryString="from Studentexamscore where studentId ="+studentId+"and examId="+examId;
		return (Studentexamscore) this.getHibernateTemplate().find(queryString).get(0);
	}
	
//	@SuppressWarnings("unchecked")
//	public List<Studentexamscore> findById(int studentId,int examId){
//		String queryString = "from Studentexamscore where studentId = '"+studentId+"and examId="+studentId;
//		return (List<Studentexamscore>) this.getHibernateTemplate().find(queryString);
//	}
}

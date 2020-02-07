package com.gxuwz.Market.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.Group;
import com.gxuwz.Market.business.entity.Studentexamscore;
import com.gxuwz.Market.business.entity.Studentscore;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

/**
 * 
 *<p>Title:StudentScoreDAO</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年2月3日下午9:48:56
 */
@Repository("StudentScoreDAO")
public class StudentScoreDAO extends BaseDaoImpl<Studentscore>{

	/**
	 * 查询学生最终成绩（教师端）
	 * @param studentScore
	 * @param page
	 * @param row
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Studentscore> listAll(Studentscore studentScore, int page, int row) {
		// TODO Auto-generated method stub
		String q = "最终得分";
		String queryString="select t0.className,t0.studentNumber,t0.studentName,t0.grade,t1.examName,t1.score,t1.examPhase,t1.studentId,t1.examId from Student t0,Studentexamscore t1 where t0.studentId = t1.studentId and t1.examPhase = '"+q+"'";
		if((null != studentScore.getExamName())&&(null!=studentScore.getClassName()||null!=studentScore.getStudentName())){
			queryString = queryString + " and t1.examName like '%"+studentScore.getExamName()+"%'and t0.className like '%"+studentScore.getClassName()+"%'and t0.studentName like '%"+studentScore.getStudentName()+"%'";
		}
		int start=(page-1)*row;
		int limit =row;
		return (Result<Studentscore>)super.find(queryString, null, null, start, limit);
	}
	
	
	/**
	 * 查询待批改试卷（教师端）
	 * @param studentScore
	 * @param page
	 * @param row
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Studentscore> listCorrectAll(Studentscore studentScore, int page, int row) {
		// TODO Auto-generated method stub
		String q = "已交卷";
		String queryString="select t0.className,t0.studentNumber,t0.studentName,t0.grade,t1.examName,t1.score,t1.examPhase,t1.studentId,t1.examId from Student t0,Studentexamscore t1 where t0.studentId = t1.studentId and t1.examPhase = '"+q+"'";
		if((null != studentScore.getExamName())&&(null!=studentScore.getClassName()||null!=studentScore.getStudentName())){
			queryString = queryString + " and t1.examName like '%"+studentScore.getExamName()+"%'and t0.className like '%"+studentScore.getClassName()+"%'and t0.studentName like '%"+studentScore.getStudentName()+"%'";
		}
		int start=(page-1)*row;
		int limit =row;
		return (Result<Studentscore>)super.find(queryString, null, null, start, limit);
	}
	
	/**
	 * 导出所有学生成绩(教师端)
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> getAllScore() {
		// TODO Auto-generated method stub
		String queryString="select t0.className,t0.studentNumber,t0.studentName,t0.grade,t1.examName,t1.score from Student t0,Studentexamscore t1 where t0.studentId = t1.studentId";//此处的Group为实体类的名字而不是表的名字
		return (List<Object[]>) getHibernateTemplate().find(queryString);
	}
	
}

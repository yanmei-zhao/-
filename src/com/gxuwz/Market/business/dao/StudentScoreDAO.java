package com.gxuwz.Market.business.dao;

import org.springframework.stereotype.Repository;

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

	@SuppressWarnings("unchecked")
	public Result<Studentscore> listAll(Studentscore studentScore, int page, int row) {
		// TODO Auto-generated method stub
		System.out.println("studentScore.getClassName=="+studentScore.getStudentName());
		String queryString="select t0.className,t0.studentNumber,t0.studentName,t0.grade,t1.examName,t1.score from Student t0,Studentexamscore t1 where t0.studentId = t1.studentId";
		if((null != studentScore.getExamName())&&(null!=studentScore.getClassName()||null!=studentScore.getStudentName())){
			queryString = queryString + " and t1.examName like '%"+studentScore.getExamName()+"%'and t0.className like '%"+studentScore.getClassName()+"%'and t0.studentName like '%"+studentScore.getStudentName()+"%'";
		}
		System.out.println("queryString=="+queryString);
		int start=(page-1)*row;
		int limit =row;
		return (Result<Studentscore>)super.find(queryString, null, null, start, limit);
	}
	
}

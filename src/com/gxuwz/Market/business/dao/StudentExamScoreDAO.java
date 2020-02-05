package com.gxuwz.Market.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.Group;
import com.gxuwz.Market.business.entity.Studentexamscore;
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
}

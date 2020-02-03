package com.gxuwz.Market.business.dao;

import org.springframework.stereotype.Repository;

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
	
}

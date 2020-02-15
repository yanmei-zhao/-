package com.gxuwz.Market.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.entity.ExamClass;
import com.gxuwz.Market.business.entity.TestPaperTopic;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

@Repository("ExamClassDAO")
public class ExamClassDAO extends BaseDaoImpl<ExamClass>{

	/**
	 * 获取考试对应班级
	 * @param examId
	 * @return
	 */
	public Result<ExamClass> getClassAll(int examId, int page, int row) {
		// TODO Auto-generated method stub
		String queryString="select distinct t2.className,t2.classId,t0.examName,t0.examId from Exam t0,ExamClass t1,Group t2 where t0.examId = t1.examId and t2.classId=t1.classId and t0.examId= "+examId;
		 int start=(page-1)*row;
		 int limit =row;
		 return (Result<ExamClass>) super.find(queryString, null, null, start, limit);
	}

	/**
	 * 获取对应的考试与班级
	 * @param examId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ExamClass> getAllExamClass(int examId) {
		// TODO Auto-generated method stub
		String queryString = "from ExamClass where examId='"+examId+"'";
		return (List<ExamClass>) getHibernateTemplate().find(queryString);
	}

}

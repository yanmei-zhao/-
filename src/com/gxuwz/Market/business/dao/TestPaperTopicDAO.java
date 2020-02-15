package com.gxuwz.Market.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.Market.business.entity.TestPaperTopic;
import com.gxuwz.core.dao.impl.BaseDaoImpl;

@Repository("TestPaperTopicDAO")
public class TestPaperTopicDAO extends BaseDaoImpl<TestPaperTopic>{
	
	/**
	 * 查询所有试卷对应的试题`
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TestPaperTopic> getAllTestpaperTopic(int testpaperId){
		String queryString="from TestPaperTopic where testpaperId='"+testpaperId+"'";
		return (List<TestPaperTopic>) getHibernateTemplate().find(queryString);
	}

}

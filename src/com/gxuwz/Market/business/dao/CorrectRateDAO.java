package com.gxuwz.Market.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.CorrectRate;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.Market.business.entity.TopicBank;
import com.gxuwz.core.dao.impl.BaseDaoImpl;

@Repository("CorrectRateDAO")
public class CorrectRateDAO extends BaseDaoImpl<CorrectRate>{

	public CorrectRate findByTopicId(int topicId) {
		// TODO Auto-generated method stub
		CorrectRate correctRate = null;
		String queryString = "from CorrectRate where topicId="+topicId;
		List<CorrectRate> list = (List<CorrectRate>) this.getHibernateTemplate().find(queryString);
		if(list != null && 0<list.size()){
			correctRate = list.get(0);
		}
		return correctRate;
	}

}

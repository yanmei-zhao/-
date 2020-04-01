package com.gxuwz.Market.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.CorrectRateDAO;
import com.gxuwz.Market.business.entity.CorrectRate;

@Service("correctRateService")
public class CorrectRateServiceImpl implements ICorrectRateService{
	@Autowired
	private CorrectRateDAO correctRateDAO;

	@Override
	public void add(CorrectRate correctRate) {
		// TODO Auto-generated method stub
		correctRateDAO.save(correctRate);
	}

	@Override
	public void update(CorrectRate correctRate) {
		// TODO Auto-generated method stub
		correctRateDAO.update(correctRate);
	}

	@Override
	public CorrectRate findByTopicId(int topicId) {
		// TODO Auto-generated method stub
		return correctRateDAO.findByTopicId(topicId);
	}
}

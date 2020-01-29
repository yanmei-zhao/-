package com.gxuwz.Market.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.TestPaperTopicDAO;
import com.gxuwz.Market.business.entity.TestPaperTopic;
@Service("testPaperTopicService")
public class TestTopicServiceImpl implements ITestTopicService{
	@Autowired
	private TestPaperTopicDAO testpaperTopicDAO;
	@Override
	public void add(TestPaperTopic testPaperTopic) {
		// TODO Auto-generated method stub
		testpaperTopicDAO.save(testPaperTopic);
	}

}

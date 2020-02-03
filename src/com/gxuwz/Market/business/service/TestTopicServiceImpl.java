package com.gxuwz.Market.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.TestPaperTopicDAO;
import com.gxuwz.Market.business.entity.Examquestionanswer;
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
	
	/**
	 * 
	 * @author zym
	 * @date 上午11:17:11
	 * @description 保存批量试题集合
	 */
	@Override
	public void addBatch(List<TestPaperTopic> list) {
		// TODO Auto-generated method stub
		for (TestPaperTopic testPaperTopic : list) {
			testpaperTopicDAO.save(testPaperTopic);
		}
	}

}

package com.gxuwz.Market.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.TestPaperTopicDAO;
import com.gxuwz.Market.business.entity.TestPaperTopic;

@Service("testPaperTopicService")
public class TestPaperTopicServiceImpl implements ITestPaperTopicService {

	@Autowired
	private TestPaperTopicDAO testPaperTopicDAO;

	@Override
	public void add(TestPaperTopic testPaperTopic) {
		// TODO Auto-generated method stub
		testPaperTopicDAO.save(testPaperTopic);
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
			testPaperTopicDAO.save(testPaperTopic);
		}
	}

	/**
	 * 根据id删除一条记录
	 * @param id
	 * @author 
	 * @date 2019.12.10
	 */
	@Override
	public void delete(Integer testpaperId) {
		// TODO Auto-generated method stub
		testPaperTopicDAO.remove(findById(testpaperId));
	}
	
	/**
	 * 
	 * @author zym
	 * @date 上午11:17:11
	 * @description 删除试卷试题集合
	 */
	@Override
	public void deleteBatch(List<TestPaperTopic> list1) {
		// TODO Auto-generated method stub
		for (TestPaperTopic testPaperTopic : list1) {
			int Id=testPaperTopic.getId();
			testPaperTopicDAO.remove(findById(Id));
		}
	}
	
	/**
	 * 根据id查询一条记录
	 * @param id
	 * @return
	 * @author 
	 * @date 2015.8.10
	 */
	@Override
	public TestPaperTopic findById(Integer testpaperId) {
		return testPaperTopicDAO.get(TestPaperTopic.class, testpaperId);
	}

	/**
	 * 查询所有试卷对应的试题`
	 * @return
	 */
	@Override
	public List<TestPaperTopic> getAllTestpaperTopic(Integer testpaperId) {
		// TODO Auto-generated method stub
		return testPaperTopicDAO.getAllTestpaperTopic(testpaperId);
	}

}

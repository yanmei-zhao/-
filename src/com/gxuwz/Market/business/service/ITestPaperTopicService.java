package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.TestPaperTopic;

public interface ITestPaperTopicService {
	/**
	 * 添加试题到试卷
	* @Title: add      
	* @return void    返回类型   
	* @throws
	 */
	public void add(TestPaperTopic test);
	
	/**
	 * 
	 * @author zym
	 * @date 上午11:17:11
	 * @description 保存批量试题集合
	 */
	public void addBatch(List<TestPaperTopic> list);
	
	/**
	 * 根据id删除一条记录
	 * @param id
	 * @author 
	 * @date 2019.12.10
	 */
	public void delete(Integer testpaperId);
	
	/**
	 * 
	 * @author zym
	 * @date 上午11:17:11
	 * @description 删除课程集合
	 */
	public void deleteBatch(List<TestPaperTopic> list1);

	/**
	 * 根据id查询一条记录
	 * @param id
	 * @return
	 * @author 
	 * @date 2019.12.10
	 */
	public TestPaperTopic findById(Integer testpaperId);
	
	/**
	 * 查询所有试卷对应的试题`
	 * @return
	 */
	public List<TestPaperTopic> getAllTestpaperTopic(Integer testpaperId);
}

package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.TestPaperTopic;

public interface ITestTopicService {
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
}

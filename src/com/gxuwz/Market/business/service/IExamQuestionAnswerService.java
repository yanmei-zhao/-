package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.Examquestionanswer;
import com.gxuwz.Market.business.entity.Testpaper;

public interface IExamQuestionAnswerService {

	/**
	 * 
	 * @author zym
	 * @date 上午11:17:11
	 * @description 保存学生考试答案集合
	 */
	public void addBatch(List<Examquestionanswer> list);
	
	
	/**
	 * 查询正确答案`
	 * @return 
	 */
	public List<String> getAllAnswer(int studentId,int topicId);
	
	/**
	 * 查询所有题型分值
	 * @return 
	 */
	public Testpaper getAllScore(int examId);
	
}

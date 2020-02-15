package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.Course;
import com.gxuwz.Market.business.entity.Examquestionanswer;
import com.gxuwz.Market.business.entity.Studentexamscore;
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
	 * 查询所有题型分值
	 * @return 
	 */
	public Testpaper getAllScore(int examId);

	/**
	 * 查询选择题答案
	 * @param studentId
	 * @param topicId
	 * @return
	 */
	public List<String> getAllChoiceAnswer(int studentId, int topicId,int examId);

	/**
	 * 查询填空题答案
	 * @param studentId
	 * @param topicId
	 * @return
	 */
	public List<String> getAllFillAnswer(int studentId, int topicId,int examId);

	/**
	 * 查询简答题答案
	 * @param studentId
	 * @param topicId
	 * @return
	 */
	public List<String> getAllTopicAnswer(int studentId, int topicId,int examId);
	
	
	public void add(Studentexamscore studentScore );
}

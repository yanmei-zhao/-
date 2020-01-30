package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.Examquestionanswer;

public interface IExamQuestionAnswerService {

	/**
	 * 
	 * @author zym
	 * @date 上午11:17:11
	 * @description 保存学生考试答案集合
	 */
	public void addBatch(List<Examquestionanswer> list);
}

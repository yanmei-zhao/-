package com.gxuwz.Market.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.ExamQuestionAnswerDAO;
import com.gxuwz.Market.business.entity.Examquestionanswer;

/**
 * 
 *<p>Title:ExamQuestionAnswerServiceImpl</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年1月30日下午12:08:23
 */
@Service("examQuestionAnswerService")
public class ExamQuestionAnswerServiceImpl implements IExamQuestionAnswerService{
	@Autowired
	private ExamQuestionAnswerDAO examQuestionAnswerDAO;
	/**
	 * @author zym
	 * @date 上午11:17:11
	 * @description 保存学生考试答案集合
	 */
	@Override
	public void addBatch(List<Examquestionanswer> list) {
		// TODO Auto-generated method stub
		for (Examquestionanswer answer : list) {
			examQuestionAnswerDAO.save(answer);
		}
	}
}

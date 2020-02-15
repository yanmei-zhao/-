package com.gxuwz.Market.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.ExamQuestionAnswerDAO;
import com.gxuwz.Market.business.dao.StudentExamScoreDAO;
import com.gxuwz.Market.business.entity.Examquestionanswer;
import com.gxuwz.Market.business.entity.Studentexamscore;
import com.gxuwz.Market.business.entity.Testpaper;

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
	@Autowired
	private StudentExamScoreDAO studentExamScoreDAO;
	
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
	
	/**
	 * 查询所有题型分值
	 * @return 
	 */
	@Override
	public Testpaper getAllScore(int examId) {
		// TODO Auto-generated method stub
		return examQuestionAnswerDAO.getAllScore(examId);
	}

	/**
	 * 查询选择题答案
	 * @param studentId
	 * @param topicId
	 * @return
	 */
	@Override
	public List<String> getAllChoiceAnswer(int studentId, int topicId,int examId) {
		// TODO Auto-generated method stub
		return examQuestionAnswerDAO.getAllChoiceAnswer(studentId,topicId,examId);
	}

	/**
	 * 查询填空题答案
	 * @param studentId
	 * @param topicId
	 * @return
	 */
	@Override
	public List<String> getAllFillAnswer(int studentId, int topicId,int examId) {
		// TODO Auto-generated method stub
		return examQuestionAnswerDAO.getAllFillAnswer(studentId,topicId,examId);
	}

	/**
	 * 查询简答题答案
	 * @param studentId
	 * @param topicId
	 * @return
	 */
	@Override
	public List<String> getAllTopicAnswer(int studentId, int topicId,int examId) {
		// TODO Auto-generated method stub
		return examQuestionAnswerDAO.getAllTopicAnswer(studentId,topicId,examId);
	}

	/**
	 * 添加学生成绩
	 */
	@Override
	public void add(Studentexamscore studentScore) {
		// TODO Auto-generated method stub
		 studentExamScoreDAO.save(studentScore);
	}

	
}

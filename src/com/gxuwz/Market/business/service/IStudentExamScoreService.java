package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.Group;
import com.gxuwz.Market.business.entity.Studentexamscore;
import com.gxuwz.Market.business.entity.Studentscore;
import com.gxuwz.core.pagination.Result;

public interface IStudentExamScoreService {

	/**
	 * 查询成绩(学生端)
	 */
	public Result<Studentexamscore> find(Studentexamscore studentExamScore, int studentId, int page, int row);

	/**
	 * 查询学生最终得分成绩(教师端)
	 */
	public Result<Studentscore> listAll(Studentscore studentScore, int page, int row);

	/**
	 * 批量导出学生成绩
	 * @return
	 */
	public List<Object[]> getAllStudentScore();
	
	/**
	 * 查询成绩最高分
	 * @return
	 */
	public int getMaxScore(String testpaperName);
	
	/**
	 * 查询成绩最低分
	 * @return
	 */
	public int getMinScore(String testpaperName);
	
	/**
	 * 查询成绩平均分
	 * @return
	 */
	public int getAvgScore(String testpaperName);

	/**
	 * 查询已交卷学生的答案
	 * @param studentId
	 * @return
	 */
	public Result<Studentscore> getAllFillTopic(int studentId, int examId, int page, int row);

	public Result<Studentscore> getAllChoiceTopic(int studentId, int examId, int page, int row);

	public Result<Studentscore> getAllTopic(int studentId, int examId, int page, int row);

	/**
	 * 保存修改信息
	 * @return
	 * @throws Exception
	 */
	public void update(Studentexamscore studentExamScore);
	
	/**根据考试id和学生id查询学生成绩
	 * @return
	 */
	public Studentexamscore findById(int studentId,int examId);
	
	/**
	 * 查询学生已交卷试卷列表(教师端)
	 */
	public Result<Studentscore> listCorrectAll(Studentscore studentScore, int page, int row);
}

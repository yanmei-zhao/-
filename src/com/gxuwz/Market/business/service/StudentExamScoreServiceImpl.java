package com.gxuwz.Market.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.StudentExamScoreDAO;
import com.gxuwz.Market.business.dao.StudentScoreDAO;
import com.gxuwz.Market.business.entity.Group;
import com.gxuwz.Market.business.entity.Studentexamscore;
import com.gxuwz.Market.business.entity.Studentscore;
import com.gxuwz.core.pagination.Result;

/**
 * 
 *<p>Title:StudentExamScoreServiceImpl</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年2月2日下午5:29:58
 */
@Service("studentExamScoreService")
public class StudentExamScoreServiceImpl implements IStudentExamScoreService{
	@Autowired
	private StudentExamScoreDAO studentExamScoreDAO;
	@Autowired
	private StudentScoreDAO studentScoreDAO;
	/**
	 * 查询成绩(学生查自己的)
	 */
	@Override
	public Result<Studentexamscore> find(Studentexamscore studentExamScore, int studentId, int page, int row) {
		// TODO Auto-generated method stub
		return studentExamScoreDAO.find(studentExamScore, studentId,page, row);
	}
	
	/**
	 * 查询成绩(教师端)
	 */
	@Override
	public Result<Studentscore> listAll(Studentscore studentScore, int page, int row) {
		// TODO Auto-generated method stub
		return studentScoreDAO.listAll(studentScore,page, row);
	}

	/**
	 * 批量导出学生成绩
	 * @return
	 */
	@Override
	public List<Object[]> getAllStudentScore() {
		// TODO Auto-generated method stub
		return studentScoreDAO.getAllScore();
	}

	/**
	 * 查询成绩最高分
	 * @return
	 */
	@Override
	public int getMaxScore(String testpaperName) {
		// TODO Auto-generated method stub
		return studentExamScoreDAO.getMaxScore(testpaperName);
	}

	/**
	 * 查询成绩最低分
	 * @return
	 */
	@Override
	public int getMinScore(String testpaperName) {
		// TODO Auto-generated method stub
		return studentExamScoreDAO.getMinScore(testpaperName);
	}

	/**
	 * 查询成绩平均分
	 * @return
	 */
	@Override
	public int getAvgScore(String testpaperName) {
		// TODO Auto-generated method stub
		return studentExamScoreDAO.getAvgScore(testpaperName);
	}

	/**
	 * 查询已答题学生的答案
	 * @param studentId
	 * @return
	 */
	@Override
	public Result<Studentscore> getAllTopic(int studentId,int examId, int page, int row) {
		// TODO Auto-generated method stub
		return studentExamScoreDAO.getAllTopic(studentId,examId, page, row);
	}

	@Override
	public Result<Studentscore> getAllChoiceTopic(int studentId,int examId, int page, int row) {
		// TODO Auto-generated method stub
		return studentExamScoreDAO.getAllChoiceTopic(studentId,examId, page, row);
	}

	@Override
	public Result<Studentscore> getAllFillTopic(int studentId,int examId, int page, int row) {
		// TODO Auto-generated method stub
		return studentExamScoreDAO.getAllFillTopic(studentId,examId, page, row);
	}

	/**
	 * 保存修改信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public void update(Studentexamscore studentExamScore) {
		// TODO Auto-generated method stub
		studentExamScoreDAO.update(studentExamScore);
	}

	/**根据考试id和学生id查询成绩
	 * @return
	 */
	@Override
	public Studentexamscore findById(int studentId, int examId) {
		// TODO Auto-generated method stub
		return studentExamScoreDAO.findById(studentId, examId);
	}

}

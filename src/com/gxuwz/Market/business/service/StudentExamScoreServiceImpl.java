package com.gxuwz.Market.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.StudentExamScoreDAO;
import com.gxuwz.Market.business.dao.StudentScoreDAO;
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

}

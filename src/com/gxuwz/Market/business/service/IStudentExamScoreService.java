package com.gxuwz.Market.business.service;

import com.gxuwz.Market.business.entity.Studentexamscore;
import com.gxuwz.Market.business.entity.Studentscore;
import com.gxuwz.core.pagination.Result;

public interface IStudentExamScoreService {

	/**
	 * 查询成绩(学生端)
	 */
	public Result<Studentexamscore> find(Studentexamscore studentExamScore, int studentId, int page, int row);

	/**
	 * 查询成绩(教师端)
	 */
	public Result<Studentscore> listAll(Studentscore studentScore, int page, int row);
	
}

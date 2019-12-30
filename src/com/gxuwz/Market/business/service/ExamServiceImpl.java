package com.gxuwz.Market.business.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.ExamDAO;
import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.core.pagination.Result;

/**
 * 考试信息业务实现类
* <p>Title: ExamServiceImpl</p>     
* @author zym 
* @date 下午12:09:45
 */
 
@Service("examService")
public class ExamServiceImpl implements ExamService {
	@Autowired
	private ExamDAO examDAO;
	
    /**
     * 分页
     */
	public Result<Exam> find(Exam exam, int page, int row) {
		
		return examDAO.find(exam, page, row);
	}

    /**
     * 添加
     */
	@Override
	public void add(Exam exam) {
		examDAO.save(exam);
		
	}

	/**
	 * 查找
	 */
	@Override
	public Exam findById(Integer examId) {
		
		return examDAO.get(Exam.class, examId);
	}

	/**
	 * 更新
	 */
	@Override
	public void update(Exam exam) {
		examDAO.update(exam);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer examId) {
		examDAO.remove(findById (examId));
		
	}

	/**
	 * 查找所有
	 */
	@Override
	public List<Exam> getExamAll() {
		return examDAO.getAllExam();
	}

	/**
	 * 查找所有试卷名称12.29.17.31
	 */
	@Override
	public List<String> getTestpaperNameAll() {
		// TODO Auto-generated method stub
		return examDAO.getTestpaperNameAll();
	}


}

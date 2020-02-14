package com.gxuwz.Market.business.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.ExamClassDAO;
import com.gxuwz.Market.business.dao.ExamDAO;
import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.Market.business.entity.ExamClass;
import com.gxuwz.Market.business.entity.Examquestionanswer;
import com.gxuwz.Market.business.entity.Testpaper;
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
	@Autowired
	private ExamClassDAO examClassDAO;
	
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

	/**
	 * 根据班级名称查找所有考试1.10
	 */
	@Override
	public Result<Exam> findByclassName(Exam exam, int page, int row) {
		// TODO Auto-generated method stub
		return examDAO.findByclassName(exam, page, row);
	}

	/**
	 * 根据试卷名称查找所有试卷信息1.10
	 */
	@Override
	public Testpaper findByTestpaperName(String examName) {
		// TODO Auto-generated method stub
		return examDAO.findByTestpaperName(examName);
	}

	/**
	 * 批量添加考试对应的班级
	 * @param list
	 */
	@Override
	public void addBatch(List<ExamClass> list) {
		// TODO Auto-generated method stub
		for (ExamClass exam : list) {
			examClassDAO.save(exam);
		}
	}


}

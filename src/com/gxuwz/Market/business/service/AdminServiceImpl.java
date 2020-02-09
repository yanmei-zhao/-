package com.gxuwz.Market.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.AdminDAO;
import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.Teacher;
import com.gxuwz.core.pagination.Result;

@Service("AdminService")
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private AdminDAO adminDAO;

	/**
	 * 查询待审核试卷列表
	 * @return
	 * @throws Exception
	 * @author 
	 * @date 2019.8.10
	 */
	public Result<Exam> find(Exam exam, int page, int row) {
		return adminDAO.find(exam, page, row);
	}
    
    /**
	 * 更新
	 * @param zyId
	 * @author 
     * @date 2018.6.6
	 */
	@Override
	public void update(Integer examId) {
		// TODO Auto-generated method stub
		adminDAO.update(examId);
	}
	
	/**
	 * 通过(通过更新考试状态为通过标记实现通过考试）
	 * @return
	 * @throws @author
	 * @date 2018.6.1
	 */
   public void update(Student student) {
	   adminDAO.update(student);
	}
	
	/**
	 * 不通过(通过更新考试状态为不通过标记实现不通过考试）
	 * @return
	 * @throws @author
	 * @date 2018.6.1
	 */
	@Override
	public void update1(Integer examId) {
		// TODO Auto-generated method stub
		adminDAO.update1(examId);
	}
	/**
	 * 查询学生
	 * @param student
	 * @param page
	 * @param row
	 * @return
	 */
	@Override
	public Result<Student> findStudent(Student student, int page, int row) {
		return adminDAO.findStudent(student, page, row);
	}
	
	 public Result<Teacher> findTeacher(Teacher teacher, int page, int row) {
			return adminDAO.findTeacher(teacher, page, row);
		}
	 
	 @Override
    public void delete(Integer studentId) {
		adminDAO.delete(studentId);
	}
	    
	 @Override
    public void delete1(Integer teacherId) {
		
		adminDAO.delete1(teacherId);
	}
	 
	 public Student find(Student admin) {
			return adminDAO.find(admin);
		}
	 

	@Override
	public Student findStudentByid(Integer studentId) {
		return adminDAO.findStudentByid(studentId);
	}
	
	/**
	 * 查询考试基本信息
	 * @return
	 */
	 public Exam findExam(Integer examId) {
			return adminDAO.findExam(examId);
		}
	  
	 /**
	 * 查看通过试卷列表
	 * @param exam
	 * @param page
	 * @param size
	 * @return
	 */  
	 public Result<Exam> findPass(Exam exam, int page, int row) {
			return adminDAO.findPass(exam, page, row);
		}
	 /**
	 * 查看不通过试卷列表
	 * @param exam
	 * @param page
	 * @param size
	 * @return
	 */
	 public Result<Exam> findFail(Exam exam, int page, int row) {
			return adminDAO.findFail(exam, page, row);
		}
	    
	
	
}

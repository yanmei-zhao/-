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
	
	
    public Result<Exam> find(Exam exam, int page, int row) {
		
		return adminDAO.find(exam, page, row);
	}
    
    /**
	 * 删除功能（伪删除）
	 * @param zyId
	 * @author 
     * @date 2018.6.6
	 */
	@Override
	public void update(Integer examId) {
		// TODO Auto-generated method stub
		adminDAO.update(examId);
		
	}
	@Override
	public void update1(Integer examId) {
		// TODO Auto-generated method stub
		adminDAO.update1(examId);
	}
	/**mm
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
	    //修改
	   public void update(Student student) {
		   adminDAO.update(student);
		}

	@Override
	public Student findStudentByid(Integer studentId) {
		return adminDAO.findStudentByid(studentId);
		 
		
	}
	
	 public Exam findExam(Integer examId) {
			
			return adminDAO.findExam(examId);
		}
	  
	    
	 public Result<Exam> find1(Exam exam, int page, int row) {
			
			return adminDAO.find1(exam, page, row);
		}
	 public Result<Exam> find2(Exam exam, int page, int row) {
			
			return adminDAO.find2(exam, page, row);
		}
	    
	
	
}

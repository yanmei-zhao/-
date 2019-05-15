package com.gxuwz.Market.business.service;


import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.Teacher;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.core.pagination.Result;

public interface IAdminService {
	
	public Result<Exam> find(Exam exam, int page, int row);
	public Result<Exam> find1(Exam exam, int page, int row);
	public Result<Exam> find2(Exam exam, int page, int row);


	
	/**
	 * 删除功能（伪删除）
	 * @param zyId
	 * @author 
     * @date 2018.6.6
	 */
	public void update(Integer examId);
	public void update1(Integer examId);
	
	public Result<Student> findStudent(Student student, int page, int row);
	
	public Result<Teacher> findTeacher(Teacher teacher, int page, int row);
	
	 public void delete(Integer studentId);
	 
	 public void delete1(Integer teacherId);
	 
	 public Student find(Student student);
	    
     //修改管理员信息
  	public void update (Student student);


	public Student findStudentByid(Integer studentId);
	
	public Exam findExam(Integer examId);

}

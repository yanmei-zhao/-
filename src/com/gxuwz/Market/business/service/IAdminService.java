package com.gxuwz.Market.business.service;


import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.Teacher;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.core.pagination.Result;

public interface IAdminService {
	
	/**
	 * 查询待审核试卷列表
	 * @return
	 * @throws Exception
	 * @author 
	 * @date 2019.8.10
	 */
	public Result<Exam> find(Exam exam, int page, int row);
	
	/**
	 * 查看通过试卷列表
	 * @param exam
	 * @param page
	 * @param size
	 * @return
	 */
	public Result<Exam> findPass(Exam exam, int page, int row);
	
	/**
	 * 查看不通过试卷列表
	 * @param exam
	 * @param page
	 * @param size
	 * @return
	 */
	public Result<Exam> findFail(Exam exam, int page, int row);

	/**
	 * 通过(通过更新考试状态为通过标记实现通过考试）
	 * @return
	 * @throws @author
	 * @date 2018.6.1
	 */
	public void update(Integer examId);
	
	/**
	 * 不通过(通过更新考试状态为不通过标记实现不通过考试）
	 * @return
	 * @throws @author
	 * @date 2018.6.1
	 */
	public void update1(Integer examId);
	
	/**
	 * 查询考试基本信息
	 * @return
	 */
	public Exam findExam(Integer examId);
	
	public Result<Student> findStudent(Student student, int page, int row);
	
	public Result<Teacher> findTeacher(Teacher teacher, int page, int row);
	

	public Student findStudentByid(Integer studentId);
	public void delete(Integer studentId);
	 
	public void delete1(Integer teacherId);
	 
	public Student find(Student student);
	    
    //修改管理员信息
 	public void update (Student student);

}

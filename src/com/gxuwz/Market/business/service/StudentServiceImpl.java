package com.gxuwz.Market.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.StudentDAO;
import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.Market.business.entity.Group;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.core.pagination.Result;
/**
 * 
 *<p>Title:StudentServiceImpl</p>
 *<p>Description:学生接口实现类</p>
 * @author zhaoyanmei
 * @date 2019年1月23日下午10:52:17
 */
@Service("studentService")
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private StudentDAO studentDAO;
	@Override
	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 */
	public Result<Student> find(Student student, int page, int row) {
		// TODO Auto-generated method stub
		return studentDAO.find(student, page, row);
	}
	/**
     * 添加学生
     */
	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		studentDAO.save(student);
	}
	/**
     * 根据id查询一条记录
     * @param id
     */

	@Override
	public Student findById(String studentId) {
		// TODO Auto-generated method stub
		return studentDAO.get(Student.class, studentId);
	}
	/**
     * 根据name查询一条记录
     * @param name
     */
	@Override
	public Student findByName(String studentName) {
		// TODO Auto-generated method stub
		return studentDAO.get(Student.class, studentName);
	}
	/**
     * 保存修改信息
     * @param student
     */
	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentDAO.update(student);
	}
	/**
     * 删除信息
     * @param student
     */
	@Override
	public void delete(String studentId) {
		// TODO Auto-generated method stub
		studentDAO.remove(findById(studentId));
	}
	/**查询所有学生信息
     * @param student
     */
	@Override
	public List<Student> getStudentAll() {
		// TODO Auto-generated method stub
		return studentDAO.getAllStudent();
	}
	/**
	 * 验证题库编号是否重复
	 * @param topicBankId 题库编号
	 */
	@Override
	public String checkStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		Student student = studentDAO.get(Student.class, studentId);
		if(null != student){
			return "no";
		}else{
			return "ok";
		}
	}
	 /**
     * 
     * @date 上午11:19:30
     * @Descripton 保存集合
     */
	@Override
	public void addBatch(List<Student> list) {
		for (Student student : list) {
			studentDAO.save(student);
		}
	}
	@Override
	public List<Group> findClassIdByClassName(String className, String grade) {
		// TODO Auto-generated method stub
		return studentDAO.get(Student.class, className,grade);
	}
	
	/**
	 * 查询所有学生班级信息 12.29 16.33
	 * @return
	 */
	@Override
	public List<String> getClassNameAll() {
		// TODO Auto-generated method stub	
		return studentDAO.getAllClassName();
	}
	
	@Override
	public Result<Student> getlistByClassId(Student student, int page, int row, int classId) {
		// TODO Auto-generated method stub	
		return studentDAO.getlistByClassId(student, page, row, classId);
	}
}

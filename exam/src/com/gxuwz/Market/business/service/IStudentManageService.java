package com.gxuwz.Market.business.service;

import java.util.List;



import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.core.pagination.Result;

public interface IStudentManageService {

	/**
	 * 
	 * @author zhouyiyuan
	 * @date 下午4:40:22
	 * @description 查找所有学生信息
	 */
	public List<Student> findAllStudent();
	
	
	public void add(Student student);
	
	/**
	 * 
	 * @author zhouyiyuan
	 * @date 下午4:41:07
	 * @description 更新学生信息
	 */
	public void updateStudent(Student student);

	/**
	 * 
	 * @author zhouyiyuan
	 * @date 下午4:41:35
	 * @description  添加学生
	 */
	public void add(List<Student> student);

	/**
	 * 
	 * @author zhouyiyuan
	 * @date 上午11:17:11
	 * @description 保存学生集合
	 */
	public void addBatch(List<Student> list);
	
	/**
	 * 
	 * @author zhouyiyuan
	 * @date 下午4:44:19
	 * @description 根据id删除学生
	 */
	public void delete(int studentId);
	
	/**
	 * 
	 * @author zhouyiyuan
	 * @date 下午4:42:16
	 * @description  根据学生Id查询学生
	 */
	public Student findById(int studentId);
	
	/**
	 *  分页
	 * @param 
	 * @param page
	 * @param row
	 * @return
	 * @author lianliang
	 * @date 2018-5-24
	 */
	public Result<Student> find(Student student, int page, int row);
}

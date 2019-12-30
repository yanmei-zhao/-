package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.*;
import com.gxuwz.core.pagination.Result;

/**
 * 
 *<p>Title:IStudentService</p>
 *<p>Description:学生接口</p>
 * @author 赵艳梅
 * @date 2019年1月23日下午10:49:18
 */
public interface IStudentService {
	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 */
	public Result<Student> find(Student student, int page, int row);
	
	/**
	 * 添加新题库
	 * @param sysMerchantUnit 模型
	 */
	public void add(Student student);
	/**
	 * 根据id查询一条记录
	 * @param id
	 */
	public Student findById(String studentId);
	/**
	 * name查询一条记录
	 * @param name
	 */
	public Student findByName(String studentName);
	/**
	 * 保存修改权限信息
	 * @param sysRight
	 */
	public void update(Student student);
	/**
	 * 根据id删除一条记录
	 * @param id
	 */
	public void delete(String studentId);
	/**
	 * 查询所有学生信息
	 * @return
	 */
	public List<Student> getStudentAll();
	/**
	 * 
	 * @author zym
	 * @date 上午11:17:11
	 * @description 保存学生集合
	 */
	public void addBatch(List<Student> list);
	/**
	 * 验证学生编号是否重复
	 * @param studentId
	 * @return
	 */
	public String checkStudentId(Integer studentId);
	/**
	 * 查询
	* @Title: findByClassName     
	* @return Student    返回类型   
	* @throws
	 */
	public List<Group> findClassIdByClassName(String className,String grade);
	
	/**
	 * 查询所有学生班级信息 12.29 16.33
	 * @return
	 */
	public List<String> getClassNameAll();
	
	/**
	 * 查询所有学生班级信息 12.29 16.33
	 * @return
	 */
	public Result<Student> getlistByClassId(Student student, int page, int row, int classId);
}

package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.Teacher;
import com.gxuwz.core.pagination.Result;

/**
 * 
 *<p>Title:ITeacherService</p>
 *<p>Description:</p>
 * @author zhaoyanmei
 * @date 2019年1月24日下午5:30:29
 */
public interface ITeacherService {
	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 */
	public Result<Teacher> find(Teacher teacher, int page, int row);
	
	/**
	 * 添加新老师
	 * @param sysMerchantUnit 模型
	 */
	public void add(Teacher teacher);
	/**
	 * 根据id查询一条记录
	 * @param id
	 */
	public Teacher findById(Integer teacherId);
	/**
	 * name查询一条记录
	 * @param name
	 */
	public Teacher findByName(String teacherName);
	/**
	 * 保存修改教师信息
	 * @param sysRight
	 */
	public void update(Teacher teacher);
	/**
	 * 根据id删除一条记录
	 * @param id
	 */
	public void delete(Integer teacherId);
	/**
	 * 查询所有教师
	 * @return
	 */
	public List<Teacher> getTeacherAll();
	/**
	 * 
	 * @author zym
	 * @date 下午16:17:11
	 * @description 保存教师集合
	 */
	public void addBatch(List<Teacher> list);
	/**
	 * 验证教师编号是否重复
	 * @param teacherId
	 * @return
	 */

	public String checkTeacherId(Integer teacherId);
}

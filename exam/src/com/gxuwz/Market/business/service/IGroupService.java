package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.Group;
import com.gxuwz.core.pagination.Result;

/**
 * 
 *<p>Title:IClassService</p>
 *<p>Description:</p>
 * @author zhaoyanmei
 * @date 2019年1月26日下午11:29:16
 */
public interface IGroupService {

	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 */
	public Result<Group> find(Group group, int page, int row);
	
	/**
	 * 添加新班级
	 * @param sysMerchantUnit 模型
	 */
	public void add(Group group);
	/**
	 * 根据id查询一条记录
	 * @param id
	 */
	public Group findById(Integer classId);
	/**
	 * name查询一条记录
	 * @param name
	 */
	public Group findByName(String className);
	/**
	 * 保存修改权限信息
	 * @param sysRight
	 */
	public void update(Group group);
	/**
	 * 根据id删除一条记录
	 * @param id
	 */
	public void delete(Integer classId);
	/**
	 * 查询所有学生信息
	 * @return
	 */
	public List<Group> getGroupAll();
	/**
	 * 查询所有学生班级信息
	 * @return
	 */
	public List<String> getClassNameAll();
	/**
	 * 批量添加班级信息
	 * @return
	 */
	public void addBatch(List<Group> list);
}

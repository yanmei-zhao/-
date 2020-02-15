package com.gxuwz.Market.business.service;

import java.util.List;



import com.gxuwz.Market.business.entity.Course;
import com.gxuwz.Market.business.entity.Examquestionanswer;
import com.gxuwz.core.pagination.Result;

/**
 * <p>Title: 类名：权限-业务逻辑--接口</p>
 * <p>Description:mailsender-业务逻辑/n</p>
 * @author:	
 * @date:2019.12.10
 */
public interface ICourseService {
	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 * @author 
	 * @date 2019.12.10
	 */
	public Result<Course> find(Course course, int page, int row);
	/**
	 * 添加权限
	 * @param sysRight
	 * @author 
	 * @date 2019.12.10
	 */
	public void add(Course course);
	/**
	 * 根据id查询一条记录
	 * @param id
	 * @return
	 * @author 
	 * @date 2019.12.10
	 */
	public Course findById(Integer courseId);
	/**
	 * 保存修改权限信息
	 * @param sysRight
	 * @author 
	 * @date 2019.12.10
	 */
	public void update(Course course);
	/**
	 * 根据id删除一条记录
	 * @param id
	 * @author 
	 * @date 2019.12.10
	 */
	public void delete(Integer courseId);
	/**
	 * 查询所有权限
	 * @return
	 */
	public List<Course> getCourseAll();
	/**
	 * 验证权限编号是否重复
	 * @param rightId
	 * @return
	 */
	public List<String> getCourseNameAll();
	
	/**
	 * 
	 * @author zym
	 * @date 上午11:17:11
	 * @description 删除课程集合
	 */
	public void deleteBatch(List<Course> list);
	
	/**
	 * 查询课程数量
	 * @return
	 */
	public int getAllCourseTopicNum();
}

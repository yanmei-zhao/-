package com.gxuwz.Market.business.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.CourseDAO;
import com.gxuwz.Market.business.entity.Course;
import com.gxuwz.Market.business.entity.TopicBank;
import com.gxuwz.core.pagination.Result;

/**
 * <p>Title: 类名：权限-业务逻辑--实现</p>
 * <p>Description:mailsender-业务逻辑/n</p>
 * @author:	卢善坚，汪嘉惠
 * @date:2015.07.31
 */
@Service("courseService")
public class CourseServiceImpl implements ICourseService {
	@Autowired
	private CourseDAO courseDAO;
	
	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.8.10
	 */
	public Result<Course> find(Course course, int page, int row) {
		return courseDAO.find(course, page, row);
	}

	/**
	 * 添加权限
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.8.10
	 */
	@Override
	public void add(Course course) {
		courseDAO.save(course);
		
	}

	/**
	 * 根据id查询一条记录
	 * @param id
	 * @return
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.8.10
	 */
	@Override
	public Course findById(Integer courseId) {
		
		return courseDAO.get(Course.class, courseId);
	}

	/**
	 * 保存修改权限信息
	 * @param sysRight 
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.8.10
	 */
	@Override
	public void update(Course course) {
		courseDAO.update(course);
	}

	/**
	 * 根据id删除一条记录
	 * @param id
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.8.10
	 */
	@Override
	public void delete(Integer courseId) {
		courseDAO.remove(findById(courseId));
	}

	/**
	 * 查询所有权限
	 * @return
	 */
	@Override
	public List<Course> getCourseAll() {
		return courseDAO.getAllCourse();
	}

	 /**
     * 查询所有课程
     */
	@Override
	public List<String> getCourseNameAll() {
		// TODO Auto-generated method stub
		return courseDAO.getcourseNameAll();
	}


}

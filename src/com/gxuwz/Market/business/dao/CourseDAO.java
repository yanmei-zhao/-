package com.gxuwz.Market.business.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.Course;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

@Repository("CourseDAO")
public class CourseDAO extends BaseDaoImpl<Course>{
	
	/**
	 * 根据条件查找分页
	 * @param SysRole 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Course> find(Course course, int page, int row){
		String queryString="from Course where 1=1";
		if(null != course.getCourseName()){
			queryString = queryString + " and courseName like '%"+course.getCourseName()+"%'";
		}
		int start=(page-1)*row;
		int limit =row;
		return (Result<Course>)super.find(queryString, null, null, start, limit);
	}
	
	/**
	 * 升序查询所有课程
	 * @return
	 */
	public List<Course> getAllCourse(){
		
		String queryString="from Course where 1=1";
		return (List<Course>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 查询所有课程名称
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getcourseNameAll() {
		// TODO Auto-generated method stub
		String queryString="select courseName from Course where 1=1";
	    return (List<String>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 查询课程数量
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public int getcourseNum(){
		String queryString="select count(*) from Course where 1=1";
		List list =(List)getHibernateTemplate().find(queryString);
		Number num = (Number) list.get(0);
		return num.intValue();
	}
}

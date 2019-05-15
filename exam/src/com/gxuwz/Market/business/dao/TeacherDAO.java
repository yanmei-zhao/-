package com.gxuwz.Market.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.Teacher;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

/**
 * 
 *<p>Title:TeacherDAo</p>
 *<p>Description:</p>
 * @author zhaoyanmei
 * @date 2019年1月24日下午5:36:38
 */
@Repository("TeacherDAO")
public class TeacherDAO extends BaseDaoImpl<Teacher>{
	/**
	 * 根据条件查找分页
	 * @param teacher 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Teacher> find(Teacher teacher, int page, int row){
		String queryString="from Teacher where 1=1";//此处的Teacher为实体类的名字而不是表的名字
		if(null != teacher.getTeacherName()){
			queryString = queryString + " and teacherName like '%"+teacher.getTeacherName()+"%'";
		}//如果teacher的teacherName属性不为空，执行查询语句
		int start=(page-1)*row;
		int limit =row;
		return (Result<Teacher>)super.find(queryString, null, null, start, limit);
	 }
	

	/**
	 * 查询所有题库
	 * @return
	 */
	public List<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		String queryString="from Teacher where 1=1";//此处的Teacher为实体类的名字而不是表的名字
		return (List<Teacher>) getHibernateTemplate().find(queryString);

	}
}

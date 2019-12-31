package com.gxuwz.Market.business.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.Market.business.entity.Group;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.TopicBank;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

/**
 * 
 *<p>Title:StudentDAO</p>
 *<p>Description:</p>
 * @author zhaoyanmei
 * @date 2019年1月23日下午10:45:33
 */
@Repository("StudentDAO")
public class StudentDAO extends BaseDaoImpl<Student>{

	/**
	 * 根据条件查找分页
	 * @param topicBank 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Student> find(Student student, int page, int row){
		String queryString="from Student where 1=1";//此处的TopicBank为实体类的名字而不是表的名字
		if(null != student.getStudentName()){
			queryString = queryString + " and studentName like '%"+student.getStudentName()+"%'";
		}//如果student的studentName属性不为空，执行查询语句
		if(null != student.getClassName()){
			queryString = queryString + " and className like '%"+student.getClassName()+"%'";
		}//如果student的studentName属性不为空，执行查询语句
		int start=(page-1)*row;
		int limit =row;
		return (Result<Student>)super.find(queryString, null, null, start, limit);
	 }
	
	
	/**
	 * 查询所有学生
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		String queryString="from Student where 1=1";//此处的Student为实体类的名字而不是表的名字
		return (List<Student>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 通过班级名称查询班级id
	 * @return
	 */
	public List<Group> get(Class<Student> class1, String className, String grade) {
		// TODO Auto-generated method stub
		String queryString = "from Group p where p.className=? and p.grade=?";
		String[] value = new String[]{className, grade};
		try {
			List<Group> group = (List<Group>) this.getHibernateTemplate().find(queryString, value);
			return  group;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	/**
	 * 查询所有班级名称 2019.12.29 16.30
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getAllClassName() {
		// TODO Auto-generated method stub
		String queryString="select className from Group where 1=1";
		return (List<String>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 根据ClassId条件查找Student分页
	 */
	@SuppressWarnings("unchecked")
	public Result<Student> getlistByClassId(Student student, int page, int row, int classId){
		String queryString="from Student where 1=1 and classId = "+classId;//此处的Student为实体类的名字而不是表的名字
		int start=(page-1)*row;
		int limit =row;
		return (Result<Student>)super.find(queryString, null, null, start, limit);
	 }
	
}

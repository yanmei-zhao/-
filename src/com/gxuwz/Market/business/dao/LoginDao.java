package com.gxuwz.Market.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxuwz.core.dao.impl.BaseDaoImpl;


import com.gxuwz.Market.business.entity.Administrator;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.Teacher;
@Repository("LoginDao")
public class LoginDao extends BaseDaoImpl<Administrator>{
	   /**
     * 学生身份验证
     * @author 
     * @param SAccount 账号
     * @param SAssword 密码
     * @return
     */
	@SuppressWarnings("unchecked")
	public Student findStudent(String studentName,String studentPassword) {
		Student student = null;
	
		String hql = "from Student where studentName = '"+studentName+"' and studentPassword = '"+studentPassword+"'";
		List<Student> list = (List<Student>) this.getHibernateTemplate().find(hql);
		if(null != list && 0<list.size()){
			student = list.get(0);			
		}
		return student;
	}
	/**
	 * 教师身份验证
	 * @author 	
	 * @param TAccount 账号
	 * @param TPassword 密码
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Teacher findTeacher(String teacherName,String teacherPassword) {
		  Teacher teacher = null;
		String hql = "from Teacher where teacherName = '"+teacherName+"'and teacherPassword = '"+teacherPassword+"'";
		List<Teacher> list = (List<Teacher>) this.getHibernateTemplate().find(hql);
		if(null != list && 0<list.size()){
			teacher = list.get(0);
		}
		return teacher;
	}
	/**
	 * 管理员身份验证
	 * @author 	
	 * @param GAccount 账号
	 * @param GPassword 密码
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Administrator findAdmin(String administratorName,String administratorPassword) {
		  Administrator admin = null;
		String hql = "from Administrator where administratorName = '"+administratorName+"'and administratorPassword = '"+administratorPassword+"'";
		List<Administrator> list = (List<Administrator>) this.getHibernateTemplate().find(hql);
		if(null != list && 0<list.size()){
			admin = list.get(0);
		}
		return admin;
	}
	/**
	    * 查询管理员信息并存入
	    * @param g_account
	    * @return
	    */
		public Administrator selectCurrentAdmin(String administratorName,String administratorPassword) {
			Administrator administrator = null;
			String hql = "from Administrator where administratorName = '"+administratorName+"'and administratorPassword = '"+administratorPassword+"'";
			@SuppressWarnings("unchecked")
			List<Administrator> list = (List<Administrator>) this.getHibernateTemplate().find(hql);
			administrator = list.get(0);
			return administrator;
		}

		/**
		 * 查询教师信息并存入
		 * @param t_account
		 * @return
		 */
		public Teacher selectCurrentTeacher(String teacherName,String teacherPassword) {
			Teacher teacher = null;
			String hql = "from Teacher where teacherName = '"+teacherName+"'and teacherPassword = '"+teacherPassword+"'";
			@SuppressWarnings("unchecked")
			List<Teacher> list = (List<Teacher>) this.getHibernateTemplate().find(hql);
			
			teacher = list.get(0);
			return teacher;
		}
		/**
		 * 查询学生信息并存入
		 * @param s_account
		 * @return
		 */
		public Student selectCurrentStudent(String studentName,String studentPassword) {
			Student student = null;
			String hql = "from Student where studentName = '"+studentName+"'and studentPassword = '"+studentPassword+"'";
			@SuppressWarnings("unchecked")
			List<Student> list = (List<Student>) this.getHibernateTemplate().find(hql);
			
			student = list.get(0);
			return student;
		}
}

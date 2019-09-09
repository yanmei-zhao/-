package com.gxuwz.Market.business.service;


import com.gxuwz.Market.business.entity.Administrator;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.Teacher;

public interface LoginService {
    /**
     * 管理员身份验证
     * @author 
     * @param g_account 账号
     * @param g_password 密码
     * @return
     */
	boolean findAdmin(String administratorName,String administratorPassword);
	 //System.out.println("进入Action");
	
	/**
	 *教师身份验证
	 * @author 
	 * @param t_account 账号
	 * @param t_password 密码
	 * @return
	 */
	
	boolean findTeacher(String teacherName,String teacherPassword);
	/**
	 *学生身份验证
	 * @author 
	 * @param s_account 账号
	 * @param s_password 密码
	 * @return
	 */
	
	boolean findStudent(String studentName,String studentPassword);

	/**
	 * 查询管理员信息并存入
	 * @param g_account
	 * @return
	 */
	Administrator selectCurrentAdmin(String administratorName,String administratorPassword);

	/**
	 * 查询教师信息并存入
	 * @param t_account
	 * @return
	 */
    Teacher selectCurrentTeacher(String teacherName,String teacherPassword);
    /**
	 * 查询学生信息并存入
	 * @param s_account
	 * @return
	 */
    Student selectCurrentStudent(String studentName,String studentPassword);
    
}

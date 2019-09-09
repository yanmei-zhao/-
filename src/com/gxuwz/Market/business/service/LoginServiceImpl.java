package com.gxuwz.Market.business.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.service.LoginService;
import com.gxuwz.Market.business.entity.Administrator;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.Teacher;
//import cn.ording.systemcontext.SystemContext;
import com.gxuwz.Market.business.dao.LoginDao;


@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private  LoginDao LoginDao;
	
	/**
	 * 学生身份验证
	 * @author 
	 */
	@Override
	public boolean findStudent(String studentName,String studentPassword) {
		boolean login=false;
		Student student;
		student=LoginDao.findStudent(studentName,studentPassword);
		if(null != student){
			//if(Student.passwdDecryption(s_password,student.getS_password())){
				login=true;				
			//}
		}		
		return login;
	}
	/**
	 * 教师身份验证
	 * @author 
	 */
	@Override
	public boolean findTeacher(String teacherName,String teacherPassword) {
		boolean login=false;
		Teacher teacher;
		teacher=LoginDao.findTeacher(teacherName,teacherPassword);
		if(null != teacher){
				login=true;				
		
		}		
		return login;
	}
	
	/**
	 * 管理员身份验证
	 * @author 
	 */
	@Override
	public boolean findAdmin(String administratorName,String administratorPassword) {		
		boolean login=false;	
		Administrator admin;
		admin=LoginDao.findAdmin(administratorName,administratorPassword);
		if(null != admin){
		//	if(Admin.passwdDecryption(g_password,admin.getG_password())){
				login=true;				
		//	}
		}		
		return login;
	}

	
	/**
	 * 登录成功后查询当前管理员信息，并放置session中
	 * @author
	 */
	@Override
	public Administrator selectCurrentAdmin(String administratorName,String administratorPassword) {
		
		return LoginDao.selectCurrentAdmin(administratorName,administratorPassword);
	}
	/**
	 * 登录成功后查询当前教师信息，并放置session中
	 * @author 
	 */
	@Override
	public Teacher selectCurrentTeacher(String teacherName,String teacherPassword) {
		
		return LoginDao.selectCurrentTeacher(teacherName,teacherPassword);
	}

	/**
	 * 登录成功后查询当前学生信息，并放置session中
	 * @author 
	 */
	@Override
	public Student selectCurrentStudent(String studentName,String studentPassword) {
		
		return LoginDao.selectCurrentStudent(studentName,studentPassword);
	}

	
	
	
}

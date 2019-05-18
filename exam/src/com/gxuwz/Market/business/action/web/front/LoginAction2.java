package com.gxuwz.Market.business.action.web.front;

import java.util.List;

import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.gxuwz.Market.business.entity.Administrator;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.Teacher;
//import cn.ording.core.web.action.BaseAction;
import com.gxuwz.Market.business.service.LoginService;

@SuppressWarnings({ "rawtypes", "serial" })
public class LoginAction2 extends BaseAction implements Preparable, ModelDriven{
    private String userclass; //由login.jsp传入的User类型
	private Administrator administrator;
	private Teacher teacher;
	private Student student;
	private String account;
	private String password;
	//private String selectButton;//在Action周转的radio重置选择按钮值
	private String error;//jsp页面登录失败信息反馈
	private List<String> listRight;
	protected static final String JS_JSP = "/WEB-INF/page/teacher/teacher.jsp";//教师首页
	protected static final String Login_JSP = "/login.jsp";//登录页面
//	protected static final String Welcome_JSP = "/WEB-INF/page/Login/welcome.jsp";
	protected static final String XS_JSP = "/WEB-INF/page/student/student.jsp";//学生首页
	protected static final String GLY_JSP = "/WEB-INF/page/admin/admin.jsp";//管理员首页
	protected static final String TOP_JSP = "/WEB-INF/page/top.jsp";//顶端页面
	protected static final String LEFT_JSP = "/WEB-INF/page/admin/admin_left.jsp";//管理员首页左侧部分
	protected static final String INDEX_JSP = "/WEB-INF/page/index.jsp";//登录后首页
	protected static final String TELEFT_JSP = "/WEB-INF/page/teacher/teacher_left.jsp";//教师首页左侧部分
	protected static final String STLEFT_JSP = "/WEB-INF/page/student/student_left.jsp";//学生首页左侧部分
	@Autowired
	private  LoginService LoginService; 
	
	public void prepare() throws Exception {
		if(null == administrator){
			administrator = new Administrator();			
		}	
		if(null == teacher){		
			teacher = new Teacher();
		}	
		if(null == student){		
			student = new Student();
		}	
	}
/**
 * 登录检查
 * @author 
 * @return Login_JSP ManagerIndex_JSP CustomerIndex_JSP
 */
   public String login(){
	   //判断登录选择学生、老师还是管理员
	   //String GAccount=getAccount();
	   //String GPassword=getPassword();
	   //分段核对信息合法性
	   if(getUserclass().equals("管理员")){
		   if(LoginService.findAdmin(getAccount(),getPassword())){
			    //核对成功
			   Administrator CurrentAdmin =LoginService.selectCurrentAdmin(getAccount(),getPassword());
			 //获取管理员用户名，并把用户名存入session
				String userName = CurrentAdmin.getAdministratorName();
				getRequest().getSession().setAttribute("userName",userName);
				//跳转页面
				forwardView=GLY_JSP;
			   return SUCCESS;	
			 
		   }else{			   
			   //核对失败
			   //返回error结果
			   error="用户名或密码错误！";  
			   //返回重置用户名值
			 //  resetAdmin=Admin.getG_account();
			   //返回重置按钮值
			   //selectButton=userclass;			  
			   //返回页面
			   forwardView=Login_JSP;}		   		 
		 }
	
else if(userclass.equals("教师")){
			   //teacher.setTAccount(getAccount());
			  // teacher.setTPassword(getPassword());
			  
			   if(LoginService.findTeacher(getAccount(),getPassword())){
				   
				    //核对成功
				    //存入Session
				   Teacher CurrentTeacher =LoginService.selectCurrentTeacher(getAccount(),getPassword());
				   String userName = CurrentTeacher.getTeacherName();
					getRequest().getSession().setAttribute("userName",userName);
					//跳转页面
				   forwardView=JS_JSP;
			   }else{
				   //核对失败
				   //返回error结果
				   error="用户名或密码错误！";  
				   //返回重置用户名值 
				  // resetUser=teacher.getT_account();
				   //System.out.println(resetUser);
				   //返回页面
				   forwardView=Login_JSP;			   
			   }
		   }
else if(userclass.equals("学生")){
	   //student.setSAccount(getAccount());
	   //student.setSAssword(getPassword());
	  
	   if(LoginService.findStudent(getAccount(),getPassword())){
		   
		    //核对成功
		    //存入Session
		   Student CurrentStudent =LoginService.selectCurrentStudent(getAccount(),getPassword());
		   String userName = CurrentStudent.getStudentName();
			getRequest().getSession().setAttribute("userName",userName);
			//跳转页面
		   forwardView=XS_JSP;
	   }else{
		   //核对失败
		   //返回error结果
		   error="用户名或密码错误！";  
		   //返回重置用户名值 
		  // resetUser=teacher.getT_account();
		   //System.out.println(resetUser);
		   //返回页面
		   forwardView=Login_JSP;			   
	   }
}
	        return SUCCESS;		
   } 
   /**
	 * 登录-顶部跳转
	 * @return
	 */
	public String openTop(){
		forwardView = TOP_JSP;
		return SUCCESS;
	}

	/**
	 * 登录-左侧部跳转
	 * @return
	 */
	public String openLeft(){
		forwardView = LEFT_JSP;
		return SUCCESS;
	}
	/**
	 * 登录-首页跳转
	 * @return
	 */
	public String openIndex(){
		forwardView = INDEX_JSP;
		return SUCCESS;
	}
	public String openTELeft(){
		forwardView = TELEFT_JSP;
		return SUCCESS;
	}
	public String openSTLeft(){
		forwardView = STLEFT_JSP;
		return SUCCESS;
	}
	
	public Object getModel() {
		return administrator;
	}
	public String getUserclass() {
		return userclass;
	}
	public void setUserclass(String userclass) {
		this.userclass = userclass;
	}

	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	public Administrator getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

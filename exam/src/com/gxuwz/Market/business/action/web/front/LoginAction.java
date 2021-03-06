package com.gxuwz.Market.business.action.web.front;

import java.util.List;
import javax.servlet.http.HttpSession;

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
public class LoginAction extends BaseAction implements Preparable, ModelDriven{
    private String userclass; //由login.jsp传入的User类型
	private Administrator administrator;
	private Teacher teacher;
	private Student student;
	private String account;
	private String password;
	private String error;//jsp页面登录失败信息反馈
	private List<String> listRight;
	
	protected static final String Login_JSP = "/login.jsp";//登录页面
	protected static final String TOP_JSP = "/WEB-INF/page/top.jsp";//顶端页面
	protected static final String INDEX_JSP = "/WEB-INF/page/index.jsp";//登录后中心页面
	protected static final String MAIN_JSP = "/WEB-INF/page/main.jsp";
	protected static final String LEFT_JSP = "/WEB-INF/page/left.jsp";//首页左侧部分
	protected static final String MESSAGE_JSP = "/WEB-INF/page/message.jsp";//首页左侧部分
	
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
 * @author zym
 * @return Login_JSP ManagerIndex_JSP CustomerIndex_JSP
 */
   public String login(){
	   //判断登录选择学生、老师还是管理员
	   //分段核对信息合法性
	    if(getUserclass().equals("管理员")){
		      if(LoginService.findAdmin(getAccount(),getPassword())){
				    //核对成功
				   Administrator CurrentAdmin =LoginService.selectCurrentAdmin(getAccount(),getPassword());
				   //获取管理员用户名，并把用户名存入session
					String userName = CurrentAdmin.getAdministratorName();
					getRequest().getSession().setAttribute("userName",userName);
					 //获取用户类型，并存入session
					int userType = CurrentAdmin.getUserType();
					getRequest().getSession().setAttribute("userType",userType);
					//移除error值
					getRequest().getSession().removeAttribute("error");
					//跳转页面
					forwardView=MAIN_JSP;
				    return SUCCESS;	
		   }else{			   
				   //核对失败
				   //返回error结果
				   error="用户名或密码错误！";
				   getRequest().getSession().setAttribute("error",error);
				   //返回页面
				   forwardView=Login_JSP;}		   		 
		 }else if(userclass.equals("教师")){
			   if(LoginService.findTeacher(getAccount(),getPassword())){				   
				    //核对成功
				    //存入Session
				   Teacher CurrentTeacher =LoginService.selectCurrentTeacher(getAccount(),getPassword());
				   String userName = CurrentTeacher.getTeacherName();
					getRequest().getSession().setAttribute("userName",userName);
					 //获取用户类型，并存入session
					int userType = CurrentTeacher.getUserType();
					getRequest().getSession().setAttribute("userType",userType);
					//移除error值
					getRequest().getSession().removeAttribute("error");
					//跳转页面
				   forwardView=MAIN_JSP;
			   }else{
				   //核对失败
				   //返回error结果
				   error="用户名或密码错误！";  
				   getRequest().getSession().setAttribute("error",error);
				   //返回页面                                                                              
				   forwardView=Login_JSP;			   
			   }
		 }else if(userclass.equals("学生")){
	           if(LoginService.findStudent(getAccount(),getPassword())){
			        //核对成功
			        //存入Session
	        	 	Student CurrentStudent =LoginService.selectCurrentStudent(getAccount(),getPassword());
					String userName = CurrentStudent.getStudentName();
				    getRequest().getSession().setAttribute("userName",userName);
				    //获取用户类型，并存入session
					int userType = CurrentStudent.getUserType();
					getRequest().getSession().setAttribute("userType",userType);
				    //移除error值
				    getRequest().getSession().removeAttribute("error");
				    //跳转页面
					forwardView=MAIN_JSP;
	           }else{
				   //核对失败
				   //返回error结果
				   error="用户名或密码错误！";  
				   getRequest().getSession().setAttribute("error",error);
				   //返回页面
				   forwardView=Login_JSP;			   
			   }
       }
	       return SUCCESS;		
   } 
   
   public String logout() {
	   //getRequest().getSession().removeAttribute("error");
	   //初始化session
	   getRequest().getSession().invalidate();
	   forwardView=Login_JSP;
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
		forwardView = LEFT_JSP;
		return SUCCESS;
	}
	public String openSTLeft(){
		forwardView = LEFT_JSP;
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

package com.gxuwz.Market.business.action.web.front;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.Teacher;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.Market.business.service.IAdminService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings({ "rawtypes", "serial" })
public class AdminAction extends BaseAction implements Preparable, ModelDriven {
	protected static final String LIST1_JSP = "/WEB-INF/page/admin/admin_check.jsp";
//	protected static final String ADD_JSP = "/WEB-INF/page/stu_add.jsp";
//	protected static final String LIST_JSP = "/WEB-INF/page/gly_xinxi.jsp";
//	protected static final String LIST2_JSP = "/WEB-INF/page/stu_list.jsp";
	protected static final String FAIL_JSP = "/WEB-INF/page/admin/admin_checkFail.jsp";
	protected static final String DETAIL_JSP = "/WEB-INF/page/admin/admin_checkDetails.jsp";
	protected static final String PASS_JSP = "/WEB-INF/page/admin/admin_checkPass.jsp";

	protected final Log logger = LogFactory.getLog(getClass());

	private Result<Exam> pageResult; // 分页
	@Autowired
	private IAdminService adminService;
	private Testpaper testpaper;
	private Exam exam;
	private Integer examId;
	private Student student;
	private Result<Student> pageResult1;
	private Result<Teacher> pageResult2;
	private Teacher teacher;
	private List<Exam> exa;

	/**
	 * 查询待审核试卷列表
	 * @return
	 * @throws Exception
	 * @author 
	 * @date 2019.8.10
	 */
	public String list() throws Exception {
		logger.info("##ysRole列表读取...");
		pageResult = adminService.find(exam, getPage(), getRow());
		setForwardView(LIST1_JSP);
		return SUCCESS;
	}

	/**
	 * 通过(通过更新考试状态为通过标记实现通过考试）
	 * @return
	 * @throws @author
	 * @date 2018.6.1
	 */
	public String update() throws Exception {
		adminService.update(examId);
		return list();// 通过志愿后返回的还是未审核志愿的当前列表
	}

	/**
	 * 不通过(通过更新考试状态为不通过座位标记实现不通过考试）
	 * @return
	 * @throws @author
	 * @date 2018.6.1
	 */
	public String update1() throws Exception {
		adminService.update1(examId);
		return list();// 通过志愿后返回的还是未审核志愿的当前列表
	}

	/**
	 * 查看审核通过列表
	 * @return
	 * @throws Exception
	 * @author 
	 * @date 2019.8.10
	 */
	public String pass() throws Exception {
		logger.info("##ysRole列表读取...");
		pageResult = adminService.findPass(exam, getPage(), getRow());
		setForwardView(PASS_JSP);
		return SUCCESS;
	}
	/**
	 * 查看审核不通过列表
	 * @return
	 * @throws Exception
	 * @author 
	 * @date 2019.8.10
	 */
	public String fail() throws Exception {
		logger.info("##ysRole列表读取...");
		pageResult = adminService.findFail(exam, getPage(), getRow());
		setForwardView(FAIL_JSP);
		return SUCCESS;
	}

//	public String list1() throws Exception {
//		logger.info("##ysRole列表读取...");
//		pageResult1 = adminService.findStudent(student, getPage(), getRow());
//		setForwardView(LIST2_JSP);
//		return SUCCESS;
//	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list2() throws Exception {
		logger.info("##ysRole列表读取...");
		pageResult2 = adminService.findTeacher(teacher, getPage(), getRow());
		setForwardView(DETAIL_JSP);
		return SUCCESS;
	}
	
	/**
	 * 查询考试基本信息
	 * @return
	 */
	public String openExam() {
		logger.info("##ysRole列表读取...");
		//String ss=Integer.toString(examId);
		Exam exam =adminService.findExam(examId);
		ActionContext.getContext().getSession().put("exam", exam);
		setForwardView(DETAIL_JSP);
		return SUCCESS;
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	public Result<Exam> getPageResult() {
		return pageResult;
	}

	public void setPageResult(Result<Exam> pageResult) {
		this.pageResult = pageResult;
	}

	public IAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	public Testpaper getTestpaper() {
		return testpaper;
	}

	public void setTestpaper(Testpaper testpaper) {
		this.testpaper = testpaper;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Result<Student> getPageResult1() {
		return pageResult1;
	}

	public void setPageResult1(Result<Student> pageResult1) {
		this.pageResult1 = pageResult1;
	}

	public Result<Teacher> getPageResult2() {
		return pageResult2;
	}

	public void setPageResult2(Result<Teacher> pageResult2) {
		this.pageResult2 = pageResult2;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Exam> getExa() {
		return exa;
	}

	public void setExa(List<Exam> exa) {
		this.exa = exa;
	}
	

}
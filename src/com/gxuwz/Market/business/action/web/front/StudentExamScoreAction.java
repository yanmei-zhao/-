package com.gxuwz.Market.business.action.web.front;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.Studentexamscore;
import com.gxuwz.Market.business.entity.Studentscore;
import com.gxuwz.Market.business.service.IStudentExamScoreService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("serial")
public class StudentExamScoreAction extends BaseAction implements Preparable, ModelDriven{

	protected static final String LIST_JSP = "/WEB-INF/page/student/score_list.jsp";
	protected static final String LIST1_JSP = "/WEB-INF/page/teacher/student_score_list.jsp";
	
	protected final Log logger=LogFactory.getLog(getClass());
	private Result<Studentexamscore> pageResult; //分页
	private Result<Studentscore> pageResult1; //分页
	private Studentexamscore studentExamScore;
	private Studentscore studentScore;
	@Autowired
	private IStudentExamScoreService studentExamScoreService;
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		if(null == studentExamScore){
			studentExamScore = new Studentexamscore();
		}
		if(null == studentScore){
			studentScore = new Studentscore();
		}
	}

	/**
	 * 成绩列表（学生端）
	 * @return
	 * @throws Exception
	 */
	public String list()throws Exception{
		logger.info("##studentExamScore列表读取...");
		int studentId = Integer.parseInt((String) getRequest().getSession().getAttribute("studentId"));
		pageResult = studentExamScoreService.find(studentExamScore, studentId,getPage(), getRow());
		setForwardView(LIST_JSP);
		return SUCCESS;
	}

	/**
	 * 成绩列表（教师端）
	 * @return
	 * @throws Exception
	 */
	public String listAll()throws Exception{
		logger.info("##studentExamScore列表读取...");
		pageResult1 = studentExamScoreService.listAll(studentScore, getPage(), getRow());
		setForwardView(LIST1_JSP);
		return SUCCESS;
	}

	public Studentexamscore getStudentExamScore() {
		return studentExamScore;
	}

	public Result<Studentexamscore> getPageResult() {
		return pageResult;
	}

	public void setPageResult(Result<Studentexamscore> pageResult) {
		this.pageResult = pageResult;
	}

	public Log getLogger() {
		return logger;
	}

	public void setStudentExamScore(Studentexamscore studentExamScore) {
		this.studentExamScore = studentExamScore;
	}

	public IStudentExamScoreService getStudentExamScoreService() {
		return studentExamScoreService;
	}

	public void setStudentExamScoreService(IStudentExamScoreService studentExamScoreService) {
		this.studentExamScoreService = studentExamScoreService;
	}

	public Result<Studentscore> getPageResult1() {
		return pageResult1;
	}

	public void setPageResult1(Result<Studentscore> pageResult1) {
		this.pageResult1 = pageResult1;
	}

	public Studentscore getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(Studentscore studentScore) {
		this.studentScore = studentScore;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

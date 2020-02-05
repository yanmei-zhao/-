package com.gxuwz.Market.business.action.web.front;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.Group;
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

	/**
	 * 使用POI导出(学生成绩)Excel文件，提供下载
	 * @throws IOException 
	 */
	public String exportXls() throws IOException {
		//查出所有分区数据
		List<Object[]> list = studentExamScoreService.getAllStudentScore();
		// 在内存中创建一个Excel文件，通过输出流写到客户端提供下载
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		// 创建一个sheet页
		XSSFSheet sheet = xssfWorkbook.createSheet("学生成绩表");
		// 创建标题行
		XSSFRow headRow = sheet.createRow(0);
		//创建行内的每一个单元格，总共四列
		headRow.createCell(0).setCellValue("考试名称");
		headRow.createCell(1).setCellValue("学生姓名");
		headRow.createCell(2).setCellValue("学号");
		headRow.createCell(3).setCellValue("年级");
		headRow.createCell(4).setCellValue("成绩");
		
		//遍历list,动态加入到单元格中
		for (Object[] score : list) {
			//每遍历一次，在末尾行动态添加一行
			XSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
			//动态添加数据
			dataRow.createCell(0).setCellValue((String) score[0]);
			dataRow.createCell(1).setCellValue((String) score[1]);
			dataRow.createCell(2).setCellValue((String) score[2]);
			dataRow.createCell(3).setCellValue((String) score[3]);
			dataRow.createCell(4).setCellValue((String) score[4]);
		}
		//添加完成后，使用输出流下载
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		
		String filename = "score.xlsx";
		String contentType = ServletActionContext.getServletContext().getMimeType(filename);
		//设置文件的类型（后缀名）
		ServletActionContext.getResponse().setContentType(contentType);
		//设置响应头，指定下载的文件名
		ServletActionContext.getResponse().setHeader("content-disposition", "attchment;filename="+filename);
		//使用workbook提供的write方法
		xssfWorkbook.write(out);
		return NONE;
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

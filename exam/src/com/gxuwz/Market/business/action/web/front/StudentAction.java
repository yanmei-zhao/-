package com.gxuwz.Market.business.action.web.front;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.dao.GroupDAO;
import com.gxuwz.Market.business.dao.StudentDAO;
import com.gxuwz.Market.business.entity.Group;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.service.IStudentService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
/**
 * 
 *<p>Title:StudentAction</p>
 *<p>Description:</p>
 * @author zhaoyanmei
 * @date 2019年1月24日下午4:52:21
 */

public class StudentAction extends BaseAction implements Preparable, ModelDriven{
	protected static final String LIST_JSP = "/WEB-INF/page/user/student_list.jsp";
	protected static final String ADD_JSP = "/WEB-INF/page/user/student_add.jsp";
	protected static final String EDIT_JSP = "/WEB-INF/page/user/student_edit.jsp";
	protected static final String EDIT1_JSP = "/WEB-INF/page/user/importList.jsp";
	
	protected final Log logger=LogFactory.getLog(getClass());
	
	private Result<Student> pageResult; //分页
	private Student student;
	
	private File myFile;
	
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	
	@Autowired
	private IStudentService studentService;
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		if(null == student){
			student = new Student();
		}
	}
	
	public String openList1(){
		forwardView = EDIT1_JSP;
		return SUCCESS;
	}
	
	/**
	 * 学生列表
	 * @return
	 * @throws Exception
	 */
	public String list()throws Exception{
		logger.info("##Student列表读取...");
		pageResult = studentService.find(student, getPage(), getRow());
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	/**新增学生
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		//获取student传过来的值
		String studentId = student.getStudentId();
		String className = student.getClassName();
		String grade = student.getGrade();
		List<Group> student1 = studentService.findClassIdByClassName(className, grade);
		student.setClassId(student1.get(0).getClassId());
		student.setStudentPassword(studentId);
		studentService.add(student);
		student.setStudentName(null);
		student.setClassName(null);
		return list();
	}
	/**
	 * 保存修改信息
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		studentService.update(student);
		student.setStudentName(null);
		student.setClassName(null);
		return list();
	}
	/**
	 * 删除学生
	 * @return
	 * @throws Exception
	 */
	
	public String delete() throws Exception{
		studentService.delete(student.getStudentId());
		student.setStudentName(null);
		student.setClassName(null);
		return list();
	}
	/**
	 * 页面跳转
	 * @return
	 */
	public String openList(){
		return SUCCESS;
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String openAdd(){
		forwardView = ADD_JSP;
		return SUCCESS;
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String openEdit(){
		student = studentService.findById(student.getStudentId());
		forwardView = EDIT_JSP;
		return SUCCESS;
	}
	
	@Override
	public Object getModel() {
		
		return student;
	}


	public Result<Student> getPageResult() {
		return pageResult;
	}

	public void setPageResult(Result<Student> pageResult) {
		this.pageResult = pageResult;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	/**
	 * 
	 * @author zym
	 * @date 下午10:53:48
	 * @description Excel批量导入
	 */
	public String importXls() throws Exception{
		String flag = "1";
		try{
		    //使用POI接口解析Excel文件
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(myFile));
			//获得第一个sheet页
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			//集合
			List<Student> list = new ArrayList<Student>();
			for(Row row : sheet){
				int rowNum = row.getRowNum();
				if(rowNum == 0){
					//忽略第一行
					continue;
				}
				String studentId = row.getCell(0).getStringCellValue();
				String studentName = row.getCell(1).getStringCellValue();
				int classId = (int) row.getCell(2).getNumericCellValue(); 
				String className =  row.getCell(3).getStringCellValue(); 
				String grade =  row.getCell(4).getStringCellValue(); 
				String studentPassword = studentId;
				int useType = 1;
				Student student = new Student(studentId,studentName,classId,className,grade,studentPassword,useType);
				list.add(student);
			}
			studentService.addBatch(list);
		}catch (Exception e) {
			flag = "0";
			System.out.println(e.getMessage());
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(flag);
		return NONE;
	}
	
	
	/**
	 * 使用POI导出Excel文件，提供下载
	 * @throws IOException 
	 */
	public String exportXls() throws IOException {
		//查出所有分区数据
		List<Student> list = studentService.getStudentAll();
		// 在内存中创建一个Excel文件，通过输出流写到客户端提供下载
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		// 创建一个sheet页
		XSSFSheet sheet = xssfWorkbook.createSheet("学生表");
		sheet.setColumnWidth(1, 50*256);
		// 创建标题行
		XSSFRow headRow = sheet.createRow(0);
		//创建行内的每一个单元格，总共六列
		headRow.createCell(0).setCellValue("学号");
		headRow.createCell(1).setCellValue("姓名");
		headRow.createCell(2).setCellValue("班级Id");
		headRow.createCell(3).setCellValue("班级");
		headRow.createCell(4).setCellValue("年级");
		headRow.createCell(5).setCellValue("密码");
        
		//遍历list,动态加入到单元格中
		for (Student student : list) {
			//每遍历一次，在末尾行动态添加一行
			XSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
			//动态添加数据
			dataRow.createCell(0).setCellValue(student.getStudentId());
			dataRow.createCell(1).setCellValue(student.getStudentName());
			dataRow.createCell(2).setCellValue(student.getClassId());
			dataRow.createCell(3).setCellValue(student.getClassName());
			dataRow.createCell(4).setCellValue(student.getGrade());
			dataRow.createCell(5).setCellValue(student.getStudentPassword());
		}
		//添加完成后，使用输出流下载
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		
		String filename = "student.xlsx";
		String contentType = ServletActionContext.getServletContext().getMimeType(filename);
		//设置文件的类型（后缀名）
		ServletActionContext.getResponse().setContentType(contentType);
		//设置响应头，指定下载的文件名
		ServletActionContext.getResponse().setHeader("content-disposition", "attchment;filename="+filename);
		//使用workbook提供的write方法
		xssfWorkbook.write(out);
		return NONE;
	}
	
	/**
	 * 使用POI导出模板Excel文件，提供下载
	 * @throws IOException 
	 */
	public String exportTemplateXls() throws IOException {
		// 在内存中创建一个Excel文件，通过输出流写到客户端提供下载
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		// 创建一个sheet页
		XSSFSheet sheet = xssfWorkbook.createSheet("学生模板表");
		// 创建标题行
		XSSFRow headRow = sheet.createRow(0);
		//创建行内的每一个单元格，总共六列
		headRow.createCell(0).setCellValue("学号(数字需转成文本类型)");
		headRow.createCell(1).setCellValue("姓名");
		headRow.createCell(2).setCellValue("班级Id");
		headRow.createCell(3).setCellValue("班级");
		headRow.createCell(4).setCellValue("年级");
        
		//添加完成后，使用输出流下载
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		
		String filename = "studentTemplate.xlsx";
		String contentType = ServletActionContext.getServletContext().getMimeType(filename);
		//设置文件的类型（后缀名）
		ServletActionContext.getResponse().setContentType(contentType);
		//设置响应头，指定下载的文件名
		ServletActionContext.getResponse().setHeader("content-disposition", "attchment;filename="+filename);
		//使用workbook提供的write方法
		xssfWorkbook.write(out);
		return NONE;
	}
}

package com.gxuwz.Market.business.action.web.front;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.Teacher;
import com.gxuwz.Market.business.service.ITeacherService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 
 *<p>Title:teacherAction</p>
 *<p>Description:</p>
 * @author zhaoyanmei
 * @date 2019年1月24日下午5:25:52
 */
public class TeacherAction extends BaseAction implements Preparable, ModelDriven{
	
	protected static final String LIST_JSP = "/WEB-INF/page/user/teacher_list.jsp";
	protected static final String ADD_JSP = "/WEB-INF/page/user/teacher_add.jsp";
	protected static final String EDIT_JSP = "/WEB-INF/page/user/teacher_edit.jsp";
	protected static final String UPDATE_JSP = "/WEB-INF/page/teacher/password_update.jsp";
	protected static final String INDEX_JSP = "/WEB-INF/page/index1.jsp";//登录后中心页面（教师或管理员）
	protected final Log logger=LogFactory.getLog(getClass());
	
	private Result<Teacher> pageResult; //分页
	private Teacher teacher;
	
    private File myFile;
	
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	@Autowired
	private ITeacherService teacherService;
	
	@Override
	public void prepare() throws Exception {
		if(null == teacher){
			teacher = new Teacher();
		}
	}
	/**
	 * 教师列表
	 * @return
	 * @throws Exception
	 */
	public String list()throws Exception{
		logger.info("##teacher列表读取...");
		pageResult = teacherService.find(teacher, getPage(), getRow());
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	/**
	 * 添加题库
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		teacherService.add(teacher);
		teacher.setTeacherName(null);
		return list();
	}
	
	/**
	 * 保存修改信息(管理员端)
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		teacherService.update(teacher);
		teacher.setTeacherName(null);
		return list();
	}
	
	/**
	 * 保存修改信息(教师端)
	 * @return
	 * @throws Exception
	 */
	public String update1() throws Exception{
		teacherService.update(teacher);
		forwardView = INDEX_JSP;
		return SUCCESS;
	}
	
	/**
	 * 删除题库
	 * @return
	 * @throws Exception
	 */
	
	public String delete() throws Exception{
		teacherService.delete(teacher.getTeacherId());
		teacher.setTeacherName(null);
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
		teacher = teacherService.findById(teacher.getTeacherId());
		forwardView = EDIT_JSP;
		return SUCCESS;
	}
	
	public String openPassword(){
		int userID=  (int) getRequest().getSession().getAttribute("userID");
		teacher = teacherService.findById(userID);
		forwardView = UPDATE_JSP;
		return SUCCESS;
	}
	
	@Override
	public Object getModel() {
		
		return teacher;
	}

	public Result<Teacher> getPageResult() {
		return pageResult;
	}

	public void setPageResult(Result<Teacher> pageResult) {
		this.pageResult = pageResult;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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
			List<Teacher> list = new ArrayList<Teacher>();
			for(Row row : sheet){
				int rowNum = row.getRowNum();
				if(rowNum == 0){
					//忽略第一行
					continue;
				}
				String teacherName = row.getCell(0).getStringCellValue();
				/*int courseId = (int) row.getCell(1).getNumericCellValue(); 
				int classId = (int) row.getCell(2).getNumericCellValue(); */
				Random random = new Random();
				int a = random.nextInt(100000);
				String teacherPassword = teacherName+a;
				System.out.println("teacherPassword=="+teacherPassword);
				int userType= 2;
				Teacher teacher = new Teacher(teacherName,teacherPassword,userType);
				list.add(teacher);
			}
			teacherService.addBatch(list);
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
		List<Teacher> list = teacherService.getTeacherAll();
		// 在内存中创建一个Excel文件，通过输出流写到客户端提供下载
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		// 创建一个sheet页
		XSSFSheet sheet = xssfWorkbook.createSheet("教师表");
		// 创建标题行
		XSSFRow headRow = sheet.createRow(0);
		//创建行内的每一个单元格，总共六列
		headRow.createCell(0).setCellValue("教师编码");
		headRow.createCell(1).setCellValue("教师姓名");
		headRow.createCell(2).setCellValue("教师密码");
		//遍历list,动态加入到单元格中
		for (Teacher teacher : list) {
			//每遍历一次，在末尾行动态添加一行
			XSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
			//动态添加数据
			dataRow.createCell(0).setCellValue(teacher.getTeacherId());
			dataRow.createCell(1).setCellValue(teacher.getTeacherName());
			dataRow.createCell(2).setCellValue(teacher.getTeacherPassword());
		}
		//添加完成后，使用输出流下载
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		
		String filename = "teacher.xlsx";
		
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
	 * 使用POI导出教师模板Excel文件，提供下载
	 * @throws IOException 
	 */
	public String exportTemplateXls() throws IOException {
		// 在内存中创建一个Excel文件，通过输出流写到客户端提供下载
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		// 创建一个sheet页
		XSSFSheet sheet = xssfWorkbook.createSheet("教师模板表");
		// 创建标题行
		XSSFRow headRow = sheet.createRow(0);
		//创建行内的每一个单元格，总共六列
		headRow.createCell(0).setCellValue("教师姓名");
        
		//添加完成后，使用输出流下载
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		
		String filename = "teacherTemplate.xlsx";
		
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

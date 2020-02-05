package com.gxuwz.Market.business.action.web.front;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.Group;
import com.gxuwz.Market.business.service.IGroupService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;


/**
 *<p>Title:GroupAction</p>
 *<p>Description:</p>
 * @author Administrator
 * @date 2019年12月29日下午4:42:45
 */
public class GroupAction extends BaseAction implements Preparable, ModelDriven{

	protected static final String LIST_JSP = "/WEB-INF/page/user/class_list.jsp";
	protected static final String ADD_JSP = "/WEB-INF/page/user/class_add.jsp";
	protected static final String EDIT_JSP = "/WEB-INF/page/user/class_edit.jsp";
	protected static final String LIST1_JSP = "/WEB-INF/page/user/student_list.jsp";
	protected static final String ADD1_JSP = "/WEB-INF/page/user/student_add.jsp";
	protected static final String LOGIN_JSP = "/WEB-INF/page/index.jsp";
	
	protected final Log logger=LogFactory.getLog(getClass());
	
	private Result<Group> pageResult; //分页
	private Group group;
	private File myFile;
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	@Autowired
	private IGroupService groupService;
	
	@Override
	public void prepare() throws Exception {
		if(null == group){
			group = new Group();
		}
	}

	/**
	 * 班级列表
	 * @return
	 * @throws Exception
	 */
	public String list()throws Exception{
		logger.info("##group列表读取...");
    	pageResult = groupService.find(group, getPage(), getRow());
		
//		List<Group> list = groupService.getGroupAll();
		//查询并遍历出studentNumber,新加的
		for(Group rs : pageResult.getData()) {
			Integer classId=rs.getClassId();
			int total =(int) groupService.getAllStudentNum(classId);
			rs.setStudentNumber(total);
		}
    	setForwardView(LIST_JSP);
		return SUCCESS;
	}
	
	/**
	 * 添加班级 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		groupService.add(group);
		group.setClassName(null);
		return list();
	}
	/**
	 * 保存修改信息
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		groupService.update(group);
		group.setClassName(null);
		return list();
	}
	/**
	 * 删除班级
	 * @return
	 * @throws Exception
	 */
	
	public String delete() throws Exception{
		groupService.delete(group.getClassId());
		group.setClassName(null);
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
		group = groupService.findById(group.getClassId());
		forwardView = EDIT_JSP;
		return SUCCESS;
	}
	
	/**
	 * 查询班级名称并返回学生添加页面
	 * @return
	 * @throws Exception
	 */
	public String getClassNameAll() throws Exception{
		 List<String> classNameList=groupService.getClassNameAll();
	    getRequest().getSession().setAttribute("classNameList",classNameList);
		setForwardView(ADD1_JSP);
		return SUCCESS;
	}
	
//	/*
//	 * 获取存在的模板数据并返回前端
//	 */
//	public void templates() throws IOException{
//		HttpServletResponse response=
//				ServletActionContext.getResponse();
//		response.setContentType("text/html;UTF-8");
//		List<Template>list =new ArrayList<Template>();
//		Template t=new Template();
//		t.setTemplateId("student");
//		t.setTemplateName("student");
//		list.add(t);
//		response.getWriter().write(JSONArray.fromObject(list).toString());
//	}
	
	@Override
	public Object getModel() {
		
		return group;
	}

	public Result<Group> getPageResult() {
		return pageResult;
	}

	public void setPageResult(Result<Group> pageResult) {
		this.pageResult = pageResult;
	}

	public Group getGroup() {
		return group;
	}

	public void setClass(Group group) {
		this.group = group;
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
			List<Group> list = new ArrayList<Group>();
			for(Row row : sheet){
				int rowNum = row.getRowNum();
				if(rowNum == 0){
					//忽略第一行
					continue;
				}
				String className =  row.getCell(0).getStringCellValue(); 
				String grade =  row.getCell(1).getStringCellValue(); 
				String institute = row.getCell(2).getStringCellValue();
				Integer studentNumber = 0;
				Group group = new Group(className,grade,institute,studentNumber);
				list.add(group);
			}
			groupService.addBatch(list);
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
		List<Group> list = groupService.getGroupAll();
		// 在内存中创建一个Excel文件，通过输出流写到客户端提供下载
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		// 创建一个sheet页
		XSSFSheet sheet = xssfWorkbook.createSheet("班级表");
		// 创建标题行
		XSSFRow headRow = sheet.createRow(0);
		//创建行内的每一个单元格，总共四列
		headRow.createCell(0).setCellValue("班级名称");
		headRow.createCell(1).setCellValue("年级");
		headRow.createCell(2).setCellValue("所属学院");
        
		//遍历list,动态加入到单元格中
		for (Group group : list) {
			//每遍历一次，在末尾行动态添加一行
			XSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
			//动态添加数据
			dataRow.createCell(0).setCellValue(group.getClassName());
			dataRow.createCell(1).setCellValue(group.getGrade());
			dataRow.createCell(2).setCellValue(group.getInstitute());
		}
		//添加完成后，使用输出流下载
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		
		String filename = "class.xlsx";
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
		XSSFSheet sheet = xssfWorkbook.createSheet("班级模板表");
		// 创建标题行
		XSSFRow headRow = sheet.createRow(0);
		//创建行内的每一个单元格，总共六列
		headRow.createCell(0).setCellValue("班级名称");
		headRow.createCell(1).setCellValue("年级");
		headRow.createCell(2).setCellValue("学院");
		//添加完成后，使用输出流下载
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		
		String filename = "classTemplate.xlsx";
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

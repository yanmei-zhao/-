package com.gxuwz.Market.business.action.web.front;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.entity.FillTopic;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.Market.business.entity.TopicBank;
import com.gxuwz.Market.business.service.IFillTopicService;
import com.gxuwz.Market.business.service.ITopicBankService;
import com.gxuwz.Market.business.service.TopicService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 *<p>Title:FillTopicAction</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年1月4日下午2:20:19
 */
@SuppressWarnings("serial")
public class FillTopicAction extends BaseAction implements Preparable, ModelDriven{

	protected static final String LIST_JSP = "/WEB-INF/page/topic/fill_list.jsp";
	protected static final String ADD_JSP = "/WEB-INF/page/topic/topic_add.jsp";
	protected static final String EDIT_JSP = "/WEB-INF/page/topic/fill_edit.jsp";
	protected static final String VIEW_JSP = "/WEB-INF/page/topic/fill_preview.jsp";
	protected static final String ADDTOPIC_JSP = "/WEB-INF/page/topic/topic_to_paper.jsp";
	
	protected final Log logger=LogFactory.getLog(getClass());
	
	private Result<FillTopic> pageResult; //分页
	private FillTopic fillTopic;
	private String topicBankName;
	private TopicBank topicBank;
	public Log getLogger() {
		return logger;
	}
	
	private File myFile;
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	@Autowired
	private IFillTopicService fillTopicService;
	@Autowired
	private ITopicBankService topicBankService;
	@Autowired
	private TopicService topicService;
	@Override
	public void prepare() throws Exception {
		if(null == fillTopic){
			fillTopic = new FillTopic();
			topicBank = new TopicBank();
		}
	}

	/**
	 * 获得试题列表
	 * @return
	 * @throws Exception
	 * @author zym
	 * @date 2019.12.29
	 */
	public String list()throws Exception{
		logger.info("##fillTopic列表读取...");
		pageResult = fillTopicService.find(fillTopic, getPage(), getRow());
		
//		 List<String> TopicBankNameList=fillTopicService.getTopicBankNameAll();
//		getRequest().getSession().setAttribute("TopicBankNameList",TopicBankNameList);
		
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	
	/**
	 * 试卷点击添加试题后的查询
	 */
	public String listtopic()throws Exception{
		logger.info("##试题列表读取...");
		pageResult = fillTopicService.find(fillTopic, getPage(), getRow());
		setForwardView(ADDTOPIC_JSP);
		return SUCCESS;
	}
	
	/**
	 * 添加试题
	 * @return
	 * @throws Exception
	 * @author zym
	 * @date 2019.8.10
	 */
	public String add() throws Exception{
		topicBank =  topicBankService.findByName(fillTopic.getTopicBankName());
		fillTopic.setTopicBankId(topicBank.getTopicBankId());
		fillTopicService.add(fillTopic);
		fillTopic = new FillTopic();
		return list();
	}
	
	/**
	 * 保存修改信息
	 * @return
	 * @throws Exception
	 * @author zym
	 * @date 2019.8.10
	 */
	public String update() throws Exception{
		fillTopicService.update(fillTopic);
		fillTopic.setId(null);
		fillTopic.setDescription(null);
		fillTopic.setTopicBankName(null);
		return list();
	}
	/**
	 * 删除权限
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		fillTopicService.delete(fillTopic.getId());
		fillTopic.setId(null);
		fillTopic.setDescription(null);
		fillTopic.setTopicBankName(null);
		return list();
	}
	/**
	 * 删除课题
	 * @return
	 * @throws Exception
	 */
	public String delete1() throws Exception {
		fillTopicService.delete(fillTopic.getId());
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	
	/**
	 * 批量删除填空题
	 * @return
	 * @throws Exception
	 */
	public String deleteList() throws Exception{
		List<FillTopic> list = new ArrayList<FillTopic>();
		String[] fillTopicIdAll = getRequest().getParameterValues("checkbox");
		for(int i=0;i<fillTopicIdAll.length;i++){
			int fillId = Integer.parseInt(fillTopicIdAll[i]);
			FillTopic fillTopic = new FillTopic(fillId);
			list.add(fillTopic);
		}
		fillTopicService.deleteBatch(list);
		return list();
	}

	
	/**
	 * 页面跳转
	 * @return
	 * @author zym
	 * @date 2019.8.10
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
	 * @author zym
	 * @date 2019.8.10
	 */
	public String openEdit(){
		fillTopic = fillTopicService.findById(fillTopic.getId());
		getRequest().getSession().setAttribute("fillTopic",fillTopic);
		forwardView = EDIT_JSP;
		return SUCCESS;
	}
	/**
	 * 跳转到预览页面
	 * @author zym
	 * @date 2019.8.10
	 */
	public String openView(){
		fillTopic = fillTopicService.findById(fillTopic.getId());
		System.out.println("fillTopic.getAnswer()=="+fillTopic.getAnswer());
		getRequest().getSession().setAttribute("fillTopic",fillTopic);
		forwardView = VIEW_JSP;
		return SUCCESS;
	}

	/**
	 * 根据题库名字查询试题列表
	 * @return
	 * @throws Exception
	 */
	public String getlistByTopicBankName()throws Exception{
		logger.info("##Topic列表读取...");
		pageResult=fillTopicService.getlistByTopicBankName(fillTopic, getPage(), getRow(), fillTopic.getTopicBankName());
		/*String a = ServletActionContext.getRequest().getParameter("topicBankName");
		System.out.println("topicBankName===="+a);*/		
		setForwardView(LIST_JSP);
		return SUCCESS;
	}

	/**
	 * 根据题库名字查询填空题列表
	 * @return
	 * @throws Exception
	 */
	public String getFilllistByTopicBankId()throws Exception{
		logger.info("##Topic列表读取...");
		pageResult = topicService.getFilllistByTopicBankId(fillTopic, getPage(), getRow(), fillTopic.getTopicBankId());
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	
	public FillTopic getFillTopic() {
		return fillTopic;
	}

	public void setFillTopic(FillTopic fillTopic) {
		this.fillTopic = fillTopic;
	}

	public TopicBank getTopicBank() {
		return topicBank;
	}

	public void setTopicBank(TopicBank topicBank) {
		this.topicBank = topicBank;
	}

	@Override
	public Object getModel() {
		return fillTopic;
	}


	public Result<FillTopic> getPageResult() {
		return pageResult;
	}

	public File getMyFile() {
		return myFile;
	}

	public IFillTopicService getFillTopicService() {
		return fillTopicService;
	}

	public void setFillTopicService(IFillTopicService fillTopicService) {
		this.fillTopicService = fillTopicService;
	}

	public void setPageResult(Result<FillTopic> pageResult) {
		this.pageResult = pageResult;
	}

	public String getTopicBankName() {
		return topicBankName;
	}

	public void setTopicBankName(String topicBankName) {
		this.topicBankName = topicBankName;
	}

	/**
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
			List<FillTopic> list = new ArrayList<FillTopic>();
			for(Row row : sheet){
				int rowNum = row.getRowNum();
				if(rowNum == 0){
					//忽略第一行
					continue;
				}
				String description =  row.getCell(0).getStringCellValue(); 
				String difficulty =  "常规"; 
				String type = "填空题";
				String knowledge = row.getCell(1).getStringCellValue();
				String topicBankName = fillTopic.getTopicBankName();
				row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
				String answer = row.getCell(2).getStringCellValue();
				String creator = (String) getRequest().getSession().getAttribute("userName");
				FillTopic fillTopic = new FillTopic(description,difficulty,type,knowledge,topicBankName,answer,creator);
				list.add(fillTopic);
			}
			fillTopicService.addBatch(list);
		}catch (Exception e) {
			flag = "0";
			System.out.println("e.getMessage()=="+e.getMessage());
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(flag);
		return NONE;
	}
	
	/**
	 * 使用POI导出单选题模板Excel文件，提供下载
	 * @throws IOException 
	 */
	public String exportTemplateXls() throws IOException {
		// 在内存中创建一个Excel文件，通过输出流写到客户端提供下载
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		// 创建一个sheet页
		XSSFSheet sheet = xssfWorkbook.createSheet("填空题模板表");
		// 创建标题行
		XSSFRow headRow = sheet.createRow(0);
		//创建行内的每一个单元格，总共六列
		headRow.createCell(0).setCellValue("题目");
		headRow.createCell(1).setCellValue("知识点");
		headRow.createCell(2).setCellValue("答案");
		//添加完成后，使用输出流下载
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		
		String filename = "fillTopicTemplate.xlsx";
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

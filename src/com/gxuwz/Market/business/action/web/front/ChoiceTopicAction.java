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
import com.gxuwz.Market.business.entity.TopicBank;
import com.gxuwz.Market.business.service.IChoiceTopicService;
import com.gxuwz.Market.business.service.ITopicBankService;
import com.gxuwz.Market.business.service.TopicService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 *<p>Title:ChoiceTopicAction</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年1月4日下午5:06:15
 */
@SuppressWarnings("serial")
public class ChoiceTopicAction extends BaseAction implements Preparable, ModelDriven{

	protected static final String LIST_JSP = "/WEB-INF/page/topic/choice_list.jsp";
	protected static final String LIST1_JSP = "/WEB-INF/page/testpaper/choice_add.jsp";
	protected static final String ADD_JSP = "/WEB-INF/page/topic/topic_add.jsp";
	protected static final String EDIT_JSP = "/WEB-INF/page/topic/choice_edit.jsp";
	protected static final String VIEW_JSP = "/WEB-INF/page/topic/choice_preview.jsp";
	protected static final String VIEW1_JSP = "/WEB-INF/page/practise/practise_choicetopic.jsp";
	protected static final String VIEW2_JSP = "/WEB-INF/page/practise/practise_view2.jsp";
	protected static final String ADDTOPIC_JSP = "/WEB-INF/page/topic/topic_to_paper.jsp";
	
	protected final Log logger=LogFactory.getLog(getClass());
	
	private Result<ChoiceTopic> pageResult; //分页
	private Result<ChoiceTopic> pageResult1; //分页
	private Result<ChoiceTopic> pageResult2; //分页
	private ChoiceTopic choiceTopic;
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
	private IChoiceTopicService choiceTopicService ;
	@Autowired
	private ITopicBankService topicBankService;
	@Autowired
	private TopicService topicService;
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		if(null == choiceTopic){
			choiceTopic = new ChoiceTopic();
			topicBank = new TopicBank();
		}
	}

	/**
	 * 获取选择题列表
	 * *  @return
	 */
	public String list()throws Exception{
		logger.info("##topic列表读取...");
		pageResult = choiceTopicService.find(choiceTopic, getPage(), getRow());
		System.out.println("choiceTopic.getDescription()=="+choiceTopic.getDescription());
//		List<String> TopicBankNameList=choiceTopicService.getTopicBankNameAll();
//		getRequest().getSession().setAttribute("TopicBankNameList",TopicBankNameList);
		
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	
	/**
	 * 获取试题列表
	 * *  @return
	 */
	public String list1()throws Exception{
		logger.info("##topic列表读取...");
		pageResult2 = choiceTopicService.find(choiceTopic, getPage(), getRow());
		setForwardView(LIST1_JSP);
		return SUCCESS;
	}
	
	/**
	 * 试卷点击添加试题后的查询
	 *  @return
	 */
	public String listtopic()throws Exception{
		logger.info("##试题列表读取...");
		pageResult = choiceTopicService.find(choiceTopic, getPage(), getRow());
		setForwardView(ADDTOPIC_JSP);
		return SUCCESS;
	}
	
	/**
	 * 添加单选题
	 *  @return
	 */
	public String add() throws Exception{
		topicBank =  topicBankService.findByName(choiceTopic.getTopicBankName());
		choiceTopic.setTopicBankId(topicBank.getTopicBankId());
		choiceTopicService.add(choiceTopic);
		choiceTopic = new ChoiceTopic();
		return list();
	}
	
	/**
	 * 保存修改信息
	 *  @return
	 */
	public String update() throws Exception{
		choiceTopicService.update(choiceTopic);
		choiceTopic.setId(null);
		choiceTopic.setDescription(null);
		choiceTopic.setTopicBankName(null);
		return list();
	}
	
	/**
	 * 删除试题
	 *  @return
	 */
	public String delete() throws Exception{
		choiceTopicService.delete(choiceTopic.getId());
		choiceTopic.setDescription(null);
		choiceTopic.setId(null);
		return list();
	}
	
	/**
	 * 批量删除单选题
	 * @return
	 * @throws Exception
	 */
	public String deleteList() throws Exception{
		List<ChoiceTopic> list = new ArrayList<ChoiceTopic>();
		String[] choiceTopicIdAll = getRequest().getParameterValues("checkbox");
		for(int i=0;i<choiceTopicIdAll.length;i++){
			int choiceId = Integer.parseInt(choiceTopicIdAll[i]);
			ChoiceTopic choiceTopic = new ChoiceTopic(choiceId);
			list.add(choiceTopic);
		}
		choiceTopicService.deleteBatch(list);
		return list();
	}

	/**
	 * 练习选择题
	 * @return
	 * @throws exception
	 */
	public String practiseList()throws Exception{
		if((null!=ServletActionContext.getRequest().getParameter("topicBankName"))&&(null!= ServletActionContext.getRequest().getParameter("difficulty"))){
			String topicBankName = ServletActionContext.getRequest().getParameter("topicBankName");
			String difficulty = ServletActionContext.getRequest().getParameter("difficulty");
			getRequest().getSession().setAttribute("topicBankName",topicBankName);
			getRequest().getSession().setAttribute("difficulty",difficulty);
			pageResult1 = choiceTopicService.find1(difficulty, topicBankName,getPage(), getRow1());
		}else{
			String topicBankName =(String) getRequest().getSession().getAttribute("topicBankName");
			String difficulty =(String) getRequest().getSession().getAttribute("difficulty");
			pageResult1 = choiceTopicService.find1(difficulty, topicBankName,getPage(), getRow1());
		}
		setForwardView(VIEW1_JSP);
		return SUCCESS;
	}
	
	/**
	 * 练习习题界面
	 * @return
	 */
	public String openPractiseView(){
		forwardView = VIEW2_JSP;
		return SUCCESS;
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
	 * 跳转到修改试题页面
	 * @return
	 * @author
	 */
	public String openEdit(){
		choiceTopic = choiceTopicService.findById(choiceTopic.getId());
		forwardView = EDIT_JSP;
		return SUCCESS;
	}
	
	/**
	 * 跳转到试题预览页面
	 * @author zym
	 */
	public String openView(){
		choiceTopic = choiceTopicService.findById(choiceTopic.getId());
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
		pageResult = choiceTopicService.getlistByTopicBankName(choiceTopic, getPage(), getRow(), choiceTopic.getTopicBankName());
		/*String a = ServletActionContext.getRequest().getParameter("topicBankName");
		System.out.println("topicBankName===="+a);*/	//获取页面传过来的topicBankName	
		setForwardView(LIST_JSP);
		return SUCCESS;
	}

	/**
	 * 根据题库id查询单选题列表
	 * @return
	 * @throws Exception
	 */
	public String getChoicelistByTopicBankId()throws Exception{
		logger.info("##Topic列表读取...");
		pageResult = topicService.getChoicelistByTopicBankId(choiceTopic, getPage(), getRow(), choiceTopic.getTopicBankId());
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	
	public TopicBank getTopicBank() {
		return topicBank;
	}

	public void setTopicBank(TopicBank topicBank) {
		this.topicBank = topicBank;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Result<ChoiceTopic> getPageResult() {
		return pageResult;
	}

	public void setPageResult(Result<ChoiceTopic> pageResult) {
		this.pageResult = pageResult;
	}

	public Result<ChoiceTopic> getPageResult1() {
		return pageResult1;
	}

	public void setPageResult1(Result<ChoiceTopic> pageResult1) {
		this.pageResult1 = pageResult1;
	}

	public ChoiceTopic getChoiceTopic() {
		return choiceTopic;
	}

	public void setChoiceTopic(ChoiceTopic choiceTopic) {
		this.choiceTopic = choiceTopic;
	}

	public String getTopicBankName() {
		return topicBankName;
	}

	public void setTopicBankName(String topicBankName) {
		this.topicBankName = topicBankName;
	}

	public IChoiceTopicService getChoiceTopicService() {
		return choiceTopicService;
	}

	public ITopicBankService getTopicBankService() {
		return topicBankService;
	}

	public void setTopicBankService(ITopicBankService topicBankService) {
		this.topicBankService = topicBankService;
	}

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setChoiceTopicService(IChoiceTopicService choiceTopicService) {
		this.choiceTopicService = choiceTopicService;
	}

	public Result<ChoiceTopic> getPageResult2() {
		return pageResult2;
	}

	public void setPageResult2(Result<ChoiceTopic> pageResult2) {
		this.pageResult2 = pageResult2;
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
			List<ChoiceTopic> list = new ArrayList<ChoiceTopic>();
			for(Row row : sheet){
				int rowNum = row.getRowNum();
				if(rowNum == 0){
					//忽略第一行
					continue;
				}
				String description =  row.getCell(0).getStringCellValue(); 
				String knowledge =  row.getCell(1).getStringCellValue(); 
				row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
				String optionA = row.getCell(2).getStringCellValue();
				String optionB = row.getCell(3).getStringCellValue();
				String optionC = row.getCell(4).getStringCellValue();
				String optionD = row.getCell(5).getStringCellValue();
				String answer = row.getCell(6).getStringCellValue();
				String difficulty =  "常规"; 
				String type = "单选题";
				String topicBankName = getRequest().getParameter("topicBankName");
				String creator = (String) getRequest().getSession().getAttribute("userName");
				ChoiceTopic choiceTopic = new ChoiceTopic(description,knowledge,optionA,optionB,optionC,optionD,answer,difficulty,type,topicBankName,creator);
				list.add(choiceTopic);
			}
			choiceTopicService.addBatch(list);
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
		XSSFSheet sheet = xssfWorkbook.createSheet("单选题模板表");
		// 创建标题行
		XSSFRow headRow = sheet.createRow(0);
		//创建行内的每一个单元格，总共六列
		headRow.createCell(0).setCellValue("题目");
		headRow.createCell(1).setCellValue("知识点");
		headRow.createCell(2).setCellValue("选项A");
		headRow.createCell(3).setCellValue("选项B");
		headRow.createCell(4).setCellValue("选项C");
		headRow.createCell(5).setCellValue("选项D");
		headRow.createCell(6).setCellValue("答案");
		//添加完成后，使用输出流下载
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		
		String filename = "choicTopicTemplate.xlsx";
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

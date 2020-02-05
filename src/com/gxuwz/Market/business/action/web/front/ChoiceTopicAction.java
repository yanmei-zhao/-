package com.gxuwz.Market.business.action.web.front;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.entity.Course;
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
public class ChoiceTopicAction  extends BaseAction implements Preparable, ModelDriven{

	protected static final String LIST_JSP = "/WEB-INF/page/topic/choice_list.jsp";
	protected static final String LIST1_JSP = "/WEB-INF/page/testpaper/choice_add.jsp";
	protected static final String ADD_JSP = "/WEB-INF/page/topic/topic_add.jsp";
	protected static final String EDIT_JSP = "/WEB-INF/page/topic/choice_edit.jsp";
	protected static final String VIEW_JSP = "/WEB-INF/page/topic/choice_preview.jsp";
	protected static final String ADDTOPIC_JSP = "/WEB-INF/page/topic/topic_to_paper.jsp";
	
	protected final Log logger=LogFactory.getLog(getClass());
	
	private Result<ChoiceTopic> pageResult; //分页
	private Result<ChoiceTopic> pageResult2; //分页
	private ChoiceTopic choiceTopic;
	private String topicBankName;
	private TopicBank topicBank;
	public Log getLogger() {
		return logger;
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
		
//		 List<String> TopicBankNameList=choiceTopicService.getTopicBankNameAll();
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
			System.out.println("choiceId=="+choiceId);
			ChoiceTopic choiceTopic = new ChoiceTopic(choiceId);
			list.add(choiceTopic);
		}
		choiceTopicService.deleteBatch(list);
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

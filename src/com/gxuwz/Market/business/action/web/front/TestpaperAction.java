package com.gxuwz.Market.business.action.web.front;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import okhttp3.Request;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.entity.FillTopic;
import com.gxuwz.Market.business.service.IChoiceTopicService;
import com.gxuwz.Market.business.service.ICourseService;
import com.gxuwz.Market.business.service.IFillTopicService;
import com.gxuwz.Market.business.service.ITopicBankService;
import com.gxuwz.Market.business.service.TestpaperService;
import com.gxuwz.Market.business.service.TopicService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 试卷控制器
* <p>Title: TestpaperAction</p>     
* @author   
* @date 下午12:56:37
 */
@SuppressWarnings("serial")
public class TestpaperAction extends BaseAction implements Preparable, ModelDriven{
	
	protected static final String LIST_JSP = "/WEB-INF/page/testpaper/testPaper_list.jsp";
	protected static final String ADD_JSP = "/WEB-INF/page/testpaper/testPaper_add.jsp";
	protected static final String ADD2_JSP = "/WEB-INF/page/testpaper/testPaper_add_quickly.jsp";
	protected static final String EDIT_JSP = "/WEB-INF/page/testpaper/testPaper_edit.jsp";
    protected static final String ADDTOPIC_JSP ="/WEB-INF/page/testpaper/brieftopic_add.jsp";
    protected static final String ADDCTOPIC_JSP ="/WEB-INF/page/testpaper/choice_add.jsp";
    protected static final String ADDFTOPIC_JSP ="/WEB-INF/page/testpaper/fill_add.jsp";
    protected static final String ADD1_JSP = "/WEB-INF/page/exam/exam_add.jsp";
    protected static final String ADD3_JSP = "/WEB-INF/page/testpaper/question_add.jsp";
    protected static final String VIEW_JSP = "/WEB-INF/page/testpaper/testPaper_view.jsp";
	protected final Log logger=LogFactory.getLog(getClass());
	
	private Result<Testpaper> pageResult; //分页
	private Result<Topic> pageResult1; //分页
	private Result<ChoiceTopic> pageResult2; //分页
	private Result<FillTopic> pageResult3; //分页
	private Result<Topic> result; //试卷预览（简答题）
	private Result<ChoiceTopic> result1; //试卷预览（选择题）
	private Result<FillTopic> result2; //试卷预览（填空题）
	private Testpaper testpaper;
	private ChoiceTopic choiceTopic;
	private Topic topic;
	private FillTopic fillTopic;
	
	@Autowired
	private TestpaperService testpaperService;
	@Autowired
	private ICourseService courseService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private IChoiceTopicService choiceTopicService;
	@Autowired
	private IFillTopicService fillTopicService;
	@Autowired
	private ITopicBankService topicBankService;
	
	private int choiceTopicNum; //选择题 个数
	private int fillTopicNum ; // 填空题 个数
	private int topicNum; // 简答题 个数
	
	@Override
	public void prepare() throws Exception {
		if(null == testpaper){
			testpaper = new Testpaper();
			topic = new Topic();
			fillTopic = new FillTopic();
			choiceTopic = new ChoiceTopic();
		}
	}

	/**
	 * 试卷列表
	* @Title: list      
	* @return String    返回类型   
	* @throws
	 */
	public String list()throws Exception{
		logger.info("##testpaper列表读取...");
		pageResult = testpaperService.find(testpaper, getPage(), getRow());
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	
	/**
	 * 添加试卷
	* @Title: add      
	* @return void    返回类型   
	* @throws
	 */
	public String add() throws Exception{
		testpaperService.add(testpaper);
		testpaper.setTestpaperId(null);
		testpaper.setTestpaperName(null);
		return list();
	}

	/**
	 * 修改保存
	* @Title: update      
	* @return String    返回类型   
	* @throws
	 */
	public String update() throws Exception{
		testpaperService.update(testpaper);
		testpaper.setTestpaperId(null);
		testpaper.setTestpaperName(null);
		return list();
	}

	/**
	 * 删除
	* @Title: delete      
	* @return String    返回类型   
	* @throws
	 */
	public String delete() throws Exception{
		testpaperService.delete(testpaper.getTestpaperId());
		testpaper.setTestpaperName(null);
		testpaper.setTestpaperId(null);
		return list();
	}
	
	/**
	 * 预览试卷
	 * @return
	 * @throws Exception 2020/1/8
	 */
	public String openViewPaper() throws Exception{
		//查询试卷信息
		testpaper = testpaperService.findById(testpaper.getTestpaperId());
		getRequest().getSession().setAttribute("testpaper",testpaper);
		//获取试卷对应的试题
		logger.info("##topic试题读取...");
		result = testpaperService.getAllTopic(testpaper.getTestpaperId(), getPage(), getRow());
		result1 = testpaperService.getAllChoiceTopic(testpaper.getTestpaperId(), getPage(), getRow());
		result2 = testpaperService.getAllFillTopic(testpaper.getTestpaperId(), getPage(), getRow());
		setForwardView(VIEW_JSP);
		return SUCCESS;
	}
	
//	public String openViewPaper() throws Exception{
//		testpaper = testpaperService.findById(testpaper.getTestpaperId());
//		getRequest().getSession().setAttribute("testpaper",testpaper);
//		getRequest().getSession().setAttribute("testpapername",testpaper.getTestpaperName());
//		List<String> view=testpaperService.getAllTopicId(testpaper.getTestpaperId());
//	   	 Gson gson = new Gson();
//	   	  gson.toJson(view);
//	   getRequest().getSession().setAttribute("view",view);
//		setForwardView(VIEW_JSP);
//		return SUCCESS;
//	}
	
	/**
	 * 随机抽题
	 * @return
	 * @throws Exception
	 */
	public String CreateTestRandom() throws Exception{
		testpaperService.add(testpaper);
		topicService.composeExamRandom(testpaper, choiceTopicNum, fillTopicNum, topicNum);
		
		testpaper.setTestpaperId(null);
		testpaper.setTestpaperName(null);
		return list();
	}
	
	/**
     * 页面跳转
    * @Title: openList      
    * @return String    返回类型   
    * @throws
     */
	public String openList(){
		
		return SUCCESS;
	}
	
	/**
	 * 跳转到添加试题页面 
	* @Title: To_paper      
	* @return String    返回类型   
	* @throws
	 */
	public String Topaper(){
		forwardView = ADDTOPIC_JSP;
		return SUCCESS;
	}
	
	/**
	 * 试卷列表点击添加试题后返回的选择题列表
	 *  @return
	 */
	public String openChoiceTopicList()throws Exception{
		logger.info("##选择题列表读取...");
		if(null!=testpaper.getTestpaperId()){
			int testpaperId = testpaper.getTestpaperId();
			getRequest().getSession().setAttribute("testpaperId",testpaperId);
		}
		pageResult2 = choiceTopicService.find(choiceTopic, getPage(), getRow());
		setForwardView(ADDCTOPIC_JSP);
		return SUCCESS;
	}
	
	/**
	 * 试卷列表点击添加试题后返回的填空题列表
	 *  @return
	 */
	public String openFillTopicList()throws Exception{
		logger.info("##填空题列表读取...");
		if(null!=testpaper.getTestpaperId()){
			int testpaperId = testpaper.getTestpaperId();
			getRequest().getSession().setAttribute("testpaperId",testpaperId);
		}
		pageResult3 = fillTopicService.find(fillTopic, getPage(), getRow());
		setForwardView(ADDFTOPIC_JSP);
		return SUCCESS;
	}
	
	/**
	 * 试卷列表点击添加试题后返回的简答题列表
	 *  @return
	 */
	public String openTopicList()throws Exception{
		logger.info("##简答题列表读取...");
		if(null!=testpaper.getTestpaperId()){
			int testpaperId = testpaper.getTestpaperId();
			getRequest().getSession().setAttribute("testpaperId",testpaperId);
		}
		pageResult1 = topicService.find(topic, getPage(), getRow());
		setForwardView(ADDTOPIC_JSP);
		return SUCCESS;
	}
	
	/**
	 * 跳转到添加页面
	* @Title: openAdd      
	* @return String    返回类型   
	* @throws
	 */
	public String openAdd(){
		forwardView = ADD_JSP;
		return SUCCESS;
	}
	
	/**
	 * 跳转到配置试卷页面
	* @Title: openAdd      
	* @return String    返回类型   
	* @throws
	 */
	public String openAddTopic(){
		testpaper = testpaperService.findById(testpaper.getTestpaperId());
		forwardView = ADD3_JSP;
		return SUCCESS;
	}
	
	/**
	 * 跳转到快速添加页面
	* @Title: openAddquick      
	* @return String    返回类型   
	* @throws
	 */
	public String openAddquick(){
		forwardView = ADD2_JSP;
		return SUCCESS;
	}
	/**
	 * 跳转到编辑页面
	* @Title: openEdit      
	* @return String    返回类型   
	* @throws
	 */
	public String openEdit(){
		testpaper = testpaperService.findById(testpaper.getTestpaperId());
		forwardView = EDIT_JSP;
		return SUCCESS;
	}
	
	/**
	 * 查询试卷名称
	 * @return
	 * @throws Exception
	 */
	public String getTestpaperNameAll() throws Exception{
		 List<String> examNameList=testpaperService.getTestpaperNameAll();
	    getRequest().getSession().setAttribute("examNameList",examNameList);
		setForwardView(ADD1_JSP);
		return SUCCESS;
	}
	
	/**
	 * 查询课程名称
	 * @return
	 * @throws Exception
	 */
	public String getcourseNameAll() throws Exception{
		List<String> courseNameList=courseService.getCourseNameAll();
	    getRequest().getSession().setAttribute("courseNameList",courseNameList);
	    List<String> topicBankNameList=topicBankService.gettopicBankNameAll();
	    getRequest().getSession().setAttribute("topicBankNameList",topicBankNameList);
		setForwardView(ADD2_JSP);
		return SUCCESS;
	}
	
	@Override
	public Object getModel() {
		
		return testpaper;
	}

	public Result<Testpaper> getPageResult() {
		return pageResult;
	}

	public void setPageResult(Result<Testpaper> pageResult) {
		this.pageResult = pageResult;
	}

	public Testpaper getTestpaper() {
		return testpaper;
	}

	public void setTestpaper(Testpaper testpaper) {
		this.testpaper = testpaper;
	}

	public Result<Topic> getPageResult1() {
		return pageResult1;
	}

	public void setPageResult1(Result<Topic> pageResult1) {
		this.pageResult1 = pageResult1;
	}

	public Result<Topic> getResult() {
		return result;
	}

	public void setResult(Result<Topic> result) {
		this.result = result;
	}

	public Result<ChoiceTopic> getPageResult2() {
		return pageResult2;
	}

	public void setPageResult2(Result<ChoiceTopic> pageResult2) {
		this.pageResult2 = pageResult2;
	}

	public Result<FillTopic> getPageResult3() {
		return pageResult3;
	}

	public void setPageResult3(Result<FillTopic> pageResult3) {
		this.pageResult3 = pageResult3;
	}

	public Result<ChoiceTopic> getResult1() {
		return result1;
	}

	public void setResult1(Result<ChoiceTopic> result1) {
		this.result1 = result1;
	}

	public Result<FillTopic> getResult2() {
		return result2;
	}

	public void setResult2(Result<FillTopic> result2) {
		this.result2 = result2;
	}

	public ChoiceTopic getChoiceTopic() {
		return choiceTopic;
	}

	public void setChoiceTopic(ChoiceTopic choiceTopic) {
		this.choiceTopic = choiceTopic;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public FillTopic getFillTopic() {
		return fillTopic;
	}

	public void setFillTopic(FillTopic fillTopic) {
		this.fillTopic = fillTopic;
	}

	public int getChoiceTopicNum() {
		return choiceTopicNum;
	}

	public void setChoiceTopicNum(int choiceTopicNum) {
		this.choiceTopicNum = choiceTopicNum;
	}

	public int getFillTopicNum() {
		return fillTopicNum;
	}

	public void setFillTopicNum(int fillTopicNum) {
		this.fillTopicNum = fillTopicNum;
	}

	public int getTopicNum() {
		return topicNum;
	}

	public void setTopicNum(int topicNum) {
		this.topicNum = topicNum;
	}


}

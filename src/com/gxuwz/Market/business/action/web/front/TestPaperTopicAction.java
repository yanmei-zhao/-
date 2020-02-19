package com.gxuwz.Market.business.action.web.front;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.entity.Examquestionanswer;
import com.gxuwz.Market.business.entity.FillTopic;
import com.gxuwz.Market.business.entity.TestPaperTopic;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.Market.business.service.IChoiceTopicService;
import com.gxuwz.Market.business.service.IFillTopicService;
import com.gxuwz.Market.business.service.ITestPaperTopicService;
import com.gxuwz.Market.business.service.TestpaperService;
import com.gxuwz.Market.business.service.TopicService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("serial")
public class TestPaperTopicAction extends BaseAction implements Preparable, ModelDriven{
	protected static final String ADDTOPIC_JSP ="/WEB-INF/page/testpaper/brieftopic_add.jsp";
	protected static final String ADDCTOPIC_JSP ="/WEB-INF/page/testpaper/choice_add.jsp";
    protected static final String ADDFTOPIC_JSP ="/WEB-INF/page/testpaper/fill_add.jsp";
    protected static final String ADD3_JSP = "/WEB-INF/page/testpaper/question_add.jsp";
    protected static final String LIST_JSP = "/WEB-INF/page/testpaper/testPaper_list.jsp";
	protected final Log logger=LogFactory.getLog(getClass());
	
	private TestPaperTopic testPaperTopic;
	private ChoiceTopic choiceTopic;
	private Topic topic;
	private FillTopic fillTopic;
	private Testpaper testpaper;
	private Result<Testpaper> pageResult; //分页
	private Result<Topic> pageResult1; //分页
	private Result<ChoiceTopic> pageResult2; //分页
	private Result<FillTopic> pageResult3; //分页
	
	@Autowired
	private ITestPaperTopicService testPaperTopicService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private IChoiceTopicService choiceTopicService;
	@Autowired
	private IFillTopicService fillTopicService;
	@Autowired
	private TestpaperService testpaperService;
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		if(null == testPaperTopic){
			testPaperTopic = new TestPaperTopic();
			topic = new Topic();
			fillTopic = new FillTopic();
			choiceTopic = new ChoiceTopic();
			testpaper = new Testpaper();
		}
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
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
	 * 添加试题至试卷
	* @Title: add      
	* @return void    返回类型   
	* @throws
	 */
	public String add() throws Exception{
		int testpaperId =Integer.parseInt( getRequest().getParameter("testpaperId"));
		/*更新试卷基本信息*/
		testpaper.setTestpaperId(testpaperId);
		testpaper.setTestpaperName(getRequest().getParameter("testpaperName"));
		testpaper.setTotalScore(Integer.parseInt(getRequest().getParameter("totalscore")));
		testpaper.setPassScore(Integer.parseInt(getRequest().getParameter("passscore")));
		String creator = (String) getRequest().getSession().getAttribute("userName");
		testpaper.setCreator(creator);
		testpaperService.update(testpaper);
		/*先删除现有的试题与试卷的对应*/
		List<TestPaperTopic> list1 = testPaperTopicService.getAllTestpaperTopic(testpaperId);
		testPaperTopicService.deleteBatch(list1);
		/*添加试题至试卷*/
		List<TestPaperTopic> list = new ArrayList<TestPaperTopic>();
		String[] choiceTopicIdAll = getRequest().getParameterValues("choiceId");  //获取单选题id
		String[] fillTopicIdAll = getRequest().getParameterValues("fillId");  //获取填空题id
		String[] topicIdAll = getRequest().getParameterValues("topicId");	//获取简答题id
		String[] judgeIdAll = getRequest().getParameterValues("judgeId");  //获取判断题id
		String[] multipleIdAll = getRequest().getParameterValues("multipleId"); //获取多选题id
		String[] judgescore = getRequest().getParameterValues("judgescore");//获取多选题分数
		String[] multiplescore = getRequest().getParameterValues("multiplescore");//获取判断题分数
		String[] briefscore = getRequest().getParameterValues("briefscore");//获取简答题分数
		String[] fillscore = getRequest().getParameterValues("fillscore");//获取填空题分数
		String[] choicescore = getRequest().getParameterValues("choicescore");//获取单选题分数
		if(topicIdAll!=null){
			for(int i = 0;i<topicIdAll.length;i++){
				int topicId1 = Integer.parseInt(topicIdAll[i]);
				String type = "简答题";
				int score = Integer.parseInt(briefscore[i]);
				TestPaperTopic testPaperTopic = new TestPaperTopic(testpaperId,topicId1,null,null,null,null,type,score);
				list.add(testPaperTopic);
			}
		}
		if(fillTopicIdAll!=null){
			for(int i = 0;i<fillTopicIdAll.length;i++){
				int filltopicId1 = Integer.parseInt(fillTopicIdAll[i]);
				String type = "填空题";
				int score = Integer.parseInt(fillscore[i]);
				TestPaperTopic testPaperTopic = new TestPaperTopic(testpaperId,null,null,filltopicId1,null,null,type,score);
				list.add(testPaperTopic);
			}
		}
		if(choiceTopicIdAll!=null){
			for(int i = 0;i<choiceTopicIdAll.length;i++){
				int choicetopicId1 = Integer.parseInt(choiceTopicIdAll[i]);
				String type = "单选题";
				int score = Integer.parseInt(choicescore[i]);
				TestPaperTopic testPaperTopic = new TestPaperTopic(testpaperId,null,choicetopicId1,null,null,null,type,score);
				list.add(testPaperTopic);
			}
		}
		if(judgeIdAll!=null){
			for(int i = 0;i<judgeIdAll.length;i++){
				int judgetopicId1 = Integer.parseInt(judgeIdAll[i]);
				String type = "判断题";
				int score = Integer.parseInt(judgescore[i]);
				TestPaperTopic testPaperTopic = new TestPaperTopic(testpaperId,null,null,null,judgetopicId1,null,type,score);
				list.add(testPaperTopic);
			}
		}
		if(multipleIdAll!=null){
			for(int i = 0;i<multipleIdAll.length;i++){
				int multipletopicId1 = Integer.parseInt(multipleIdAll[i]);
				String type = "多选题";
				int score = Integer.parseInt(multiplescore[i]);
				TestPaperTopic testPaperTopic = new TestPaperTopic(testpaperId,null,null,null,null,multipletopicId1,type,score);
				list.add(testPaperTopic);
			}
		}
		testPaperTopicService.addBatch(list);
		return list();
	}
	
	public Result<Testpaper> getPageResult() {
		return pageResult;
	}
	public void setPageResult(Result<Testpaper> pageResult) {
		this.pageResult = pageResult;
	}
	
	public Result<Topic> getPageResult1() {
		return pageResult1;
	}
	public void setPageResult1(Result<Topic> pageResult1) {
		this.pageResult1 = pageResult1;
	}
	
	public TestPaperTopic getTestPaperTopic() {
		return testPaperTopic;
	}
	public void setTestPaperTopic(TestPaperTopic testPaperTopic) {
		this.testPaperTopic = testPaperTopic;
	}
	public Testpaper getTestpaper() {
		return testpaper;
	}
	public void setTestpaper(Testpaper testpaper) {
		this.testpaper = testpaper;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public ChoiceTopic getChoiceTopic() {
		return choiceTopic;
	}
	public void setChoiceTopic(ChoiceTopic choiceTopic) {
		this.choiceTopic = choiceTopic;
	}
	public FillTopic getFillTopic() {
		return fillTopic;
	}
	public void setFillTopic(FillTopic fillTopic) {
		this.fillTopic = fillTopic;
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
	
	/* 以下方法暂时未用*/
	/**
	 * 试卷列表点击添加选择试题后返回的选择题列表
	 *  @return
	 */
	public String openChoiceTopicList()throws Exception{
		logger.info("##选择题列表读取...");
//		int testpaperId = testpaper.getTestpaperId();
//		getRequest().getSession().setAttribute("testpaperId",testpaperId);
		pageResult2 = choiceTopicService.find(choiceTopic, getPage(), getRow());
		setForwardView(ADDCTOPIC_JSP);
		return SUCCESS;
	}
	
	/**
	 * 试卷列表点击添加填空题后返回的填空题列表
	 *  @return
	 */
	public String openFillTopicList()throws Exception{
		logger.info("##选择题列表读取...");
//		int testpaperId = testpaper.getTestpaperId();
//		getRequest().getSession().setAttribute("testpaperId",testpaperId);
		pageResult3 = fillTopicService.find(fillTopic, getPage(), getRow());
		setForwardView(ADDFTOPIC_JSP);
		return SUCCESS;
	}
	
	/**
	 * 试卷列表点击添加简答试题后返回的简答题列表
	 *  @return
	 */
	public String openTopicList()throws Exception{
		logger.info("##简答题列表读取...");
//		int testpaperId = testpaper.getTestpaperId();
//		getRequest().getSession().setAttribute("testpaperId",testpaperId);
		pageResult1 = topicService.find(topic, getPage(), getRow());
		setForwardView(ADDTOPIC_JSP);
		return SUCCESS;
	}
	
//	/**
//	 * 添加填空题
//	* @Title: add      
//	* @return void    返回类型   
//	* @throws
//	 */
//	public String addF() throws Exception{
//		List<TestPaperTopic> list = new ArrayList<TestPaperTopic>();
//		int testpaperId = (int) getRequest().getSession().getAttribute("testpaperId");
//		String[] fillTopicIdAll = getRequest().getParameterValues("checkbox");
//		for(int i = 0;i<fillTopicIdAll.length;i++){
//			int filltopicId1 = Integer.parseInt(fillTopicIdAll[i]);
//			String type = "填空题";
//			TestPaperTopic testPaperTopic = new TestPaperTopic(testpaperId,null,null,filltopicId1,type);
//			list.add(testPaperTopic);
//		}
//		testPaperTopicService.addBatch(list);
//		return openFillTopicList();
//	}
//	/**
//	 * 添加选择题
//	* @Title: add      
//	* @return void    返回类型   
//	* @throws
//	 */
//	public String addC() throws Exception{
//		List<TestPaperTopic> list = new ArrayList<TestPaperTopic>();
//		int testpaperId = (int) getRequest().getSession().getAttribute("testpaperId");
//		String[] choiceTopicIdAll = getRequest().getParameterValues("checkbox");
//		for(int i = 0;i<choiceTopicIdAll.length;i++){
//			int choicetopicId1 = Integer.parseInt(choiceTopicIdAll[i]);
//			String type = "单选题";
//			TestPaperTopic testPaperTopic = new TestPaperTopic(testpaperId,null,choicetopicId1,null,type);
//			list.add(testPaperTopic);
//		}
//		testPaperTopicService.addBatch(list);
//		return openChoiceTopicList();
//	}
}

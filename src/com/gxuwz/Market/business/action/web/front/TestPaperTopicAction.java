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
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.Market.business.service.IChoiceTopicService;
import com.gxuwz.Market.business.service.IFillTopicService;
import com.gxuwz.Market.business.service.ITestTopicService;
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
	protected final Log logger=LogFactory.getLog(getClass());
	
	private TestPaperTopic test;
	private ChoiceTopic choiceTopic;
	private Topic topic;
	private FillTopic fillTopic;
	private Result<Topic> pageResult1; //分页
	private Result<ChoiceTopic> pageResult2; //分页
	private Result<FillTopic> pageResult3; //分页
	
	@Autowired
	private ITestTopicService testPaperTopicService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private IChoiceTopicService choiceTopicService;
	@Autowired
	private IFillTopicService fillTopicService;
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		if(null == test){
			test = new TestPaperTopic();
			topic = new Topic();
			fillTopic = new FillTopic();
			choiceTopic = new ChoiceTopic();
		}
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
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
	
	/**
	 * 添加简答题
	* @Title: add      
	* @return void    返回类型   
	* @throws
	 */
	public String add() throws Exception{
		List<TestPaperTopic> list = new ArrayList<TestPaperTopic>();
		int testpaperId = (int) getRequest().getSession().getAttribute("testpaperId");
		String[] topicIdAll = getRequest().getParameterValues("checkbox");
		for(int i = 0;i<topicIdAll.length;i++){
			int topicId1 = Integer.parseInt(topicIdAll[i]);
			String type = "简答题";
			TestPaperTopic testPaperTopic = new TestPaperTopic(testpaperId,topicId1,null,null,type);
			list.add(testPaperTopic);
		}
		testPaperTopicService.addBatch(list);
		return openTopicList();

	}
	
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
	 * 添加选择题
	* @Title: add      
	* @return void    返回类型   
	* @throws
	 */
	public String addC() throws Exception{
		List<TestPaperTopic> list = new ArrayList<TestPaperTopic>();
		int testpaperId = (int) getRequest().getSession().getAttribute("testpaperId");
		String[] choiceTopicIdAll = getRequest().getParameterValues("checkbox");
		for(int i = 0;i<choiceTopicIdAll.length;i++){
			int choicetopicId1 = Integer.parseInt(choiceTopicIdAll[i]);
			String type = "单选题";
			TestPaperTopic testPaperTopic = new TestPaperTopic(testpaperId,null,choicetopicId1,null,type);
			list.add(testPaperTopic);
		}
		testPaperTopicService.addBatch(list);
		return openChoiceTopicList();
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
	 * 添加填空题
	* @Title: add      
	* @return void    返回类型   
	* @throws
	 */
	public String addF() throws Exception{
		List<TestPaperTopic> list = new ArrayList<TestPaperTopic>();
		int testpaperId = (int) getRequest().getSession().getAttribute("testpaperId");
		String[] fillTopicIdAll = getRequest().getParameterValues("checkbox");
		for(int i = 0;i<fillTopicIdAll.length;i++){
			int filltopicId1 = Integer.parseInt(fillTopicIdAll[i]);
			String type = "填空题";
			TestPaperTopic testPaperTopic = new TestPaperTopic(testpaperId,null,null,filltopicId1,type);
			list.add(testPaperTopic);
		}
		testPaperTopicService.addBatch(list);
		return openFillTopicList();
	}
	
	public Result<Topic> getPageResult1() {
		return pageResult1;
	}
	public void setPageResult1(Result<Topic> pageResult1) {
		this.pageResult1 = pageResult1;
	}
	public TestPaperTopic getTest() {
		return test;
	}
	public void setTest(TestPaperTopic test) {
		this.test = test;
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
//	public String addC() throws Exception{
//	int testpaperId=(int) getRequest().getSession().getAttribute("testpaperId");
//	HttpServletRequest request = ServletActionContext.getRequest();
//	int choicetopicId = Integer.parseInt(request.getParameter("id"));
//	test.setChoicetopicId(choicetopicId);
//	test.setTestpaperId(testpaperId);
//	testPaperTopicService.add(test);
//	return openChoiceTopicList();
//}

}

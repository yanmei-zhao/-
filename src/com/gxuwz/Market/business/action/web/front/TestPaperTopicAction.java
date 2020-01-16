package com.gxuwz.Market.business.action.web.front;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.TestPaperTopic;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.Market.business.service.ITestTopicService;
import com.gxuwz.Market.business.service.TopicService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("serial")
public class TestPaperTopicAction extends BaseAction implements Preparable, ModelDriven{
	protected static final String LIST_JSP = "/WEB-INF/page/topic/topic_to_paper.jsp";
	protected static final String ADDTOPIC_JSP ="/WEB-INF/page/topic/topic_to_paper.jsp";
	protected final Log logger=LogFactory.getLog(getClass());
	
	private TestPaperTopic test;
	private Topic topic;
	private Result<Topic> pageResult1; //分页
	
	@Autowired
	private ITestTopicService testPaperTopicService;
	@Autowired
	private TopicService topicService;
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		if(null == test){
			test = new TestPaperTopic();
			topic = new Topic();
		}
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 试卷列表点击添加试题后返回的简答题列表
	 *  @return
	 */
	public String openTopicList()throws Exception{
		logger.info("##试题列表读取...");
//		int testpaperId = testpaper.getTestpaperId();
//		getRequest().getSession().setAttribute("testpaperId",testpaperId);
		pageResult1 = topicService.find(topic, getPage(), getRow());
		setForwardView(ADDTOPIC_JSP);
		return SUCCESS;
	}
	
	/**
	 * 添加
	* @Title: add      
	* @return void    返回类型   
	* @throws
	 */
	public String add() throws Exception{
		int testpaperId=(int) getRequest().getSession().getAttribute("testpaperId");
		HttpServletRequest request = ServletActionContext.getRequest();
		int topicId = Integer.parseInt(request.getParameter("id"));
		test.setTopicId(topicId);
		test.setTestpaperId(testpaperId);
		testPaperTopicService.add(test);
		return openTopicList();
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


	

}

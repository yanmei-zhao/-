package com.gxuwz.Market.business.action.web.front;




import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.Topic;

import com.gxuwz.Market.business.service.IStudentService;
import com.gxuwz.Market.business.service.TopicService;
import com.gxuwz.Market.business.service.TopicServiceImpl;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * <p>Title: 类名：角色权限-控制器--实现</p>
 * <p>Description:控制器/n</p>
 * @author:	卢善坚，汪嘉惠
 * @date:2015.08.11
 */
public class TopicAction extends BaseAction implements Preparable, ModelDriven{
	
	protected static final String LIST_JSP = "/WEB-INF/page/topic/topic_list.jsp";
	protected static final String ADD_JSP = "/WEB-INF/page/topic/topic_add.jsp";
	protected static final String EDIT_JSP = "/WEB-INF/page/topic/topic_edit.jsp";
	protected static final String VIEW_JSP = "/WEB-INF/page/topic/topic_preview.jsp";
	protected static final String ADDTOPIC_JSP = "/WEB-INF/page/topic/topic_to_paper.jsp";
	
	protected final Log logger=LogFactory.getLog(getClass());
	
	private Result<Topic> pageResult; //分页
	private Topic topic;
	public Log getLogger() {
		return logger;
	}

	@Autowired
	private TopicService topicService;
	
	
	@Override
	public void prepare() throws Exception {
		if(null == topic){
			topic = new Topic();
		}
		
	}

	/**
	 * 列表
	 * @return
	 * @throws Exception
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.8.10
	 */
	public String list()throws Exception{
		logger.info("##ysRole列表读取...");
		pageResult = topicService.find(topic, getPage(), getRow());
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	
	/**
	 * 试卷点击添加试题后的查询
	 */
	public String listtopic()throws Exception{
		logger.info("##试题列表读取...");
		pageResult = topicService.find(topic, getPage(), getRow());
		setForwardView(ADDTOPIC_JSP);
		return SUCCESS;
	}
	/**
	 * 添加权限
	 * @return
	 * @throws Exception
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.8.10
	 */
	public String add() throws Exception{
		topicService.add(topic);
		topic = new Topic();
		return list();
	}
	/**
	 * 保存修改信息
	 * @return
	 * @throws Exception
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.8.10
	 */
	public String update() throws Exception{
		topicService.update(topic);
		topic.setTopicId(null);
		topic.setTopicName(null);
		topic.setTopicBankName(null);
		return list();
	}
	/**
	 * 删除权限
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		topicService.delete(topic.getTopicId());
		topic.setTopicName(null);
		topic.setTopicId(null);
		return list();
	}
	/**
	 * 删除课题
	 * @return
	 * @throws Exception
	 */
	public String delete1() throws Exception {
		
		topicService.delete(topic.getTopicId());
		setForwardView(LIST_JSP);
		return SUCCESS;

	}
	
	
	/**
	 * 页面跳转
	 * @return
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.8.10
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
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.8.10
	 */
	public String openEdit(){
		topic = topicService.findById(topic.getTopicId());
		forwardView = EDIT_JSP;
		return SUCCESS;
	}
	/**
	 * 跳转到预览页面
	 * @return
	 */
	public String openView(){
		topic = topicService.findById(topic.getTopicId());
		forwardView = VIEW_JSP;
		return SUCCESS;
	}
	@Override
	public Object getModel() {
		
		return topic;
	}


	public Result<Topic> getPageResult() {
		return pageResult;
	}

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public void setPageResult(Result<Topic> pageResult) {
		this.pageResult = pageResult;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	


}

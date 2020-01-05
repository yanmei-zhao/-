package com.gxuwz.Market.business.action.web.front;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.FillTopic;

import com.gxuwz.Market.business.service.IFillTopicService;
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
	public Log getLogger() {
		return logger;
	}

	@Autowired
	private IFillTopicService fillTopicService;
	
	@Override
	public void prepare() throws Exception {
		if(null == fillTopic){
			fillTopic = new FillTopic();
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
		
		 List<String> TopicBankNameList=fillTopicService.getTopicBankNameAll();
		getRequest().getSession().setAttribute("TopicBankNameList",TopicBankNameList);
		
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
	
	@Override
	public Object getModel() {
		return fillTopic;
	}


	public Result<FillTopic> getPageResult() {
		return pageResult;
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


}

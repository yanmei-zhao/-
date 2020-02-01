package com.gxuwz.Market.business.action.web.front;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.service.IChoiceTopicService;
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
	public Log getLogger() {
		return logger;
	}
	@Autowired
	private IChoiceTopicService choiceTopicService ;
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		if(null == choiceTopic){
			choiceTopic = new ChoiceTopic();
		}
	}

	/**
	 * 获取选择题列表
	 * *  @return
	 */
	public String list()throws Exception{
		logger.info("##topic列表读取...");
		pageResult = choiceTopicService.find(choiceTopic, getPage(), getRow());
		
		 List<String> TopicBankNameList=choiceTopicService.getTopicBankNameAll();
		getRequest().getSession().setAttribute("TopicBankNameList",TopicBankNameList);
		
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
	 * 添加试题
	 *  @return
	 */
	public String add() throws Exception{
		System.out.println("choiceTopic.getCreator()=="+choiceTopic.getCreator());
		System.out.println("choiceTopic.getDifficulty()=="+choiceTopic.getDifficulty());
		System.out.println("choiceTopic.getKnowledge()=="+choiceTopic.getKnowledge());
		System.out.println("choiceTopic.getAnswer()=="+choiceTopic.getAnswer());
		System.out.println("choiceTopic.getDescription()=="+choiceTopic.getDescription());
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
		System.out.println("choiceTopic.getId()=="+choiceTopic.getId());
		choiceTopicService.delete(choiceTopic.getId());
		choiceTopic.setDescription(null);
		choiceTopic.setId(null);
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
	
}

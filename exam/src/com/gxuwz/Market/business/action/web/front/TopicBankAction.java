package com.gxuwz.Market.business.action.web.front;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.Course;
import com.gxuwz.Market.business.entity.TopicBank;
import com.gxuwz.Market.business.service.*;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import net.sf.json.JSONArray;

/**
 * 
 *<p>Title:TopicBankAction</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2019年1月21日下午1:35:23
 */
public class TopicBankAction extends BaseAction implements Preparable, ModelDriven{

	protected static final String LIST_JSP = "/WEB-INF/page/topicBank/topicBank_list.jsp";
	protected static final String ADD_JSP = "/WEB-INF/page/topicBank/topicBank_add.jsp";
	protected static final String EDIT_JSP = "/WEB-INF/page/topicBank/topicBank_edit.jsp";
	protected static final String ADD1_JSP = "/WEB-INF/page/topic/topic_add.jsp";
	protected static final String ADD2_JSP = "/WEB-INF/page/testpaper/testPaper_add_quickly.jsp";
	protected final Log logger=LogFactory.getLog(getClass());
	
	private Result<TopicBank> pageResult; //分页
	private TopicBank topicBank;
	@Autowired
	private ITopicBankService topicBankService;
	
	@Override
	public void prepare() throws Exception {
		if(null == topicBank){
			topicBank = new TopicBank();
		}
	}

	/**
	 * 题库列表
	 * @return
	 * @throws Exception
	 */
	public String list()throws Exception{
		logger.info("##topicBank列表读取...");
		pageResult = topicBankService.find(topicBank, getPage(), getRow());
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	/**
	 * 添加题库
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		
		topicBankService.add(topicBank);
		topicBank.setTopicBankName(null);
		return list();
	}
	/**
	 * 保存修改信息
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		topicBankService.update(topicBank);
		topicBank.setTopicBankName(null);
		return list();
	}
	/**
	 * 删除题库
	 * @return
	 * @throws Exception
	 */
	
	public String delete() throws Exception{
		topicBankService.delete(topicBank.getTopicBankId());
		topicBank.setTopicBankName(null);
		return list();
	}
	/**
	 * 页面跳转
	 * @return
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
	 */
	public String openEdit(){
		topicBank = topicBankService.findById(topicBank.getTopicBankId());
		forwardView = EDIT_JSP;
		return SUCCESS;
	}
	/**
	 * 查询所有题库名称
	 * @return
	 * @throws Exception
	 */
	public String gettopicBankNameAll() throws Exception{
		 List<String> topicBankNameList=topicBankService.gettopicBankNameAll();
	    getRequest().getSession().setAttribute("topicBankNameList",topicBankNameList);
		setForwardView(ADD1_JSP);
		return SUCCESS;
	}
	/**
	 * 查询题库名称
	 * @return
	 * @throws Exception
	 */
	/*public String gettopicBankName() throws Exception{
		 List<String> topicBankNameList=topicBankService.gettopicBankNameAll();
	    getRequest().getSession().setAttribute("topicBankNameList",topicBankNameList);
		setForwardView(ADD1_JSP);
		return SUCCESS;
	}*/
	/**
	 *二级联动查询题库名称
	 * @param courseName 
	 * @return
	 * @throws Exception
	 */
	public String gettopicBankName() throws Exception{
		 List<String> topicBankNameList1=topicBankService.gettopicBankName();
		 getRequest().getSession().setAttribute("topicBankNameList1",topicBankNameList1);
		setForwardView(ADD2_JSP);
		return SUCCESS;
	}
	/*public String gettopicBankName(String courseName) throws Exception{
			HttpServletResponse response=ServletActionContext.getResponse();
				System.out.println("课程名为"+courseName);
				 response.setContentType("text/json"); 			// 回传内容设为json格式 2017.08.13 miki
		        	 response.setCharacterEncoding("UTF-8");	    设置字符集为'UTF-8'，不然从数据库取中文数据时显示到前端，会乱码
		         
		       		//根据一级菜单选中的Id，得到对应的二级列表
		        	 List<String> topicBankNameList1=topicBankService.gettopicBankName(courseName);
				
				//以jsonArray数据形式存入json中
				JSONArray topicBank=JSONArray.fromObject(topicBankNameList1);	
				
				
				 * response顾名思义就是服务器对浏览器的相应，PrintWriter它的实例就是向前台的JSP页面输出结果
				 
				PrintWriter out=response.getWriter();								
				out.print(topicBank.toString());
				out.flush();
				out.close();
			return null;
		}
	*/
	@Override
	public Object getModel() {
		
		return topicBank;
	}


	public Result<TopicBank> getPageResult() {
		return pageResult;
	}

	public void setPageResult(Result<TopicBank> pageResult) {
		this.pageResult = pageResult;
	}

	public TopicBank getTopicBank() {
		return topicBank;
	}

	public void setTopicBank(TopicBank topicBank) {
		this.topicBank = topicBank;
	}

}

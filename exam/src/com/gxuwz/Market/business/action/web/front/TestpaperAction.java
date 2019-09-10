package com.gxuwz.Market.business.action.web.front;


import java.util.List;






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
import com.gxuwz.Market.business.service.TestpaperService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 试卷控制器
* <p>Title: TestpaperAction</p>     
* @author 小胜  
* @date 下午12:56:37
 */
public class TestpaperAction extends BaseAction implements Preparable, ModelDriven{
	
	protected static final String LIST_JSP = "/WEB-INF/page/testpaper/testPaper_list.jsp";
	protected static final String ADD_JSP = "/WEB-INF/page/testpaper/testPaper_add.jsp";
	protected static final String ADD2_JSP = "/WEB-INF/page/testpaper/testPaper_add_quickly.jsp";
	protected static final String EDIT_JSP = "/WEB-INF/page/testpaper/testPaper_edit.jsp";
    protected static final String ADDTOPIC_JSP ="/WEB-INF/page/topic/Topic_topaper.jsp";
    protected static final String ADD1_JSP = "/WEB-INF/page/exam/exam_add.jsp";
    protected static final String VIEW_JSP = "/WEB-INF/page/testpaper/testPaper_view.jsp";
	protected final Log logger=LogFactory.getLog(getClass());
	
	private Result<Testpaper> pageResult; //分页
	private Testpaper testpaper;
	private Topic topic;
	@Autowired
	private TestpaperService testpaperService;
	
	@Override
	public void prepare() throws Exception {
		if(null == testpaper){
			testpaper = new Testpaper();
		}
		
	}

	/**
	 * 列表
	* @Title: list      
	* @return String    返回类型   
	* @throws
	 */
	public String list()throws Exception{
		logger.info("##ysRole列表读取...");
		pageResult = testpaperService.find(testpaper, getPage(), getRow());
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	/**
	 * 添加
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
	 * @throws Exception
	 */
	public String viewpaper() throws Exception{
		testpaper = testpaperService.findById(testpaper.getTestpaperId());
		
		getRequest().getSession().setAttribute("testpapername",testpaper.getTestpaperName());
		List<String> view=testpaperService.getAllTopicId(testpaper.getTestpaperId());
	   	 Gson gson = new Gson();
	   	  gson.toJson(view);
	   getRequest().getSession().setAttribute("view",view);
		setForwardView(VIEW_JSP);
		return SUCCESS;
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
	* @Title: Topaper      
	* @return String    返回类型   
	* @throws
	 */
	public String Topaper(){
		forwardView = ADDTOPIC_JSP;
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
		//System.out.println(sysRight.getRightId());
		testpaper = testpaperService.findById(testpaper.getTestpaperId());
		//System.out.println("9999999999999999");
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

	


}

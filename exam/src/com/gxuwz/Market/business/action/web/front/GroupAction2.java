package com.gxuwz.Market.business.action.web.front;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.Group;
import com.gxuwz.Market.business.service.IGroupService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 
 *<p>Title:ClassAction</p>
 *<p>Description:</p>
 * @author zhaoyanmei
 * @date 2019年1月26日下午11:40:10
 */
public class GroupAction2 extends BaseAction implements Preparable, ModelDriven{

	protected static final String LIST_JSP = "/WEB-INF/page/user/class_list.jsp";
	protected static final String ADD_JSP = "/WEB-INF/page/user/class_add.jsp";
	protected static final String EDIT_JSP = "/WEB-INF/page/user/class_edit.jsp";
	protected static final String LIST1_JSP = "/WEB-INF/page/user/student_list.jsp";
	protected static final String ADD1_JSP = "/WEB-INF/page/user/student_add.jsp";
	
	protected final Log logger=LogFactory.getLog(getClass());
	
	private Result<Group> pageResult; //分页
	private Group group;
	@Autowired
	private IGroupService groupService;
	
	@Override
	public void prepare() throws Exception {
		if(null == group){
			group = new Group();
		}
	}
	/**
	 * 班级列表
	 * @return
	 * @throws Exception
	 */
	public String list()throws Exception{
		logger.info("##group列表读取...");
		pageResult = groupService.find(group, getPage(), getRow());
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	
	/**
	 * 添加班级
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		
		groupService.add(group);
		group.setClassName(null);
		return list();
	}
	/**
	 * 保存修改信息
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		groupService.update(group);
		group.setClassName(null);
		return list();
	}
	/**
	 * 删除班级
	 * @return
	 * @throws Exception
	 */
	
	public String delete() throws Exception{
		groupService.delete(group.getClassId());
		group.setClassName(null);
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
		group = groupService.findById(group.getClassId());
		forwardView = EDIT_JSP;
		return SUCCESS;
	}
	
	/**
	 * 查询班级名称
	 * @return
	 * @throws Exception
	 */
	public String getClassNameAll() throws Exception{
		 List<String> classNameList=groupService.getClassNameAll();
	    getRequest().getSession().setAttribute("classNameList",classNameList);
		setForwardView(ADD1_JSP);
		return SUCCESS;
	}
	@Override
	public Object getModel() {
		
		return group;
	}


	public Result<Group> getPageResult() {
		return pageResult;
	}

	public void setPageResult(Result<Group> pageResult) {
		this.pageResult = pageResult;
	}

	public Group getGroup() {
		return group;
	}

	public void setClass(Group group) {
		this.group = group;
	}

}

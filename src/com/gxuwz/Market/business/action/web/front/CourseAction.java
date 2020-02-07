package com.gxuwz.Market.business.action.web.front;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.Course;
import com.gxuwz.Market.business.entity.TestPaperTopic;
import com.gxuwz.Market.business.service.ICourseService;
import com.gxuwz.Market.business.service.ITopicBankService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
/**
 * 
 *<p>Title:CourseAction</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2019年1月26日下午10:24:46
 */
public class CourseAction extends BaseAction implements Preparable, ModelDriven{
	
	protected static final String LIST_JSP = "/WEB-INF/page/course/course_list.jsp";
	protected static final String ADD_JSP = "/WEB-INF/page/course/course_add.jsp";
	protected static final String EDIT_JSP = "/WEB-INF/page/course/course_edit.jsp";
	protected static final String ADD1_JSP = "/WEB-INF/page/testpaper/testPaper_add_quickly.jsp";
	
	protected final Log logger=LogFactory.getLog(getClass());
	
	private Result<Course> pageResult; //分页
	private Course course;
	@Autowired
	private ICourseService courseService;
	
	@Override
	public void prepare() throws Exception {
		if(null == course){
			course = new Course();
		}
	}

	/**
	 * 课程列表
	 * @return
	 * @throws Exception
	 */
	public String list()throws Exception{
		logger.info("##course列表读取...");
		pageResult = courseService.find(course, getPage(), getRow());
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	
	/**
	 * 添加课程
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		courseService.add(course);
		course.setCourseName(null);
		return list();
	}
	
	/**
	 * 保存修改信息
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		courseService.update(course);
		course.setCourseName(null);
		return list();
	}
	
	/**
	 * 删除课程
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		courseService.delete(course.getCourseId());
		return list();
	}
	
	/**
	 * 删除课程
	 * @return
	 * @throws Exception
	 */
	public String deleteList() throws Exception{
		List<Course> list = new ArrayList<Course>();
		String[] courseIdAll = getRequest().getParameterValues("checkbox");
		for(int i=0;i<courseIdAll.length;i++){
			int courseId = Integer.parseInt(courseIdAll[i]);
			Course course = new Course(courseId);
			list.add(course);
		}
		courseService.deleteBatch(list);
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
		course = courseService.findById(course.getCourseId());
		forwardView = EDIT_JSP;
		return SUCCESS;
	}
	
	@Override
	public Object getModel() {
		
		return course;
	}

	public Result<Course> getPageResult() {
		return pageResult;
	}

	public void setPageResult(Result<Course> pageResult) {
		this.pageResult = pageResult;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

//	/**
//	 * 查询课程名称
//	 * @return
//	 * @throws Exception
//	 */
//	public String getcourseNameAll() throws Exception{
//		List<String> courseNameList=courseService.getCourseNameAll();
//	    getRequest().getSession().setAttribute("courseNameList",courseNameList);
//	    List<String> topicBankNameList=topicBankService.gettopicBankNameAll();
//	    getRequest().getSession().setAttribute("topicBankNameList",topicBankNameList);
//		setForwardView(ADD1_JSP);
//		return SUCCESS;
//	}
	
}

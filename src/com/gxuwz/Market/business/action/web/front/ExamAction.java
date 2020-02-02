package com.gxuwz.Market.business.action.web.front;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.Market.business.entity.FillTopic;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.Market.business.service.ExamService;
import com.gxuwz.Market.business.service.TestpaperService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 *<p>Title:ExamAction</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年1月10日下午3:10:49
 */
public class ExamAction extends BaseAction implements Preparable, ModelDriven{
	
	protected static final String LIST_JSP = "/WEB-INF/page/exam/exam_list.jsp";
	protected static final String LIST1_JSP = "/WEB-INF/page/student/exam_list.jsp";
	protected static final String ADD_JSP = "/WEB-INF/page/exam/exam_add.jsp";
	protected static final String EDIT_JSP = "/WEB-INF/page/exam/exam_edit.jsp";
	protected static final String VIEW1_JSP = "/WEB-INF/page/student/test_view.jsp";
	protected static final String VIEW2_JSP = "/WEB-INF/page/testpaper/testPaper_view.jsp";
	
	protected final Log logger=LogFactory.getLog(getClass());
	
	private Result<Exam> pageResult; //分页
	private Result<Topic> result; //分页
	private Result<ChoiceTopic> result1; //试卷预览（选择题）
	private Result<FillTopic> result2; //试卷预览（选择题）
	private Exam exam;
	private Testpaper testpaper;
	@Autowired
	private ExamService examService;
	@Autowired
	private TestpaperService testpaperService;
	@Override
	public void prepare() throws Exception {
		if(null == exam){
			exam = new Exam();
			testpaper = new Testpaper();
		}
	}

	/**
	 * 考试信息列表
	 * @return
	 * @author zym
	 * 
	 */
	public String list()throws Exception{
		logger.info("##ysRole列表读取...");
		 List<String> examNameList=examService.getTestpaperNameAll();
		getRequest().getSession().setAttribute("examNameList",examNameList);
		int userType = (int)getRequest().getSession().getAttribute("userType");
		if(userType==1){
			pageResult = examService.findByclassName(exam, getPage(), getRow());
			setForwardView(LIST1_JSP);
			return SUCCESS;
		}else{
			pageResult = examService.find(exam, getPage(), getRow());
			setForwardView(LIST_JSP);
			return SUCCESS;
		}
	}
	
	/**
	 * （教师端）考试列表预览试卷
	 */
	public String openViewTestPaper() throws Exception{
		//获取试卷对应的试题
		logger.info("##topic试题读取...");
		exam = examService.findById(exam.getExamId());
		getRequest().getSession().setAttribute("exam",exam);
		testpaper = examService.findByTestpaperName(exam.getExamName());
		getRequest().getSession().setAttribute("testpaper",testpaper);
		result = testpaperService.getAllTopic(testpaper.getTestpaperId(), getPage(), getRow());
		result1 = testpaperService.getAllChoiceTopic(testpaper.getTestpaperId(), getPage(), getRow());
		result2 = testpaperService.getAllFillTopic(testpaper.getTestpaperId(), getPage(), getRow());
		setForwardView(VIEW2_JSP);
		return SUCCESS;
	}
	
	/**
	 * （学生端）开始考试界面
	 */
	public String openViewTest() throws Exception{
		//查询试卷信息
		exam = examService.findById(exam.getExamId());
		getRequest().getSession().setAttribute("exam",exam);
		testpaper = examService.findByTestpaperName(exam.getExamName());
		getRequest().getSession().setAttribute("testpaper",testpaper);
		//获取试卷对应的试题
		logger.info("##topic试题读取...");
		result = testpaperService.getAllTopic(testpaper.getTestpaperId(), getPage(), getRow());
		result1 = testpaperService.getAllChoiceTopic(testpaper.getTestpaperId(), getPage(), getRow());
		result2 = testpaperService.getAllFillTopic(testpaper.getTestpaperId(), getPage(), getRow());
		setForwardView(VIEW1_JSP);
		return SUCCESS;
	}
	
	/**
	 * 添加考试信息
	 * @throws Exception
	 * @author zym
	 * @date 
	 */
	public String add() throws Exception{
		testpaper = examService.findByTestpaperName(exam.getExamName());
		int testPaperId=testpaper.getTestpaperId();
		exam.setTestPaperId(testPaperId);
		System.out.println("getTestPaperId=="+exam.getTestPaperId());
		examService.add(exam);
		exam = new Exam();
		return list();
	}
	
	/**
	 * 保存修改信息
	 * @return
	 * @throws Exception
	 * @author zym
	 * @date 
	 */
	public String update() throws Exception{
		examService.update(exam);
		exam.setExamId(null);
		exam.setExamName(null);
		return list();
	}

	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		examService.delete(exam.getExamId());
		exam.setExamId(null);
		exam.setExamName(null);
		return list();
	}
	
	/**
	 * 页面跳转
	 * @return
	 * @author zym
	 * @date 
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
	 */
	public String openEdit(){
		exam = examService.findById(exam.getExamId());
		forwardView = EDIT_JSP;
		return SUCCESS;
	}
	
	@Override
	public Object getModel() {
		return exam;
	}


	public Result<Exam> getPageResult() {
		return pageResult;
	}

	public void setPageResult(Result<Exam> pageResult) {
		this.pageResult = pageResult;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Result<Topic> getResult() {
		return result;
	}

	public void setResult(Result<Topic> result) {
		this.result = result;
	}

	public Result<ChoiceTopic> getResult1() {
		return result1;
	}

	public void setResult1(Result<ChoiceTopic> result1) {
		this.result1 = result1;
	}

	public Result<FillTopic> getResult2() {
		return result2;
	}

	public void setResult2(Result<FillTopic> result2) {
		this.result2 = result2;
	}

}

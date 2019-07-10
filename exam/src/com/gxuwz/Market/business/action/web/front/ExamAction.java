package com.gxuwz.Market.business.action.web.front;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.Market.business.service.ExamService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 考试信息创建
 * @author:	zym
 */
public class ExamAction extends BaseAction implements Preparable, ModelDriven{
	
	protected static final String LIST_JSP = "/WEB-INF/page/exam/exam_list.jsp";
	protected static final String ADD_JSP = "/WEB-INF/page/exam/exam_add.jsp";
	protected static final String EDIT_JSP = "/WEB-INF/page/exam/exam_edit.jsp";

	protected final Log logger=LogFactory.getLog(getClass());
	
	private Result<Exam> pageResult; //分页
	private Exam exam;
	@Autowired
	private ExamService examService;
	
	@Override
	public void prepare() throws Exception {
		if(null == exam){
			exam = new Exam();
		}
	}

	/**
	 * 考试信息列表
	 * @return
	 * 
	 * @author zym
	 * 
	 */
	public String list()throws Exception{
		logger.info("##ysRole列表读取...");
		pageResult = examService.find(exam, getPage(), getRow());
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	
	/**
	 * 添加考试信息
	 * @throws Exception
	 * @author zym
	 * @date 
	 */
	public String add() throws Exception{
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

	


}

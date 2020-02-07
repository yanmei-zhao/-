package com.gxuwz.Market.business.action.web.front;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.Market.business.service.IStudentExamScoreService;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("serial")
public class StatisticsAction  extends BaseAction implements Preparable, ModelDriven{
	protected static final String VIEW_JSP = "/WEB-INF/page/statistics/examination_analysis.jsp";
	protected static final String VIEW1_JSP = "/WEB-INF/page/statistics/examination_analysis_result.jsp";
	protected final Log logger=LogFactory.getLog(getClass());
	private Exam exam;
	@Autowired
	private IStudentExamScoreService studentExamScoreService;
	
	public Log getLogger() {
		return logger;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		if(exam==null){
			exam = new Exam();
		}
	}
	
	/**
	 * 打开考试统计页面
	 * @return
	 * @throws Exception
	 */
	public String openAnalyze()throws Exception{
		setForwardView(VIEW_JSP);
		return SUCCESS;
		}

	/**
	 * 查询考试情况（考试分析）
	 * @return
	 */
	public String getScoreSituation(){
		String testpaperName = exam.getExamName();
		System.out.println("testpaperName=="+testpaperName);
		getRequest().getSession().setAttribute("examName",testpaperName);
		int maxScore = studentExamScoreService.getMaxScore(testpaperName);
		int minScore = studentExamScoreService.getMinScore(testpaperName);
		int avgScore = studentExamScoreService.getAvgScore(testpaperName);
		getRequest().getSession().setAttribute("maxScore",maxScore);
		getRequest().getSession().setAttribute("minScore",minScore);
		getRequest().getSession().setAttribute("avgScore",avgScore);
		setForwardView(VIEW1_JSP);
		return SUCCESS;
	}
	
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
}

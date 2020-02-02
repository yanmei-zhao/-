package com.gxuwz.Market.business.action.web.front;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.Market.business.entity.Examquestionanswer;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.Market.business.service.ExamService;
import com.gxuwz.Market.business.service.IExamQuestionAnswerService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 
 *<p>Title:ExamquestionanswerAction</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年1月30日下午12:18:05
 */
@SuppressWarnings("serial")
public class ExamQuestionAnswerAction  extends BaseAction implements Preparable, ModelDriven{
	
	protected static final String LIST_JSP = "/WEB-INF/page/exam/exam_list.jsp";
	protected static final String LIST1_JSP = "/WEB-INF/page/student/exam_list.jsp";
	protected static final String INDEX_JSP = "/WEB-INF/page/index.jsp";//登录后中心页面
	
	private Examquestionanswer examquestionanswer;
	private Result<Exam> pageResult; //分页
	private Exam exam;
	int choiceScore = 0;
	int fillScore =0; 
	int topicScore =0;
	int totalScore =0;
	
	protected final Log logger=LogFactory.getLog(getClass());
	
	@Autowired
	private IExamQuestionAnswerService examQuestionAnswerService;
	@Autowired
	private ExamService examService;
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		if(null == exam){
			exam = new Exam();
		}
	}

	/**
	 * 学生交卷（提交）&&客观题自动评分
	 * @return
	 * @throws Exception
	 */
	public String putAnswer()throws Exception{
		List<Examquestionanswer> list = new ArrayList<Examquestionanswer>();
		//交卷插入数据
		int studentId1 = Integer.parseInt((String) getRequest().getSession().getAttribute("studentId"));
		String[] topicIdAll = getRequest().getParameterValues("topicId");  //获取试题id
		String[] answerAll = new String [topicIdAll.length];  //获取学生试题答案
		for(int j=0;j<topicIdAll.length;j++){
			String[] answer = getRequest().getParameterValues("answer_"+topicIdAll[j]);
		    answerAll[j]=answer[0];
		}
		for(int i=0;i<topicIdAll.length;i++){
			int studentId =  studentId1 ;
			String answer = answerAll[i];
			int topicId = Integer.parseInt(topicIdAll[i]);
			int examId = exam.getExamId();
			Examquestionanswer questionAnswer=new Examquestionanswer(answer,topicId,studentId,examId);
			list.add(questionAnswer);
		}
		examQuestionAnswerService.addBatch(list);
		
		
		
		
		//查询各题型分值
		Testpaper test = examQuestionAnswerService.getAllScore(exam.getExamId());
		int scorePerChoice = test.getChoicePerScore();
		int scorePerFill = test.getFillPerScore();
		int scorePerTopic = test.getTopicPerScore();
		//自动评卷
		for(int k=0;k<topicIdAll.length;k++){
			int topicId=Integer.parseInt(topicIdAll[k]);
			List<String> answerAll1 = (List<String>)examQuestionAnswerService.getAllAnswer(studentId1, topicId);
			Object list1 =  answerAll1.get(0);
			Object[] list2 = (Object[] )list1;
//			String answer3 = String.valueOf(list2[0]);//正确答案
//			String answer4 = String.valueOf(list2[1]);//题型
			if(list2[1].equals("单选题")&&list2[0].equals(answerAll[k])){
				choiceScore += scorePerChoice;
	        }
			else if(list2[1].equals("填空题")&&list2[0].equals(answerAll[k])){
				fillScore += scorePerFill;
	        }
			else if(list2[1].equals("简答题")&&list2[0].equals(answerAll[k])){
				topicScore += scorePerTopic;
	        }
		}
		totalScore = choiceScore+fillScore+topicScore;
		return openIndex();
	}

	/**
	 * 登录-首页跳转
	 * @return
	 */
	public String openIndex(){
		forwardView = INDEX_JSP;
		return SUCCESS;
	}
	
	public Examquestionanswer getExamquestionanswer() {
		return examquestionanswer;
	}

	public void setExamquestionanswer(Examquestionanswer examquestionanswer) {
		this.examquestionanswer = examquestionanswer;
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

	public IExamQuestionAnswerService getExamQuestionAnswerService() {
		return examQuestionAnswerService;
	}

	public void setExamQuestionAnswerService(IExamQuestionAnswerService examQuestionAnswerService) {
		this.examQuestionAnswerService = examQuestionAnswerService;
	}

	public ExamService getExamService() {
		return examService;
	}

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	
	public Log getLogger() {
		return logger;
	}

	public int getChoiceScore() {
		return choiceScore;
	}

	public void setChoiceScore(int choiceScore) {
		this.choiceScore = choiceScore;
	}

	public int getFillScore() {
		return fillScore;
	}

	public void setFillScore(int fillScore) {
		this.fillScore = fillScore;
	}

	public int getTopicScore() {
		return topicScore;
	}

	public void setTopicScore(int topicScore) {
		this.topicScore = topicScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	
}

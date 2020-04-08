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

import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.entity.CorrectRate;
import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.Market.business.entity.Examquestionanswer;
import com.gxuwz.Market.business.entity.FillTopic;
import com.gxuwz.Market.business.entity.JudgeTopic;
import com.gxuwz.Market.business.entity.MultipleTopic;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.Market.business.entity.Studentexamscore;
import com.gxuwz.Market.business.service.ExamService;
import com.gxuwz.Market.business.service.IChoiceTopicService;
import com.gxuwz.Market.business.service.ICorrectRateService;
import com.gxuwz.Market.business.service.IExamQuestionAnswerService;
import com.gxuwz.Market.business.service.IFillTopicService;
import com.gxuwz.Market.business.service.IJudgeTopicService;
import com.gxuwz.Market.business.service.IMultipleTopicService;
import com.gxuwz.Market.business.service.TopicService;
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
public class ExamQuestionAnswerAction extends BaseAction implements Preparable, ModelDriven{
	
	protected static final String LIST_JSP = "/WEB-INF/page/exam/exam_list.jsp";
	protected static final String LIST1_JSP = "/WEB-INF/page/student/exam_list.jsp";
	protected static final String INDEX_JSP = "/WEB-INF/page/index1.jsp";//登录后中心页面
	
	private Examquestionanswer examquestionanswer;
	private Result<Exam> pageResult; //分页
	private Exam exam;
	private Testpaper testPaper;
	private Studentexamscore studentScore;
	private CorrectRate correctRate;
	private ChoiceTopic choiceTopic;
	private FillTopic fillTopic;
	private MultipleTopic multipleTopic;
	private JudgeTopic judgeTopic;
	private Topic topic;
	int choiceScore = 0;
	int fillScore =0; 
	int topicScore =0;
	int judgeScore = 0;
	int multipleScore =0; 
	int totalScore =0;
	float rate;
	
	protected final Log logger=LogFactory.getLog(getClass());
	
	@Autowired
	private IExamQuestionAnswerService examQuestionAnswerService;
	@Autowired
	private ExamService examService;
	@Autowired
	private ICorrectRateService correctRateService;
	@Autowired
	private IChoiceTopicService choiceTopicService ;
	@Autowired
	private IFillTopicService fillTopicService ;
	@Autowired
	private IMultipleTopicService multipleTopicService ;
	@Autowired
	private IJudgeTopicService judgeTopicService ;
	@Autowired
	private TopicService topicService ;
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
			correctRate = new CorrectRate();
			choiceTopic = new ChoiceTopic();
		}
		if(null == studentScore){
			studentScore = new Studentexamscore();
		}
		if(null == testPaper){
			testPaper = new Testpaper();
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
		String[] choiceTopicIdAll = getRequest().getParameterValues("choiceTopicId");  //获取单选题id
		String[] fillTopicIdAll = getRequest().getParameterValues("fillTopicId");  //获取试题id
		String[] topicIdAll = getRequest().getParameterValues("topicId");  //获取试题id 
		String[] judgeTopicIdAll = getRequest().getParameterValues("judgeTopicId");
		String[] multipleTopicIdAll = getRequest().getParameterValues("multipleTopicId");
		//查询各题型分值
//		Testpaper test = examQuestionAnswerService.getAllScore(exam.getExamId());//从jsp页面传过来的
		if(choiceTopicIdAll!=null){
			for(int i=0;i<choiceTopicIdAll.length;i++){
				int studentId =  studentId1 ;
				String[] answer = getRequest().getParameterValues("answer_"+choiceTopicIdAll[i]);
			    
				String answer0 = answer[0];
				int topicId = Integer.parseInt(choiceTopicIdAll[i]);
				int examId = exam.getExamId();
				String type="单选题";
				Examquestionanswer questionAnswer=new Examquestionanswer(answer0,topicId,studentId,examId,type);
				list.add(questionAnswer);
				examQuestionAnswerService.addBatch(list);
				
				List<String> answerAll1 = (List<String>)examQuestionAnswerService.getAllChoiceAnswer(studentId, topicId,examId);
				Object list1 =  answerAll1.get(0);
				Object[] list2 = (Object[] )list1;
				if(list2[1].equals("单选题")&&list2[0].equals(answer0)){
					int scorePerChoice = (int) list2[3];
					choiceScore += scorePerChoice;
					if(correctRateService.findByTopicId(topicId)!=null){
						CorrectRate correctRate1 = correctRateService.findByTopicId(topicId);
						correctRate1.setRightNumber(correctRate1.getRightNumber()+1);
						correctRate1.setAllNumber(correctRate1.getAllNumber()+1);
						correctRateService.update(correctRate1);
						rate = (float)((float)correctRate1.getRightNumber()/(float)correctRate1.getAllNumber());
					}else{
						correctRate.setTopicId(topicId);
						correctRate.setRightNumber(1);
						correctRate.setWrongNumber(0);
						correctRate.setAllNumber(1);
						correctRate.setType(type);
						correctRateService.add(correctRate);
						rate = (float)((float)correctRate.getRightNumber()/(float)correctRate.getAllNumber());
						correctRate = new CorrectRate();
					}
					
		        }else{
		        	if(correctRateService.findByTopicId(topicId)!=null){
						CorrectRate correctRate1 = correctRateService.findByTopicId(topicId);
						correctRate1.setWrongNumber(correctRate1.getWrongNumber()+1);
						correctRate1.setAllNumber(correctRate1.getAllNumber()+1);
						correctRateService.update(correctRate1);
						rate = (float)((float)correctRate1.getRightNumber()/(float)correctRate1.getAllNumber());
					}else{
						correctRate.setTopicId(topicId);
						correctRate.setRightNumber(0);
						correctRate.setWrongNumber(1);
						correctRate.setAllNumber(1);
						correctRate.setType(type);
						correctRateService.add(correctRate);
						rate = (float)((float)correctRate.getRightNumber()/(float)correctRate.getAllNumber());
						correctRate = new CorrectRate();
					}
		        }
				
				ChoiceTopic choiceTopic = choiceTopicService.findById(topicId);
				if(rate>=0&&rate<=0.2){
					choiceTopic.setDifficulty("非常困难");
					choiceTopicService.update(choiceTopic);
				}else if(rate>0.2&&rate<=0.4){
					choiceTopic.setDifficulty("困难");
					choiceTopicService.update(choiceTopic);
				}else if(rate>0.4&&rate<=0.6){
					choiceTopic.setDifficulty("常规");
					choiceTopicService.update(choiceTopic);
				}else if(rate>0.6&&rate<=0.8){
					choiceTopic.setDifficulty("容易");
					choiceTopicService.update(choiceTopic);
				}else if(rate>0.8&&rate<=1){
					choiceTopic.setDifficulty("非常容易");
					choiceTopicService.update(choiceTopic);
				}
				
			}
		}
		
		if(fillTopicIdAll!=null){
			for(int i=0;i<fillTopicIdAll.length;i++){
				String[] answer = getRequest().getParameterValues("answer_"+fillTopicIdAll[i]);
			    
			    int studentId =  studentId1 ;
				String answer0 = answer[0];
				int topicId = Integer.parseInt(fillTopicIdAll[i]);
				int examId = exam.getExamId();
				String type="填空题";
				Examquestionanswer questionAnswer=new Examquestionanswer(answer0,topicId,studentId,examId,type);
				list.add(questionAnswer);
				examQuestionAnswerService.addBatch(list);
				
				List<String> answerAll2 = (List<String>)examQuestionAnswerService.getAllFillAnswer(studentId, topicId,examId);
				Object list1 =  answerAll2.get(0);
				Object[] list2 = (Object[] )list1;
				if(list2[1].equals("填空题")&&list2[0].equals(answer0)){
					int scorePerFill = (int) list2[3];
					fillScore += scorePerFill;
					if(correctRateService.findByTopicId(topicId)!=null){
						CorrectRate correctRate1 = correctRateService.findByTopicId(topicId);
						correctRate1.setRightNumber(correctRate1.getRightNumber()+1);
						correctRate1.setAllNumber(correctRate1.getAllNumber()+1);
						correctRateService.update(correctRate1);
						rate = (float)((float)correctRate1.getRightNumber()/(float)correctRate1.getAllNumber());
					}else{
						correctRate.setTopicId(topicId);
						correctRate.setRightNumber(1);
						correctRate.setWrongNumber(0);
						correctRate.setAllNumber(1);
						correctRate.setType(type);
						correctRateService.add(correctRate);
						rate = (float)((float)correctRate.getRightNumber()/(float)correctRate.getAllNumber());
						correctRate = new CorrectRate();
					}
				}else{
					if(correctRateService.findByTopicId(topicId)!=null){
						CorrectRate correctRate1 = correctRateService.findByTopicId(topicId);
						correctRate1.setWrongNumber(correctRate1.getWrongNumber()+1);
						correctRate1.setAllNumber(correctRate1.getAllNumber()+1);
						correctRateService.update(correctRate1);
						rate = (float)((float)correctRate1.getRightNumber()/(float)correctRate1.getAllNumber());
					}else{
						correctRate.setTopicId(topicId);
						correctRate.setRightNumber(0);
						correctRate.setWrongNumber(1);
						correctRate.setAllNumber(1);
						correctRate.setType(type);
						correctRateService.add(correctRate);
						rate = (float)((float)correctRate.getRightNumber()/(float)correctRate.getAllNumber());
						correctRate = new CorrectRate();
					}
				}
				FillTopic fillTopic = fillTopicService.findById(topicId);
				if(rate>=0&&rate<=0.2){
					fillTopic.setDifficulty("非常困难");
					fillTopicService.update(fillTopic);
				}else if(rate>0.2&&rate<=0.4){
					fillTopic.setDifficulty("困难");
					fillTopicService.update(fillTopic);
				}else if(rate>0.4&&rate<=0.6){
					fillTopic.setDifficulty("常规");
					fillTopicService.update(fillTopic);
				}else if(rate>0.6&&rate<=0.8){
					fillTopic.setDifficulty("容易");
					fillTopicService.update(fillTopic);
				}else if(rate>0.8&&rate<=1){
					fillTopic.setDifficulty("非常容易");
					fillTopicService.update(fillTopic);
				}
			}
		}
		
		if(topicIdAll!=null){
			for(int i=0;i<topicIdAll.length;i++){
				String[] answer = getRequest().getParameterValues("answer_"+topicIdAll[i]);

				int studentId =  studentId1 ;
				String answer0 = answer[0];
				int topicId = Integer.parseInt(topicIdAll[i]);
				int examId = exam.getExamId();
				String type="简答题";
				Examquestionanswer questionAnswer=new Examquestionanswer(answer0,topicId,studentId,examId,type);
				list.add(questionAnswer);
				examQuestionAnswerService.addBatch(list);
				
				/*List<String> answerAll3 = (List<String>)examQuestionAnswerService.getAllTopicAnswer(studentId, topicId,examId);
				Object list1 =  answerAll3.get(0);
				Object[] list2 = (Object[] )list1;
				if(list2[1].equals("简答题")&&list2[0].equals(answer0)){
					int scorePerTopic = (int) list2[3];
					topicScore+= scorePerTopic;
					
					if(correctRateService.findByTopicId(topicId)!=null){
						CorrectRate correctRate1 = correctRateService.findByTopicId(topicId);
						correctRate1.setRightNumber(correctRate1.getRightNumber()+1);
						correctRate1.setAllNumber(correctRate1.getAllNumber()+1);
						correctRateService.update(correctRate1);
						rate = (float)((float)correctRate1.getRightNumber()/(float)correctRate1.getAllNumber());
					}else{
						correctRate.setTopicId(topicId);
						correctRate.setRightNumber(1);
						correctRate.setWrongNumber(0);
						correctRate.setAllNumber(1);
						correctRate.setType(type);
						correctRateService.add(correctRate);
						rate = (float)((float)correctRate.getRightNumber()/(float)correctRate.getAllNumber());
					}
				}else{
					if(correctRateService.findByTopicId(topicId)!=null){
						CorrectRate correctRate1 = correctRateService.findByTopicId(topicId);
						correctRate1.setWrongNumber(correctRate1.getWrongNumber()+1);
						correctRate1.setAllNumber(correctRate1.getAllNumber()+1);
						correctRateService.update(correctRate1);
						rate = (float)((float)correctRate1.getRightNumber()/(float)correctRate1.getAllNumber());
					}else{
						correctRate.setTopicId(topicId);
						correctRate.setRightNumber(1);
						correctRate.setWrongNumber(0);
						correctRate.setAllNumber(1);
						correctRate.setType(type);
						correctRateService.add(correctRate);
						rate = (float)((float)correctRate.getRightNumber()/(float)correctRate.getAllNumber());
					}
				}
				Topic topic = topicService.findById(topicId);
				if(rate>=0&&rate<=0.2){
					topic.setDifficulty("非常困难");
					topicService.update(topic);
				}else if(rate>0.2&&rate<=0.4){
					topic.setDifficulty("困难");
					topicService.update(topic);
				}else if(rate>0.4&&rate<=0.6){
					topic.setDifficulty("常规");
					topicService.update(topic);
				}else if(rate>0.6&&rate<=0.8){
					topic.setDifficulty("容易");
					topicService.update(topic);
				}else if(rate>0.8&&rate<=1){
					topic.setDifficulty("非常容易");
					topicService.update(topic);
				}*/
			}
		}
		
		if(judgeTopicIdAll!=null){
			for(int i=0;i<judgeTopicIdAll.length;i++){
				String[] answer = getRequest().getParameterValues("answer_"+judgeTopicIdAll[i]);

				int studentId =  studentId1 ;
				String answer0 = answer[0];
				int topicId = Integer.parseInt(judgeTopicIdAll[i]);
				int examId = exam.getExamId();
				String type="判断题";
				Examquestionanswer questionAnswer=new Examquestionanswer(answer0,topicId,studentId,examId,type);
				list.add(questionAnswer);
				examQuestionAnswerService.addBatch(list);
				
				List<String> answerAll4 = (List<String>)examQuestionAnswerService.getAllJudgeTopicAnswer(studentId, topicId, examId);
				Object list1 =  answerAll4.get(0);
				Object[] list2 = (Object[] )list1;
				if(list2[1].equals("判断题")&&list2[0].equals(answer0)){
					int scorePerTopic = (int) list2[3];
					judgeScore+= scorePerTopic;
					
					if(correctRateService.findByTopicId(topicId)!=null){
						CorrectRate correctRate1 = correctRateService.findByTopicId(topicId);
						correctRate1.setRightNumber(correctRate1.getRightNumber()+1);
						correctRate1.setAllNumber(correctRate1.getAllNumber()+1);
						correctRateService.update(correctRate1);
						rate = (float)((float)correctRate1.getRightNumber()/(float)correctRate1.getAllNumber());
					}else{
						correctRate.setTopicId(topicId);
						correctRate.setRightNumber(1);
						correctRate.setWrongNumber(0);
						correctRate.setAllNumber(1);
						correctRate.setType(type);
						correctRateService.add(correctRate);
						rate = (float)((float)correctRate.getRightNumber()/(float)correctRate.getAllNumber());
						correctRate = new CorrectRate();
					}
				}else{
					if(correctRateService.findByTopicId(topicId)!=null){
						CorrectRate correctRate1 = correctRateService.findByTopicId(topicId);
						correctRate1.setWrongNumber(correctRate1.getWrongNumber()+1);
						correctRate1.setAllNumber(correctRate1.getAllNumber()+1);
						correctRateService.update(correctRate1);
						rate = (float)((float)correctRate1.getRightNumber()/(float)correctRate1.getAllNumber());
					}else{
						correctRate.setTopicId(topicId);
						correctRate.setRightNumber(1);
						correctRate.setWrongNumber(0);
						correctRate.setAllNumber(1);
						correctRate.setType(type);
						correctRateService.add(correctRate);
						rate = (float)((float)correctRate.getRightNumber()/(float)correctRate.getAllNumber());
						correctRate = new CorrectRate();
					}
				}
				JudgeTopic judgeTopic = judgeTopicService.findById(topicId);
				if(rate>=0&&rate<=0.2){
					judgeTopic.setDifficulty("非常困难");
					judgeTopicService.update(judgeTopic);
				}else if(rate>0.2&&rate<=0.4){
					judgeTopic.setDifficulty("困难");
					judgeTopicService.update(judgeTopic);
				}else if(rate>0.4&&rate<=0.6){
					judgeTopic.setDifficulty("常规");
					judgeTopicService.update(judgeTopic);
				}else if(rate>0.6&&rate<=0.8){
					judgeTopic.setDifficulty("容易");
					judgeTopicService.update(judgeTopic);
				}else if(rate>0.8&&rate<=1){
					judgeTopic.setDifficulty("非常容易");
					judgeTopicService.update(judgeTopic);
				}
			}
		}
		
		if(multipleTopicIdAll!=null){
			for(int i=0;i<multipleTopicIdAll.length;i++){
				String[] answer = getRequest().getParameterValues("answer_"+multipleTopicIdAll[i]);
				
				int studentId =  studentId1 ;
				String answer0 = answer[0];
				int topicId = Integer.parseInt(multipleTopicIdAll[i]);
				int examId = exam.getExamId();
				String type="多选题";
				Examquestionanswer questionAnswer=new Examquestionanswer(answer0,topicId,studentId,examId,type);
				list.add(questionAnswer);
				examQuestionAnswerService.addBatch(list);
				
				List<String> answerAll3 = (List<String>)examQuestionAnswerService.getAllMultipleTopicAnswer(studentId, topicId, examId);
				Object list1 =  answerAll3.get(0);
				Object[] list2 = (Object[] )list1;
				if(list2[1].equals("多选题")&&list2[0].equals(answer)){
					int scorePerTopic = (int) list2[3];
					multipleScore+= scorePerTopic;
					if(correctRateService.findByTopicId(topicId)!=null){
						CorrectRate correctRate1 = correctRateService.findByTopicId(topicId);
						correctRate1.setRightNumber(correctRate1.getRightNumber()+1);
						correctRate1.setAllNumber(correctRate1.getAllNumber()+1);
						correctRateService.update(correctRate1);
						rate = (float)((float)correctRate1.getRightNumber()/(float)correctRate1.getAllNumber());
					}else{
						correctRate.setTopicId(topicId);
						correctRate.setRightNumber(1);
						correctRate.setWrongNumber(0);
						correctRate.setAllNumber(1);
						correctRate.setType(type);
						correctRateService.add(correctRate);
						rate = (float)((float)correctRate.getRightNumber()/(float)correctRate.getAllNumber());
						correctRate = new CorrectRate();
					}
				}else{
					if(correctRateService.findByTopicId(topicId)!=null){
						CorrectRate correctRate1 = correctRateService.findByTopicId(topicId);
						correctRate1.setWrongNumber(correctRate1.getWrongNumber()+1);
						correctRate1.setAllNumber(correctRate1.getAllNumber()+1);
						correctRateService.update(correctRate1);
						rate = (float)((float)correctRate1.getRightNumber()/(float)correctRate1.getAllNumber());
					}else{
						correctRate.setTopicId(topicId);
						correctRate.setRightNumber(1);
						correctRate.setWrongNumber(0);
						correctRate.setAllNumber(1);
						correctRate.setType(type);
						correctRateService.add(correctRate);
						rate = (float)((float)correctRate.getRightNumber()/(float)correctRate.getAllNumber());
						correctRate = new CorrectRate();
					}
				}
				MultipleTopic multipleTopic = multipleTopicService.findById(topicId);
				if(rate>=0&&rate<=0.2){
					multipleTopic.setDifficulty("非常困难");
					multipleTopicService.update(multipleTopic);
				}else if(rate>0.2&&rate<=0.4){
					multipleTopic.setDifficulty("困难");
					multipleTopicService.update(multipleTopic);
				}else if(rate>0.4&&rate<=0.6){
					multipleTopic.setDifficulty("常规");
					multipleTopicService.update(multipleTopic);
				}else if(rate>0.6&&rate<=0.8){
					multipleTopic.setDifficulty("容易");
					multipleTopicService.update(multipleTopic);
				}else if(rate>0.8&&rate<=1){
					multipleTopic.setDifficulty("非常容易");
					multipleTopicService.update(multipleTopic);
				}
			}
		}
		totalScore = choiceScore+fillScore+topicScore+multipleScore+judgeScore;
		studentScore.setExamId(exam.getExamId());
		studentScore.setScore(totalScore);
		String examPhase = "已交卷";
		studentScore.setExamPhase(examPhase);
		studentScore.setStudentId(studentId1);
		studentScore.setExamName(exam.getExamName());
		examQuestionAnswerService.add(studentScore);
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

	public Testpaper getTestPaper() {
		return testPaper;
	}

	public void setTestPaper(Testpaper testPaper) {
		this.testPaper = testPaper;
	}

	public CorrectRate getCorrectRate() {
		return correctRate;
	}

	public void setCorrectRate(CorrectRate correctRate) {
		this.correctRate = correctRate;
	}

	public ChoiceTopic getChoiceTopic() {
		return choiceTopic;
	}

	public void setChoiceTopic(ChoiceTopic choiceTopic) {
		this.choiceTopic = choiceTopic;
	}

	public FillTopic getFillTopic() {
		return fillTopic;
	}

	public void setFillTopic(FillTopic fillTopic) {
		this.fillTopic = fillTopic;
	}

	public MultipleTopic getMultipleTopic() {
		return multipleTopic;
	}

	public void setMultipleTopic(MultipleTopic multipleTopic) {
		this.multipleTopic = multipleTopic;
	}

	public JudgeTopic getJudgeTopic() {
		return judgeTopic;
	}

	public void setJudgeTopic(JudgeTopic judgeTopic) {
		this.judgeTopic = judgeTopic;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
}

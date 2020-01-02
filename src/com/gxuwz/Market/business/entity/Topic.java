package com.gxuwz.Market.business.entity;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */

public class Topic implements java.io.Serializable {

	// Fields

	private Integer topicId;
	private String question;
	private String pointName;
	private String topicDegree;
	private String topicTypes;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String option5;
	private String option6;
	private String option7;
	private String option8;
	private String topicScore;
	private String topicAnswer;
	private String topicAnswer1;
	private String topicAnswer2;
	private String topicAnswer3;
	private String topicAnswer0;
	private String courseName;
	private String teacherName;
	private String topicBankName;

	// Constructors

	/** default constructor */
	public Topic() {
	}

	public Topic(String question, String pointName, String topicDegree, String topicTypes, String optionA,
			String optionB, String optionC, String optionD, String option1, String option2, String option3,
			String option4, String option5, String option6, String option7, String option8, String topicScore,
			String topicAnswer, String topicAnswer1, String topicAnswer2, String topicAnswer3, String topicAnswer0,
			String courseName, String teacherName, String topicBankName) {
		super();
		this.question = question;
		this.pointName = pointName;
		this.topicDegree = topicDegree;
		this.topicTypes = topicTypes;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.option5 = option5;
		this.option6 = option6;
		this.option7 = option7;
		this.option8 = option8;
		this.topicScore = topicScore;
		this.topicAnswer = topicAnswer;
		this.topicAnswer1 = topicAnswer1;
		this.topicAnswer2 = topicAnswer2;
		this.topicAnswer3 = topicAnswer3;
		this.topicAnswer0 = topicAnswer0;
		this.courseName = courseName;
		this.teacherName = teacherName;
		this.topicBankName = topicBankName;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public String getTopicDegree() {
		return topicDegree;
	}

	public void setTopicDegree(String topicDegree) {
		this.topicDegree = topicDegree;
	}

	public String getTopicTypes() {
		return topicTypes;
	}

	public void setTopicTypes(String topicTypes) {
		this.topicTypes = topicTypes;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getOption5() {
		return option5;
	}

	public void setOption5(String option5) {
		this.option5 = option5;
	}

	public String getOption6() {
		return option6;
	}

	public void setOption6(String option6) {
		this.option6 = option6;
	}

	public String getOption7() {
		return option7;
	}

	public void setOption7(String option7) {
		this.option7 = option7;
	}

	public String getOption8() {
		return option8;
	}

	public void setOption8(String option8) {
		this.option8 = option8;
	}

	public String getTopicScore() {
		return topicScore;
	}

	public void setTopicScore(String topicScore) {
		this.topicScore = topicScore;
	}

	public String getTopicAnswer() {
		return topicAnswer;
	}

	public void setTopicAnswer(String topicAnswer) {
		this.topicAnswer = topicAnswer;
	}

	public String getTopicAnswer1() {
		return topicAnswer1;
	}

	public void setTopicAnswer1(String topicAnswer1) {
		this.topicAnswer1 = topicAnswer1;
	}

	public String getTopicAnswer2() {
		return topicAnswer2;
	}

	public void setTopicAnswer2(String topicAnswer2) {
		this.topicAnswer2 = topicAnswer2;
	}

	public String getTopicAnswer3() {
		return topicAnswer3;
	}

	public void setTopicAnswer3(String topicAnswer3) {
		this.topicAnswer3 = topicAnswer3;
	}

	public String getTopicAnswer0() {
		return topicAnswer0;
	}

	public void setTopicAnswer0(String topicAnswer0) {
		this.topicAnswer0 = topicAnswer0;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTopicBankName() {
		return topicBankName;
	}

	public void setTopicBankName(String topicBankName) {
		this.topicBankName = topicBankName;
	}
	
}
package com.gxuwz.Market.business.entity;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */

public class FillTopic implements java.io.Serializable {

	// Fields
	private Integer topicId;
	private String question;
	private String answer;
	private String topicTypes;
	private String topicDegree;
	private String topicBankName;
	private String creator;

	// Constructors
	public FillTopic(Integer topicId, String question, String answer, String topicTypes, String topicDegree,
			String topicBankName, String creator) {
		super();
		this.topicId = topicId;
		this.question = question;
		this.answer = answer;
		this.topicTypes = topicTypes;
		this.topicDegree = topicDegree;
		this.topicBankName = topicBankName;
		this.creator = creator;
	}
	
	/** default constructor */
	public FillTopic() {
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getTopicTypes() {
		return topicTypes;
	}

	public void setTopicTypes(String topicTypes) {
		this.topicTypes = topicTypes;
	}

	public String getTopicDegree() {
		return topicDegree;
	}

	public void setTopicDegree(String topicDegree) {
		this.topicDegree = topicDegree;
	}

	public String getTopicBankName() {
		return topicBankName;
	}

	public void setTopicBankName(String topicBankName) {
		this.topicBankName = topicBankName;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
}
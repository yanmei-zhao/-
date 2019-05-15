package com.gxuwz.Market.business.entity;

/**
 * Answersheet entity. @author MyEclipse Persistence Tools
 */

public class Answersheet implements java.io.Serializable {

	// Fields

	private Integer answersheetId;
	private Integer answersheetTopicId;
	private String answersheetTopicAnswer;
	private String answersheetTopicFraction;
	private String answersheetFraction;
	private Integer studentId;

	// Constructors

	/** default constructor */
	public Answersheet() {
	}

	/** full constructor */
	public Answersheet(Integer answersheetTopicId,
			String answersheetTopicAnswer, String answersheetTopicFraction,
			String answersheetFraction, Integer studentId) {
		this.answersheetTopicId = answersheetTopicId;
		this.answersheetTopicAnswer = answersheetTopicAnswer;
		this.answersheetTopicFraction = answersheetTopicFraction;
		this.answersheetFraction = answersheetFraction;
		this.studentId = studentId;
	}

	// Property accessors

	public Integer getAnswersheetId() {
		return this.answersheetId;
	}

	public void setAnswersheetId(Integer answersheetId) {
		this.answersheetId = answersheetId;
	}

	public Integer getAnswersheetTopicId() {
		return this.answersheetTopicId;
	}

	public void setAnswersheetTopicId(Integer answersheetTopicId) {
		this.answersheetTopicId = answersheetTopicId;
	}

	public String getAnswersheetTopicAnswer() {
		return this.answersheetTopicAnswer;
	}

	public void setAnswersheetTopicAnswer(String answersheetTopicAnswer) {
		this.answersheetTopicAnswer = answersheetTopicAnswer;
	}

	public String getAnswersheetTopicFraction() {
		return this.answersheetTopicFraction;
	}

	public void setAnswersheetTopicFraction(String answersheetTopicFraction) {
		this.answersheetTopicFraction = answersheetTopicFraction;
	}

	public String getAnswersheetFraction() {
		return this.answersheetFraction;
	}

	public void setAnswersheetFraction(String answersheetFraction) {
		this.answersheetFraction = answersheetFraction;
	}

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

}
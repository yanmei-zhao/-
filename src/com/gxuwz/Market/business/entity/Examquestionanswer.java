package com.gxuwz.Market.business.entity;

import java.sql.Timestamp;

/**
 * Examquestionanswer entity. @author MyEclipse Persistence Tools
 */

public class Examquestionanswer implements java.io.Serializable {

	// Fields

	private Integer id;
	private String answer;
	private Integer topicId;
	private Integer studentId;
	private Timestamp answerDate;
	private String[] answerAll;
	private Integer topicIdAll[];

	// Constructors

	/** default constructor */
	public Examquestionanswer() {
	}

	/** full constructor */
	public Examquestionanswer(String answer, Integer topicId, Integer studentId, Timestamp answerDate) {
		this.answer = answer;
		this.topicId = topicId;
		this.studentId = studentId;
		this.answerDate = answerDate;
	}
	
	/** full constructor */
	public Examquestionanswer(String answer, Integer topicId, Integer studentId) {
		this.answer = answer;
		this.topicId = topicId;
		this.studentId = studentId;
	}

	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Timestamp getAnswerDate() {
		return this.answerDate;
	}

	public void setAnswerDate(Timestamp answerDate) {
		this.answerDate = answerDate;
	}

	public String[] getAnswerAll() {
		return answerAll;
	}

	public void setAnswerAll(String[] answerAll) {
		this.answerAll = answerAll;
	}

	public Integer[] getTopicIdAll() {
		return topicIdAll;
	}

	public void setTopicIdAll(Integer[] topicIdAll) {
		this.topicIdAll = topicIdAll;
	}

}
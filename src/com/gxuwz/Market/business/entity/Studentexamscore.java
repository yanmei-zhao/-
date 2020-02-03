package com.gxuwz.Market.business.entity;

import java.sql.Timestamp;

/**
 * Studentexamscore entity. @author MyEclipse Persistence Tools
 */

public class Studentexamscore implements java.io.Serializable {

	// Fields

	private Integer id;
	private String examPhase;
	private Integer score;
	private Integer examId;
	private Integer studentId;
	private Integer timeUsed;
	private Timestamp examStart;
	private Timestamp examEnd;
	private String examName;

	// Constructors

	/** default constructor */
	public Studentexamscore() {
	}

	/** full constructor */

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public Studentexamscore(String examPhase, Integer score, Integer examId, Integer studentId, Integer timeUsed,
			Timestamp examStart, Timestamp examEnd, String examName) {
		super();
		this.examPhase = examPhase;
		this.score = score;
		this.examId = examId;
		this.studentId = studentId;
		this.timeUsed = timeUsed;
		this.examStart = examStart;
		this.examEnd = examEnd;
		this.examName = examName;
	}


	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExamPhase() {
		return this.examPhase;
	}

	public void setExamPhase(String examPhase) {
		this.examPhase = examPhase;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getExamId() {
		return this.examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getTimeUsed() {
		return this.timeUsed;
	}

	public void setTimeUsed(Integer timeUsed) {
		this.timeUsed = timeUsed;
	}

	public Timestamp getExamStart() {
		return this.examStart;
	}

	public void setExamStart(Timestamp examStart) {
		this.examStart = examStart;
	}

	public Timestamp getExamEnd() {
		return this.examEnd;
	}

	public void setExamEnd(Timestamp examEnd) {
		this.examEnd = examEnd;
	}

}
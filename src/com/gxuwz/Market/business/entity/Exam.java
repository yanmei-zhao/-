package com.gxuwz.Market.business.entity;

import java.sql.Timestamp;

/**
 * Exam entity. @author MyEclipse Persistence Tools
 */

public class Exam implements java.io.Serializable {

	// Fields

	private Integer examId;
	private String examName;
	private Timestamp examStart;
	private String examState;
	private Timestamp examEnd;
	private String examDuration;
	private String totalPeople;
	private String className;
	private String teacherName;
	private Integer testPaperId;

	// Constructors

	/** default constructor */
	public Exam() {
	}

	/** full constructor */
	public Exam(String examName, Timestamp examStart, String examState, Timestamp examEnd, String examDuration,
			String totalPeople, String className, String teacherName, Integer testPaperId) {
		super();
		this.examName = examName;
		this.examStart = examStart;
		this.examState = examState;
		this.examEnd = examEnd;
		this.examDuration = examDuration;
		this.totalPeople = totalPeople;
		this.className = className;
		this.teacherName = teacherName;
		this.testPaperId = testPaperId;
	}
	// Property accessors

	public Integer getTestPaperId() {
		return testPaperId;
	}

	public void setTestPaperId(Integer testPaperId) {
		this.testPaperId = testPaperId;
	}

	public String getExamName() {
		return this.examName;
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Timestamp getExamStart() {
		return this.examStart;
	}

	public void setExamStart(Timestamp examStart) {
		this.examStart = examStart;
	}

	public String getExamState() {
		return this.examState;
	}

	public void setExamState(String examState) {
		this.examState = examState;
	}

	public Timestamp getExamEnd() {
		return this.examEnd;
	}

	public void setExamEnd(Timestamp examEnd) {
		this.examEnd = examEnd;
	}

	public String getExamDuration() {
		return this.examDuration;
	}

	public void setExamDuration(String examDuration) {
		this.examDuration = examDuration;
	}

	public String getTotalPeople() {
		return this.totalPeople;
	}

	public void setTotalPeople(String totalPeople) {
		this.totalPeople = totalPeople;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

}
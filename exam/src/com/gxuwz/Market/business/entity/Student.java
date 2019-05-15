package com.gxuwz.Market.business.entity;

import java.math.BigInteger;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private String studentId;
	private String studentName;
	private String studentPassword;
	private Integer classId;
	private String className;
	private String grade;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String studentId,String studentName, String studentPassword, Integer classId,String className,String grade) {
		this.studentId= studentId;
		this.studentName = studentName;
		this.studentPassword = studentPassword;
		this.classId = classId;
		this.className = className;
		this.grade = grade;
	}

	// Property accessors

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentPassword() {
		return this.studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}


}
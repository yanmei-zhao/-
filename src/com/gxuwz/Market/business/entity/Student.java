package com.gxuwz.Market.business.entity;

import java.math.BigInteger;

/**
 * <p>Title:</p>
 * <p>Description:Student entity</p>
 * @author Administrator
 * @date 2019年7月6日下午6:19:04
 */
public class Student implements java.io.Serializable {

	// Fields

	private String studentId;
	private String studentName;
	private Integer classId;
	private String className;
	private String grade;
	private String studentPassword;
	private int userType;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String studentId, String studentName, Integer classId, String className, String grade,
			String studentPassword, int userType) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.classId = classId;
		this.className = className;
		this.grade = grade;
		this.studentPassword = studentPassword;
		this.userType = userType;
	}
	// Property accessors


	public String getStudentName() {
		return this.studentName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}


}
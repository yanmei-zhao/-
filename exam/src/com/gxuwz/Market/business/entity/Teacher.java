package com.gxuwz.Market.business.entity;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer teacherId;
	private String teacherName;
	private Integer courseId;
	private Integer classId;
	private String teacherPassword;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** full constructor */
	public Teacher(String teacherName, Integer courseId, Integer classId,
			String teacherPassword) {
		this.teacherName = teacherName;
		this.courseId = courseId;
		this.classId = classId;
		this.teacherPassword = teacherPassword;
	}

	// Property accessors

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getTeacherPassword() {
		return this.teacherPassword;
	}

	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}

}
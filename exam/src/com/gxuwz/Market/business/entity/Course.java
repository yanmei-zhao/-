package com.gxuwz.Market.business.entity;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private Integer courseId;
	private String courseName;
	private Integer teacherId;
	private Integer classId;
	private String creator;
	private String finalModifier;

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course( String courseName, Integer teacherId, Integer classId, String creator,
			String finalModifier) {
		super();
		this.courseName = courseName;
		this.teacherId = teacherId;
		this.classId = classId;
		this.creator = creator;
		this.finalModifier = finalModifier;
	}

	// Property accessors

	public Integer getCourseId() {
		return this.courseId;
	}

	
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getFinalModifier() {
		return finalModifier;
	}

	public void setFinalModifier(String finalModifier) {
		this.finalModifier = finalModifier;
	}

}
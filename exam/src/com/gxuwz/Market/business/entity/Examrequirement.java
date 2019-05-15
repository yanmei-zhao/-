package com.gxuwz.Market.business.entity;

/**
 * Examrequirement entity. @author MyEclipse Persistence Tools
 */

public class Examrequirement implements java.io.Serializable {

	// Fields

	private Integer requirementId;
	private Integer pointId;
	private String examContent;
	private Integer teacherId;

	// Constructors

	/** default constructor */
	public Examrequirement() {
	}

	/** full constructor */
	public Examrequirement(Integer pointId, String examContent,
			Integer teacherId) {
		this.pointId = pointId;
		this.examContent = examContent;
		this.teacherId = teacherId;
	}

	// Property accessors

	public Integer getRequirementId() {
		return this.requirementId;
	}

	public void setRequirementId(Integer requirementId) {
		this.requirementId = requirementId;
	}

	public Integer getPointId() {
		return this.pointId;
	}

	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}

	public String getExamContent() {
		return this.examContent;
	}

	public void setExamContent(String examContent) {
		this.examContent = examContent;
	}

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

}
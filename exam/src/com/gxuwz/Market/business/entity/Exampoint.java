package com.gxuwz.Market.business.entity;

/**
 * Exampoint entity. @author MyEclipse Persistence Tools
 */

public class Exampoint implements java.io.Serializable {

	// Fields

	private Integer pointId;
	private String pointContent;

	// Constructors

	/** default constructor */
	public Exampoint() {
	}

	/** full constructor */
	public Exampoint(String pointContent) {
		this.pointContent = pointContent;
	}

	// Property accessors

	public Integer getPointId() {
		return this.pointId;
	}

	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}

	public String getPointContent() {
		return this.pointContent;
	}

	public void setPointContent(String pointContent) {
		this.pointContent = pointContent;
	}

}
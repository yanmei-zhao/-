package com.gxuwz.Market.business.entity;

/**
 * CorrectRate entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
public class CorrectRate implements java.io.Serializable {
	
	private int id;
	private int topicId;
	private String type;
	private int rightNumber;
	private int wrongNumber;
	private int allNumber;
	
	public CorrectRate(){}

	
	public CorrectRate(int topicId, String type, int rightNumber, int wrongNumber, int allNumber) {
		super();
		this.topicId = topicId;
		this.type = type;
		this.rightNumber = rightNumber;
		this.wrongNumber = wrongNumber;
		this.allNumber = allNumber;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRightNumber() {
		return rightNumber;
	}

	public void setRightNumber(int rightNumber) {
		this.rightNumber = rightNumber;
	}

	public int getWrongNumber() {
		return wrongNumber;
	}

	public void setWrongNumber(int wrongNumber) {
		this.wrongNumber = wrongNumber;
	}

	public int getAllNumber() {
		return allNumber;
	}

	public void setAllNumber(int allNumber) {
		this.allNumber = allNumber;
	}
	
	
}

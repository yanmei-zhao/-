package com.gxuwz.Market.business.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Testpaper entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Testpaper implements java.io.Serializable {

	// Fields
	private Integer testpaperId;
	private String testpaperName;
	private Integer topicId;
	private Integer totalScore;
	private Integer passScore;
	private String creator;
	private Set<Topic> topics = new HashSet<Topic>();
	// Constructors
	
	
	public Testpaper() {
		// TODO Auto-generated constructor stub
	}
	
	public Testpaper(String testpaperName, Integer topicId, Integer totalScore, Integer passScore, String creator) {
		super();
		this.testpaperName = testpaperName;
		this.topicId = topicId;
		this.totalScore = totalScore;
		this.passScore = passScore;
		this.creator = creator;
	}

	/** default constructor */

	public Integer getTestpaperId() {
		return testpaperId;
	}

	public void setTestpaperId(Integer testpaperId) {
		this.testpaperId = testpaperId;
	}

	public String getTestpaperName() {
		return testpaperName;
	}

	public void setTestpaperName(String testpaperName) {
		this.testpaperName = testpaperName;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	public Integer getPassScore() {
		return passScore;
	}
	public void setPassScore(Integer passScore) {
		this.passScore = passScore;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}
	

}
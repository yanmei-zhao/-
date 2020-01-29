package com.gxuwz.Market.business.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Testpaper entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Testpaper  {

	// Fields

	private Integer testpaperId;
	private String testpaperName;
	private Integer topicId;
	private Integer totalScore;
	private Integer passScore;
	private String creator;
	private Set<Topic> topics = new HashSet<Topic>();

	// Constructors

	/** default constructor */
	public Testpaper() {
	}

	/** full constructor */
	public Testpaper(String testpaperName, Integer topicId, Integer totalScore, Integer passScore, String creator,
			Set<Topic> topics) {
		this.testpaperName = testpaperName;
		this.topicId = topicId;
		this.totalScore = totalScore;
		this.passScore = passScore;
		this.creator = creator;
		this.topics = topics;
	}

	// Property accessors

	public Integer getTestpaperId() {
		return this.testpaperId;
	}

	public void setTestpaperId(Integer testpaperId) {
		this.testpaperId = testpaperId;
	}

	public String getTestpaperName() {
		return this.testpaperName;
	}

	public void setTestpaperName(String testpaperName) {
		this.testpaperName = testpaperName;
	}

	public Integer getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Integer getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getPassScore() {
		return this.passScore;
	}

	public void setPassScore(Integer passScore) {
		this.passScore = passScore;
	}

	public String getCreator() {
		return this.creator;
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
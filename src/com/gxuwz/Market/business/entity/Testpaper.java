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
	private Integer choicePerScore;
	private Integer fillPerScore;
	private Integer topicPerScore;
	private Set<Topic> topics = new HashSet<Topic>();

	// Constructors

	/** default constructor */
	public Testpaper() {
	}

	/** full constructor */
	public Testpaper( String testpaperName, Integer topicId, Integer totalScore, Integer passScore,
			String creator, Integer choicePerScore, Integer fillPerScore, Integer topicPerScore, Set<Topic> topics) {
		super();
		this.testpaperName = testpaperName;
		this.topicId = topicId;
		this.totalScore = totalScore;
		this.passScore = passScore;
		this.creator = creator;
		this.choicePerScore = choicePerScore;
		this.fillPerScore = fillPerScore;
		this.topicPerScore = topicPerScore;
		this.topics = topics;
	}

	// Property accessors

	public Integer getTestpaperId() {
		return this.testpaperId;
	}

	public Integer getChoicePerScore() {
		return choicePerScore;
	}

	public void setChoicePerScore(Integer choicePerScore) {
		this.choicePerScore = choicePerScore;
	}

	public Integer getFillPerScore() {
		return fillPerScore;
	}

	public void setFillPerScore(Integer fillPerScore) {
		this.fillPerScore = fillPerScore;
	}

	public Integer getTopicPerScore() {
		return topicPerScore;
	}

	public void setTopicPerScore(Integer topicPerScore) {
		this.topicPerScore = topicPerScore;
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
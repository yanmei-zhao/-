package com.gxuwz.Market.business.entity;

/**
 * Statistics entity. @author MyEclipse Persistence Tools
 */

public class Statistics implements java.io.Serializable {

	// Fields

	private Integer statisticsId;
	private Integer passNumber;
	private Integer nowNumber;
	private Integer excellentNumber;
	private Integer totalPeople;
	private Integer highestScore;
	private Integer averageScore;
	private String lowestScore;

	// Constructors

	/** default constructor */
	public Statistics() {
	}

	/** full constructor */
	public Statistics(Integer passNumber, Integer nowNumber,
			Integer excellentNumber, Integer totalPeople, Integer highestScore,
			Integer averageScore, String lowestScore) {
		this.passNumber = passNumber;
		this.nowNumber = nowNumber;
		this.excellentNumber = excellentNumber;
		this.totalPeople = totalPeople;
		this.highestScore = highestScore;
		this.averageScore = averageScore;
		this.lowestScore = lowestScore;
	}

	// Property accessors

	public Integer getStatisticsId() {
		return this.statisticsId;
	}

	public void setStatisticsId(Integer statisticsId) {
		this.statisticsId = statisticsId;
	}

	public Integer getPassNumber() {
		return this.passNumber;
	}

	public void setPassNumber(Integer passNumber) {
		this.passNumber = passNumber;
	}

	public Integer getNowNumber() {
		return this.nowNumber;
	}

	public void setNowNumber(Integer nowNumber) {
		this.nowNumber = nowNumber;
	}

	public Integer getExcellentNumber() {
		return this.excellentNumber;
	}

	public void setExcellentNumber(Integer excellentNumber) {
		this.excellentNumber = excellentNumber;
	}

	public Integer getTotalPeople() {
		return this.totalPeople;
	}

	public void setTotalPeople(Integer totalPeople) {
		this.totalPeople = totalPeople;
	}

	public Integer getHighestScore() {
		return this.highestScore;
	}

	public void setHighestScore(Integer highestScore) {
		this.highestScore = highestScore;
	}

	public Integer getAverageScore() {
		return this.averageScore;
	}

	public void setAverageScore(Integer averageScore) {
		this.averageScore = averageScore;
	}

	public String getLowestScore() {
		return this.lowestScore;
	}

	public void setLowestScore(String lowestScore) {
		this.lowestScore = lowestScore;
	}

}
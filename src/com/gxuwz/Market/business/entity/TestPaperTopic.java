package com.gxuwz.Market.business.entity;

@SuppressWarnings("serial")
public class TestPaperTopic implements java.io.Serializable{
	private Integer id;
	private Integer testpaperId;
	private Integer topicId;
	
	public TestPaperTopic() {
	}
	
	public TestPaperTopic(Integer testpaperId, Integer topicId) {
		super();
		this.testpaperId = testpaperId;
		this.topicId = topicId;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTestpaperId() {
		return testpaperId;
	}
	public void setTestpaperId(Integer testpaperId) {
		this.testpaperId = testpaperId;
	}
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	
}

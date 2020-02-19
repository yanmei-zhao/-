package com.gxuwz.Market.business.entity;

@SuppressWarnings("serial")
public class TestPaperTopic implements java.io.Serializable{
	private Integer id;
	private Integer testpaperId;
	private Integer topicId;
	private Integer choicetopicId;
	private Integer filltopicId;
	private Integer judgetopicId;
	private Integer multipletopicId;
	private String topicType;
	private Integer score;
	
	public TestPaperTopic() {
	}

	public TestPaperTopic(Integer testpaperId, Integer topicId, Integer choicetopicId, Integer filltopicId,
			Integer judgetopicId, Integer multipletopicId, String topicType, Integer score) {
		super();
		this.testpaperId = testpaperId;
		this.topicId = topicId;
		this.choicetopicId = choicetopicId;
		this.filltopicId = filltopicId;
		this.judgetopicId = judgetopicId;
		this.multipletopicId = multipletopicId;
		this.topicType = topicType;
		this.score = score;
	}

	public Integer getJudgetopicId() {
		return judgetopicId;
	}

	public void setJudgetopicId(Integer judgetopicId) {
		this.judgetopicId = judgetopicId;
	}

	public Integer getMultipletopicId() {
		return multipletopicId;
	}



	public void setMultipletopicId(Integer multipletopicId) {
		this.multipletopicId = multipletopicId;
	}



	public String getTopicType() {
		return topicType;
	}

	public void setTopicType(String topicType) {
		this.topicType = topicType;
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

	public Integer getChoicetopicId() {
		return choicetopicId;
	}

	public void setChoicetopicId(Integer choicetopicId) {
		this.choicetopicId = choicetopicId;
	}

	public Integer getFilltopicId() {
		return filltopicId;
	}

	public void setFilltopicId(Integer filltopicId) {
		this.filltopicId = filltopicId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	
}

package com.gxuwz.Market.business.entity;

@SuppressWarnings("serial")
public class TestPaperTopic implements java.io.Serializable{
	private Integer id;
	private Integer testpaperId;
	private Integer topicId;
	private Integer choicetopicId;
	private Integer filltopicId;
	private Testpaper testpaper;
	private String topicType;
	
	public TestPaperTopic() {
	}
	

	public TestPaperTopic(Integer testpaperId, Integer topicId, Integer choicetopicId, Integer filltopicId,
			 String topicType) {
		super();
		this.testpaperId = testpaperId;
		this.topicId = topicId;
		this.choicetopicId = choicetopicId;
		this.filltopicId = filltopicId;
		this.topicType = topicType;
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
	
	public Testpaper getTestpaper() {
		return testpaper;
	}

	public void setTestpaper(Testpaper testpaper) {
		this.testpaper = testpaper;
	}

}

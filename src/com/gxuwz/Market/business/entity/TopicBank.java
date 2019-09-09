package com.gxuwz.Market.business.entity;
/**
 * 
 *<p>Title:TopicBank</p>
 *<p>Description:</p>
 * @author zhaoyanmei
 * @date 2019年1月20日下午11:11:25
 */
public class TopicBank implements java.io.Serializable{
	
	// Fields
	
	private Integer topicBankId;
	private String topicBankName;
	private String topicBankType;
	private Integer topicNum;
	private String creator;
	private String finalModifier;
	
	// Constructors
	
	/** default constructor */
	public TopicBank(){}

	/** full constructor */
	public TopicBank( String topicBankName, String topicBankType,Integer topicNum, String creator, String finalModifier) {
		super();
		this.topicBankName = topicBankName;
		this.topicBankType = topicBankType;
		this.topicNum = topicNum;
		this.creator = creator;
		this.finalModifier = finalModifier;
	}

	// Property accessors
	public Integer getTopicBankId() {
		return topicBankId;
	}

	public void setTopicBankId(Integer topicBankId) {
		this.topicBankId = topicBankId;
	}

	public String getTopicBankName() {
		return topicBankName;
	}

	public void setTopicBankName(String topicBankName) {
		this.topicBankName = topicBankName;
	}

	public Integer getTopicNum() {
		return topicNum;
	}

	public void setTopicNum(Integer topicNum) {
		this.topicNum = topicNum;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getFinalModifier() {
		return finalModifier;
	}

	public void setFinalModifier(String finalModifier) {
		this.finalModifier = finalModifier;
	}

	public String getTopicBankType() {
		return topicBankType;
	}

	public void setTopicBankType(String topicBankType) {
		this.topicBankType = topicBankType;
	}
	
}

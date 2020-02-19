package com.gxuwz.Market.business.entity;

/**
 * Judgetopic entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class JudgeTopic implements java.io.Serializable {

	// Fields
	private Integer id;
	private String description;
	private String difficulty;
	private String type;
	private String knowledge;
	private String topicBankName;
	private String answer;
	private String creator;
	private Integer topicBankId;

	// Constructors

	/** default constructor */
	public JudgeTopic() {
	}

	public JudgeTopic(int id) {
		this.id=id;
	}
	
	/** full constructor */
	public JudgeTopic(String description, String knowledge, String answer,String difficulty, String type, String topicBankName,
			 String creator) {
		this.description = description;
		this.difficulty = difficulty;
		this.type = type;
		this.knowledge = knowledge;
		this.topicBankName = topicBankName;
		this.answer = answer;
		this.creator = creator;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKnowledge() {
		return this.knowledge;
	}

	public void setKnowledge(String knowledge) {
		this.knowledge = knowledge;
	}

	public String getTopicBankName() {
		return this.topicBankName;
	}

	public void setTopicBankName(String topicBankName) {
		this.topicBankName = topicBankName;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Integer getTopicBankId() {
		return this.topicBankId;
	}

	public void setTopicBankId(Integer topicBankId) {
		this.topicBankId = topicBankId;
	}

}
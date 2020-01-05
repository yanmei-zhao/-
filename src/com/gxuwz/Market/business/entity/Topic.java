package com.gxuwz.Market.business.entity;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Topic implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer paperId;
	private String description;
	private String difficulty;
	private String type;
	private String knowledge;
	private String topicBankName;
	private String answer;
	private String creator;

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** minimal constructor */
	public Topic(String description, String answer) {
		this.description = description;
		this.answer = answer;
	}

	/** full constructor */
	public Topic(Integer paperId, String description, String difficulty, String knowledge,
			String topicBankName, String answer, String creator) {
		this.paperId = paperId;
		this.description = description;
		this.difficulty = difficulty;
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

	public Integer getPaperId() {
		return this.paperId;
	}

	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
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

}
package com.gxuwz.Market.business.entity;

/**
 * Filltopic entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class FillTopic implements java.io.Serializable {

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
	private Integer topicBankId;
	// Constructors

	/** default constructor */
	public FillTopic() {
	}

	/** minimal constructor */
	public FillTopic(String description, String answer) {
		this.description = description;
		this.answer = answer;
	}

	/** full constructor */
	public FillTopic(Integer paperId, String description, String difficulty, String type, String knowledge,
			String topicBankName, String answer, String creator, Integer topicBankId) {
		super();
		this.paperId = paperId;
		this.description = description;
		this.difficulty = difficulty;
		this.type = type;
		this.knowledge = knowledge;
		this.topicBankName = topicBankName;
		this.answer = answer;
		this.creator = creator;
		this.topicBankId = topicBankId;
	}

	// Property accessors

	public FillTopic(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public Integer getTopicBankId() {
		return topicBankId;
	}

	public void setTopicBankId(Integer topicBankId) {
		this.topicBankId = topicBankId;
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
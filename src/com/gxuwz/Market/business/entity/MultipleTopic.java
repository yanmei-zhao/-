package com.gxuwz.Market.business.entity;



/**
 * Multipletopic entity. @author MyEclipse Persistence Tools
 */

public class MultipleTopic  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String description;
     private String difficulty;
     private String type;
     private String knowledge;
     private String topicBankName;
     private String optionA;
     private String optionB;
     private String optionC;
     private String optionD;
     private String optionE;
     private String answer;
     private String creator;
     private Integer topicBankId;

    // Constructors

    /** default constructor */
    public MultipleTopic() {
    }

    public MultipleTopic(int id) {
		this.id=id;
	}
    
    /** full constructor */
    public MultipleTopic(String description, String knowledge,String optionA, String optionB, String optionC, String optionD, String optionE, String answer,String difficulty, String type, String topicBankName,  String creator) {
        this.description = description;
        this.difficulty = difficulty;
        this.type = type;
        this.knowledge = knowledge;
        this.topicBankName = topicBankName;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.optionE = optionE;
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

    public String getOptionA() {
        return this.optionA;
    }
    
    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return this.optionB;
    }
    
    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return this.optionC;
    }
    
    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return this.optionD;
    }
    
    public void setOptionD(String optionD) {
        this.optionD = optionD;
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
		return topicBankId;
	}


	public void setTopicBankId(Integer topicBankId) {
		this.topicBankId = topicBankId;
	}

	public String getOptionE() {
		return optionE;
	}

	public void setOptionE(String optionE) {
		this.optionE = optionE;
	}

    
}
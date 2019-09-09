package com.gxuwz.Market.business.entity;



/**
 * Class entity. @author MyEclipse Persistence Tools
 */

public class Group  implements java.io.Serializable {

    // Fields    

     private Integer classId;
     private String className;
     private String grade;
     private String institute;
     private Integer studentNumber;


    // Constructors

    /** default constructor */
    public Group() {
    }

    
    /** full constructor */

    public Group( String className, String grade, String institute, Integer studentNumber) {
 		super();
 		this.className = className;
 		this.grade = grade;
 		this.institute = institute;
 		this.studentNumber = studentNumber;
 	}
    // Property accessors

    public Integer getClassId() {
        return this.classId;
    }
 
	public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return this.className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }

    public String getGrade() {
        return this.grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getInstitute() {
        return this.institute;
    }
    
    public void setInstitute(String institute) {
        this.institute = institute;
    }


	public Integer getStudentNumber() {
		return studentNumber;
	}


	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}

}
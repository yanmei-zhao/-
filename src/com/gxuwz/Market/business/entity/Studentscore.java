package com.gxuwz.Market.business.entity;

/**
 * 
 *<p>Title:Studentscore</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年2月3日下午8:32:44
 */
@SuppressWarnings("serial")
public class Studentscore implements java.io.Serializable{

	private String studentId;
	private String studentName;
	private String studentNumber;
	private String className;
	private String grade;
	private Integer score;
	private String examName;
	
	/** default constructor */
	public Studentscore() {
	}
	
	public Studentscore(String studentId, String studentName, String studentNumber, String className, String grade,
			Integer score, String examName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentNumber = studentNumber;
		this.className = className;
		this.grade = grade;
		this.score = score;
		this.examName = examName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}
	
}

package com.gxuwz.Market.business.entity;

@SuppressWarnings("serial")
public class ExamClass implements java.io.Serializable{
	private Integer id;
	private Integer examId;
	private Integer classId;
	
	public ExamClass() {
	}
	
	public ExamClass(Integer examId, Integer classId) {
		super();
		this.examId = examId;
		this.classId = classId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getExamId() {
		return examId;
	}
	public void setExamId(Integer examId) {
		this.examId = examId;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	
}

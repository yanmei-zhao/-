package com.gxuwz.Market.business.dao;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.client.fluent.Request;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

@Repository("examDAO")
public class ExamDAO extends BaseDaoImpl<Exam>{
	
	/**
	 * 根据条件查找分页
	 * @param SysRole 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Exam> find(Exam exam, int page, int row){
		String queryString="from Exam where 1=1";
		if(null !=exam.getExamId()){
			queryString = queryString +" and examId like '%"+exam.getExamId() +"%' ";
		}
		if(null != exam.getExamName()){
			queryString = queryString + " and examName like '%"+exam.getExamName()+"%'";
		}
		int start=(page-1)*row;
		int limit =row;
		return (Result<Exam>)super.find(queryString, null, null, start, limit);
	}
	
	/**
	 * 查询所有`
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Exam> getAllExam(){
		String queryString="from Exam where 1=1";
		return (List<Exam>) getHibernateTemplate().find(queryString);
	}
	
 	/**
	 * 查询所有试卷名称
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getTestpaperNameAll() {
		// TODO Auto-generated method stub
		String queryString="select testpaperName from Testpaper where 1=1";
	    return (List<String>) getHibernateTemplate().find(queryString);
	}
	
	/**
	 * 根据班级id查找所有考试1.10 学生端
	 */
	@SuppressWarnings("unchecked")
	public Result<Exam> findByclassId(Exam exam, int page, int row) {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
		int classId =  (int) session.getAttribute("classId");
		String examState="通过";
//		String queryString="from Exam where examState='"+examState+"' and className = '"+className+"' order by examStart desc,examId desc";
		String queryString="select distinct t0.examId ,t0.examName,DATE_FORMAT(t0.examStart, '%Y-%m-%d %k:%i:%s'),DATE_FORMAT(t0.examEnd, '%Y-%m-%d %k:%i:%s'),t0.examDuration from Exam t0,Student t1,ExamClass t2 where t0.examState='"+examState+"' and t1.classId = t2.classId and t2.examId = t0.examId and t1.classId="+classId;
		if(null !=exam.getExamId()){
			queryString = queryString +" and examId like '%"+exam.getExamId() +"%' "; 
		}
		if(null != exam.getExamName()){
			queryString = queryString + " and examName like '%"+exam.getExamName()+"%'";
		}
		int start=(page-1)*row;
		int limit =row;
		return (Result<Exam>)super.find(queryString, null, null, start, limit);
	}

	/**
	 * 根据试卷名称查找试卷信息1.10学生端
	 */
	public Testpaper findByTestpaperName(String examName) {
		// TODO Auto-generated method stub
		String queryString="from Testpaper where 1=1 and testpaperName = '"+examName+"'";
		return (Testpaper) this.getHibernateTemplate().find(queryString).get(0);
	}
	
//  /**
//  * 根据试卷名称查询试卷
//  * @param id
//  * @return
//  */
//	@SuppressWarnings("unchecked")
//  public Exam findById(String examName){
//		Exam exam = null;
//  	String queryString="from exam where 1=1 and exam_name ="+examName;
//  	List<Exam> list = (List<Exam>) this.getHibernateTemplate().find(queryString);
//		if(null != list && 0<list.size()){
//			exam = list.get(0);
//		}
//		return exam;
//  }
}

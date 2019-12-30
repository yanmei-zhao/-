package com.gxuwz.Market.business.dao;



import java.util.List;





import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.Exam;
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
	public List<Exam> getAllExam(){
		String queryString="from Exam where 1=1";
		return (List<Exam>) getHibernateTemplate().find(queryString);
	}
	
     /**
     * 根据试卷名称查询试卷
     * @param id
     * @return
     */
 	@SuppressWarnings("unchecked")
     public Exam findById(String examName){
 		Exam exam = null;
     	String queryString="from exam where 1=1 and exam_name ="+examName;
     	List<Exam> list = (List<Exam>) this.getHibernateTemplate().find(queryString);
 		if(null != list && 0<list.size()){
 			exam = list.get(0);
 		}
 		return exam;
     }
 	
 	/**
	 * 查询所有试卷名称
	 * @return
	 */
	public List<String> getTestpaperNameAll() {
		// TODO Auto-generated method stub
		String queryString="select testpaperName from Testpaper where 1=1";
	    return (List<String>) getHibernateTemplate().find(queryString);
	}

}

package com.gxuwz.Market.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

@Repository("studentManageDAO")
public class StudentManageDAO extends BaseDaoImpl<Student>{
	
	/**
	 * 
	 * @author zhouyiyuan
	 * @date 下午4:22:49
	 * @description 查询所有学生信息
	 */
	@SuppressWarnings("unchecked")
	public List<Student> findAllStudent(){
		String queryString="from Student where 1=1";
		
		return (List<Student>) this.getHibernateTemplate().find(queryString);
	}
	
	 /**
     * 根据studentid查询学生
     * @param id
     * @return
     */
 	@SuppressWarnings("unchecked")
     public Student findById(int studentId){
 		Student enContract = null;
     	String queryString="from Student where 1=1 and id ="+studentId;
     	List<Student> list = (List<Student>) this.getHibernateTemplate().find(queryString);
 		if(null != list && 0<list.size()){
 			enContract = list.get(0);
 		}
 		return enContract;
     }

	/**
	 * 分页模型
	 * @param EnContract
	 * @param page
	 * @param row
	 * @return
	 * @author lianliang
	 * @date 208-5-24
	 */
	@SuppressWarnings("unchecked")
	public Result<Student> find(Student student,int page, int row){
		String queryString = "from Student where 1=1";
		
		if(null !=student.getStudentId() && !"".equals(student.getStudentId() )){
			queryString = queryString +" and studentId like '%"+student.getStudentId() +"%' ";
		}
      
		if(null !=student.getStudentName() && !"".equals(student.getStudentName())){
			queryString = queryString +" and studentName like '%"+student.getStudentName()+"%' ";
		}
		
		int start=(page-1)*row;
		int limit =row;	
		return (Result<Student>)super.find(queryString, null, null, start, limit);
	}

}

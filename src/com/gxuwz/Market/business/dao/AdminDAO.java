package com.gxuwz.Market.business.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.Teacher;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

@Repository("glyDAO")
public class AdminDAO extends BaseDaoImpl<Testpaper> {
	/**
	 * 分页查找
	 * @param sysUser 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 * @author 李静
	 * @date 2018.07.23
	 */
	@SuppressWarnings("unchecked")
	public Result<Exam> find(Exam exam, int page, int size){
		String hql = "from Exam where examState=0";
		int start=(page-1)*size;
		int limit =size;
		return (Result<Exam> )super.find(hql, null, null, start, limit);
	}
	
	//审核通过（删除）
		
		public void update (Integer examId) {
			String hql = "update Exam set examState = 1  where examId= :examId";
			Session session = getHibernateTemplate().getSessionFactory().openSession();
			 Query query = session.createQuery(hql);
			   query.setInteger("examId", examId);
			   query.executeUpdate();
	    }
		public void update1 (Integer examId) {
			String hql = "update Exam set examState = 2  where examId= :examId";
			Session session = getHibernateTemplate().getSessionFactory().openSession();
			 Query query = session.createQuery(hql);
			   query.setInteger("examId", examId);
			   query.executeUpdate();
	    }
		
		/**
		 * 分页查找
		 * @param sysUser 模型
		 * @param page 第几页
		 * @param row 长度
		 * @return
		 * @author 李静
		 * @date 2018.07.23
		 */
		@SuppressWarnings("unchecked")
		public Result<Student> findStudent(Student student, int page, int size){
			String hql = "from Student where 1=1";
			int start=(page-1)*size;
			int limit =size;
			return (Result<Student> )super.find(hql, null, null, start, limit);
		}
		
		/**
		 * 分页查找
		 * @param sysUser 模型
		 * @param page 第几页
		 * @param row 长度
		 * @return
		 * @author 李静
		 * @date 2018.07.23
		 */
		@SuppressWarnings("unchecked")
		public Result<Teacher> findTeacher(Teacher teacher, int page, int size){
			String hql = "from Teacher where 1=1";
			int start=(page-1)*size;
			int limit =size;
			return (Result<Teacher> )super.find(hql, null, null, start, limit);
		}
		
		public void delete(Integer studentId){
			String hql = "delete from Student stu where stu.studentId='"+studentId+"'";
			this.getHibernateTemplate().bulkUpdate(hql);
			
		}
		
		public void delete1(Integer teacherId){
			String hql = "delete from Teacher tea where tea.teacherId='"+teacherId+"'";
			this.getHibernateTemplate().bulkUpdate(hql);
			
		}
		public Student find(Student student){
			String queryString = "from Student where 1=1";
			if(null != student.getStudentId()){
				queryString = queryString + " and studentId='"+student.getStudentId()+"'";
			}
			return (Student)this.getHibernateTemplate().find(queryString).get(0);
		}
		
		public void update(Student student) {
			getHibernateTemplate().update(student);
			}
		public void update(Teacher teacher) {
			getHibernateTemplate().update(teacher);
			}

		public Student findStudentByid(Integer studentId) {
			String sql="from Student stu where stu.studentId='"+studentId+"'";
			return (Student)this.getHibernateTemplate().find(sql).get(0);
			
			
			
		}
		@SuppressWarnings("unchecked")
		public Exam findExam(Integer examId) {
			String queryString = "from Exam where 1=1";
			
			if (null != examId) {
				
				queryString = queryString + " and examId='" + examId
						+ "'";
				
			}
			return (Exam) this.getHibernateTemplate().find(queryString).get(0);
			
		}
		/**
		 * 通过
		 * @param exam
		 * @param page
		 * @param size
		 * @return
		 */
		
		@SuppressWarnings("unchecked")
		public Result<Exam> find1(Exam exam, int page, int size){
			String hql = "from Exam where examState=1";
			int start=(page-1)*size;
			int limit =size;
			return (Result<Exam> )super.find(hql, null, null, start, limit);
		}
		
		/**
		 * 不通过
		 * @param exam
		 * @param page
		 * @param size
		 * @return
		 */
		
		@SuppressWarnings("unchecked")
		public Result<Exam> find2(Exam exam, int page, int size){
			String hql = "from Exam where examState=2";
			int start=(page-1)*size;
			int limit =size;
			return (Result<Exam> )super.find(hql, null, null, start, limit);
		}
		
		
		
		
		
		

}

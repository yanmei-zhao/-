package com.gxuwz.Market.business.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.StudentManageDAO;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.core.pagination.Result;


@Service("studentManageService")
public class StudentManageServiceImpl implements IStudentManageService {
	
	@Autowired
	private StudentManageDAO studentManageDao;
	
	/**
	 * 
	 * @author zhouyiyuan
	 * @date 下午4:40:22
	 * @description 查找所有学生信息
	 */
	@Override
	public List<Student> findAllStudent() {
		return studentManageDao.findAllStudent();
	}
	
	/**
	 * 
	 * @author zhouyiyuan
	 * @date 下午4:41:07
	 * @description 更新学生信息
	 */
	
	@Override
	public void add(Student student) {
		studentManageDao.save(student);
		
	}

	
	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * 
	 * @author zhouyiyuan
	 * @date 下午4:41:35
	 * @description  添加学生
	 */
	@Override
	public void add(List<Student> student) {
		// TODO Auto-generated method stub
		
	}	
		
    /**
     * 
     * @author ZYY
     * @date 上午11:19:30
     * @Descripton 保存集合
     */
	@Override
	public void addBatch(List<Student> list) {
		
		for (Student student : list) {
			studentManageDao.save(student);
		}
	}
	
	/**
	 * 
	 * @author zhouyiyuan
	 * @date 下午4:44:19
	 * @description 根据id删除学生
	 */
	@Override
	public void delete(int studentId) {
		studentManageDao.remove(findById(studentId));
	}
	
	/**
	 * 根据Id查询学生
	 * 
	 * @param id
	 * @return
	 * @author
	 * @date
	 */
	@Override
	public Student findById(int studentId) {

		return studentManageDao.get(Student.class, studentId);
		
	}
	

	
	/**
	 *  分页
	 * @param 
	 * @param page
	 * @param row
	 * @return
	 * @author lianliang
	 * @date 2018-5-24
	 */
	@Override
	public Result<Student> find(Student student, int page, int row){
		
		return studentManageDao.find(student, page, row);
		
	}

}

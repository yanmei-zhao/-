package com.gxuwz.Market.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.TeacherDAO;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.Teacher;
import com.gxuwz.core.pagination.Result;

/**
 * 
 *<p>Title:TeacherServiceImpl</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2019年1月24日下午5:32:49
 */
@Service("teacherService")
public class TeacherServiceImpl implements ITeacherService{
	@Autowired
	private TeacherDAO teacherDAO;
	@Override
	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 */
	public Result<Teacher> find(Teacher teacher, int page, int row) {
		// TODO Auto-generated method stub
		return teacherDAO.find(teacher, page, row);
	}
    /**
     * 添加教师
     */
	@Override
	public void add(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDAO.save(teacher);
	}
    /**
     * 根据id查询一条记录
     * @param id
     */
	@Override
	public Teacher findById(Integer teacherId) {
		// TODO Auto-generated method stub
		return teacherDAO.get(Teacher.class, teacherId);
	}
	/**
     * 根据name查询一条记录
     * @param name
     */
	@Override
	public Teacher findByName(String teacherName) {
		// TODO Auto-generated method stub
		return teacherDAO.get(Teacher.class,teacherName);
	}
   /**
    * 保存修改信息
    * @param teacher 
    */
	@Override
	public void update(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDAO.update(teacher);
	}
	/**
	 * 根据id删除一条记录
	 * @param id
	 */
	@Override
	public void delete(Integer teacherId) {
		// TODO Auto-generated method stub
		teacherDAO.remove(findById(teacherId));
	}
    /**
     * 查询所有信息
     */
	@Override
	public List<Teacher> getTeacherAll() {
		// TODO Auto-generated method stub
		return teacherDAO.getAllTeacher();
	}

	/**
	 * 验证教师编号是否重复
	 * @param teacherId 
	 */
	@Override
	public String checkTeacherId(Integer teacherId) {
		// TODO Auto-generated method stub
		Teacher teacher = teacherDAO.get(Teacher.class, teacherId);
		if(null != teacher){
			return "no";
		}else{
			return "ok";
		}
	}
	 /**
     * 
     * @date 上午11:19:30
     * @Descripton 保存集合
     */
	@Override
	public void addBatch(List<Teacher> list) {
		
		for (Teacher teacher : list) {
			teacherDAO.save(teacher);
		}
	}
}

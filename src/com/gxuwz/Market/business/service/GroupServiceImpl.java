package com.gxuwz.Market.business.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.GroupDAO;
import com.gxuwz.Market.business.entity.Group;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.Teacher;
import com.gxuwz.core.pagination.Result;
/**
 * 
 *<p>Title:ClassServiceImpl</p>
 *<p>Description:</p>
 * @author zhaoyanmei
 * @date 2019年1月26日下午11:32:00
 */
@Service("GroupService")
public class GroupServiceImpl implements IGroupService {

	@Autowired
	private GroupDAO classDAO;
	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 */

	@Override
	public Result<Group> find(Group group, int page, int row) {
		// TODO Auto-generated method stub
		return classDAO.find(group, page, row);
	}

	@Override
	public void add(Group group) {
		// TODO Auto-generated method stub
		classDAO.save(group);
	}

	@Override
	public Group findById(Integer classId) {
		// TODO Auto-generated method stub
		return classDAO.get(Group.class, classId);
	}

	@Override
	public Group findByName(String className) {
		// TODO Auto-generated method stub
		return classDAO.get(Group.class, className);
	}

	@Override
	public void update(Group group) {
		// TODO Auto-generated method stub
		classDAO.update(group);
	}

	@Override
	public void delete(Integer classId) {
		// TODO Auto-generated method stub
		classDAO.remove(findById(classId));
	}

	@Override
	public List<Group> getGroupAll() {
		// TODO Auto-generated method stub
		return classDAO.getAllGroup();
	}
	/**
	 * 查询所有学生班级信息
	 * @return
	 */
	@Override
	public List<String> getClassNameAll(){
		// TODO Auto-generated method stub	
		return classDAO.getAllClassName();
	}
	/**
	 * 批量添加班级信息
	 * @return
	 */
	@Override
	public void addBatch(List<Group> list) {
		// TODO Auto-generated method stub
		for (Group group : list) {
			classDAO.save(group);
		}
	}
	/**
	 * 查询所有符合班级id的学生个数
	 * @return
	 */
	@Override
	public int getAllStudentNum(Integer classId) {
		// TODO Auto-generated method stub
		return classDAO.getAllStudentNum(classId);
	}

	
}

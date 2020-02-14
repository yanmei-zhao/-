package com.gxuwz.Market.business.service;

import java.util.List;



import com.gxuwz.Market.business.entity.Exam;
import com.gxuwz.Market.business.entity.ExamClass;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.core.pagination.Result;
/**
 * 
* <p>Title: ExamService</p>     
* @author 小胜  
* @date 上午11:23:35
 */

public interface ExamService {
	/**
	 * 查询
	 * @param exam
	 */
	public Result<Exam> find(Exam exam, int page, int row);
	/**
	 * 添加
	* @Title: add      
	* @return void    返回类型   
	* @throws
	 */
	public void add(Exam exam);
	/**
	 * 查询
	* @Title: findById      
	* @return Exam    返回类型   
	* @throws
	 */

	public Exam findById(Integer examId);
    /**
     * 修改
    * @Title: update      
    * @return void    返回类型   
    * @throws
     */
	public void update(Exam exam);
	/**
	 * 删除
	* @Title: delete      
	* @return void    返回类型   
	* @throws
	 */
	public void delete(Integer examId);
	/**
	 * 查询所有
	* @Title: getExamAll      
	* @return List<Exam>    返回类型   
	* @throws
	 */
	public List<Exam> getExamAll();
	
	/**
	 * 查找所有试卷名称12.29.17.31
	 */
	public List<String> getTestpaperNameAll();
	
	/**
	 * 根据班级名称查找所有考试1.10
	 */
	public Result<Exam> findByclassName(Exam exam, int page, int row);
	
	/**
	 * 根据试卷名称查找所有试卷信息1.10
	 */
	public Testpaper findByTestpaperName(String examName);
	
	/**
	 * 批量添加考试对应的班级
	 * @param list
	 */
	public void addBatch(List<ExamClass> list);

}
   

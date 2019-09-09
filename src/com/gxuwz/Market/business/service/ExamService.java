package com.gxuwz.Market.business.service;

import java.util.List;



import com.gxuwz.Market.business.entity.Exam;
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

	
}
   

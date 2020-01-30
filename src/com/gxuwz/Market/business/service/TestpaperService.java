package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.entity.Examquestionanswer;
import com.gxuwz.Market.business.entity.FillTopic;
import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.TestPaperTopic;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.core.pagination.Result;

/**
 * 试卷业务处理
* <p>Title: TestpaperService</p>     
* @author 赵艳梅 
* @date 下午12:59:56
 */
public interface TestpaperService {
	/**
	 * 分页
	* @Title: find      
	* @return Result<Testpaper>    返回类型   
	* @throws
	 */
	public Result<Testpaper> find(Testpaper testpaper, int page, int row);
	/**
	 * 添加
	* @Title: add      
	* @return void    返回类型   
	* @throws
	 */
	public void add(Testpaper testpaper);
	/**
	 * 查询
	* @Title: findById      
	* @return Testpaper    返回类型   
	* @throws
	 */
	public Testpaper findById(Integer id);
	/**
	 * 更新保存
	* @Title: update      
	* @return void    返回类型   
	* @throws
	 */
	public void update(Testpaper testpaper);
	

	/**
	 * 删除
	* @Title: delete      
	* @return void    返回类型   
	* @throws
	 */
	public void delete(Integer id);
	/**
	 * 查询所有
	* @Title: getTestpaperAll      
	* @return List<Testpaper>    返回类型   
	* @throws
	 */
	public List<Testpaper> getTestpaperAll();
	/**
	 * 校验
	* @Title: checkTopicBankId      
	* @return String    返回类型   
	* @throws
	 */
	public String checkTestpaperId(Integer testpaperId);
	/**
	 * 查询所有试卷名称
	 * @return
	 */
	public List<String> getTestpaperNameAll();
	
	/**
	 * 查询试题编号
	 */
	public Result<Topic> getAllTopic(Integer testpaperId, int page, int row);
	public Result<ChoiceTopic> getAllChoiceTopic(Integer testpaperId, int page, int row);
	public Result<FillTopic> getAllFillTopic(Integer testpaperId, int page, int row);
	
	
}    
    

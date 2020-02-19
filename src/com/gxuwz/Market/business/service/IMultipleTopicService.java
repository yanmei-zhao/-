package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.MultipleTopic;
import com.gxuwz.core.pagination.Result;

/**
 * 
 *<p>Title:IMultipleTopicService</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年2月18日下午7:26:21
 */
public interface IMultipleTopicService {
	/**
	 * 根据条件查找分页
	 * @param Topic 
	 * @param page 第几页
	 * @param row 长度
	 */
	public Result<MultipleTopic> find(MultipleTopic multipleTopic, int page, int row);
	
	/**
	 * 添加试题
	 * @param sysRight
	 */
	public void add(MultipleTopic multipleTopic);
	
	/**
	 * 根据id查询一条记录
	 * @param id
	 * @return
	 */
	public MultipleTopic findById(int id);
	
	/**
	 * 保存修改权限信息
	 * @param sysRight
	 */
	public void update(MultipleTopic multipleTopic);
	
	/**
	 * 根据id删除一条记录
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 查询所有试题
	 * @return
	 */
	public List<MultipleTopic> getTopicAll();
	
	/**
	 * 查询所有题库信息 12.29 16.53
	 * @return
	 */
	public List<String> getTopicBankNameAll();
	

	/**
	 * 根据题库id查询试题列表
	 * @return
	 */
	public Result<MultipleTopic> getlistByTopicBankName(MultipleTopic multipleTopic, int page, int row,String topicBankName);
	
	/**
	 * 查询所有单选题的数量 12.29 16.53
	 * @return
	 */
	public int getAllMultipleTopicNum();

	/**
	 * 批量删除单选题
	 * @return
	 * @throws Exception
	 */
	public void deleteBatch(List<MultipleTopic> list);

	/**
	 * 批量导入单选题
	 * @param list
	 */
	public void addBatch(List<MultipleTopic> list);

	/**
	 * 练习选择题
	 * @param multipleTopic
	 * @param page1
	 * @param row1
	 * @return
	 */
	public Result<MultipleTopic> find1(String difficulty, String topicBankName, int page, int row1);
}

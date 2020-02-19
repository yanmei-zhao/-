package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.JudgeTopic;
import com.gxuwz.core.pagination.Result;

/**
 * 
 *<p>Title:IJudgeTopicService</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年2月18日下午7:26:16
 */
public interface IJudgeTopicService {
	/**
	 * 根据条件查找分页
	 * @param Topic 
	 * @param page 第几页
	 * @param row 长度
	 */
	public Result<JudgeTopic> find(JudgeTopic judgeTopic, int page, int row);
	
	/**
	 * 添加试题
	 * @param sysRight
	 */
	public void add(JudgeTopic judgeTopic);
	
	/**
	 * 根据id查询一条记录
	 * @param id
	 * @return
	 */
	public JudgeTopic findById(int id);
	
	/**
	 * 保存修改权限信息
	 * @param sysRight
	 */
	public void update(JudgeTopic judgeTopic);
	
	/**
	 * 根据id删除一条记录
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 查询所有试题
	 * @return
	 */
	public List<JudgeTopic> getTopicAll();
	
	/**
	 * 查询所有题库信息 12.29 16.53
	 * @return
	 */
	public List<String> getTopicBankNameAll();
	

	/**
	 * 根据题库id查询试题列表
	 * @return
	 */
	public Result<JudgeTopic> getlistByTopicBankName(JudgeTopic judgeTopic, int page, int row,String topicBankName);
	
	/**
	 * 查询所有单选题的数量 12.29 16.53
	 * @return
	 */
	public int getAllJudgeTopicNum();

	/**
	 * 批量删除单选题
	 * @return
	 * @throws Exception
	 */
	public void deleteBatch(List<JudgeTopic> list);

	/**
	 * 批量导入单选题
	 * @param list
	 */
	public void addBatch(List<JudgeTopic> list);

	/**
	 * 练习选择题
	 * @param JudgeTopic
	 * @param page1
	 * @param row1
	 * @return
	 */
	public Result<JudgeTopic> find1(String difficulty, String topicBankName, int page, int row1);
}

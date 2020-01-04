package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.FillTopic;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.core.pagination.Result;

/**
 *<p>Title:TopicService</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年1月3日下午7:24:55
 */
public interface TopicService {
	/**
	 * 根据条件查找分页
	 * @param Topic 
	 * @param page 第几页
	 * @param row 长度
	 */
	
	public Result<Topic> find(Topic topic, int page, int row);
	/**
	 * 添加权限
	 * @param sysRight
	 */
	public void add(Topic topic);
	
	/**
	 * 根据id查询一条记录
	 * @param id
	 * @return
	 */
	public Topic findById(int id);
	
	/**
	 * 保存修改权限信息
	 * @param sysRight
	 */
	public void update(Topic topic);
	
	/**
	 * 根据id删除一条记录
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 查询所有权限
	 * @return
	 */
	public List<Topic> getTopicAll();
	
	/**
	 * 验证权限编号是否重复
	 * @param rightId
	 * @return
	 */
	//public String checkRightId(String rightId);
	
	/**
	 * 查询所有题库信息 12.29 16.53
	 * @return
	 */
	public List<String> getTopicBankNameAll();
	
	/**
	 * 根据题库id查询试题列表
	 * @return
	 */
	public Result<Topic> getlistByTopicBankName(Topic topic, int page, int row,String topicBankName);
	
}

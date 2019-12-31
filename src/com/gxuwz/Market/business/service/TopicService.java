package com.gxuwz.Market.business.service;

import java.util.List;



import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.core.pagination.Result;

/**
 * <p>Title: 类名：权限-业务逻辑--接口</p>
 * <p>Description:mailsender-业务逻辑/n</p>
 * @author zym
 * @date 2019.8.10
 */
public interface TopicService {
	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 * @author zym
	 * @date 2019.8.10
	 */
	
	public Result<Topic> find(Topic topic, int page, int row);
	/**
	 * 添加权限
	 * @param sysRight
	  * @author zym
	 * @date 2019.8.10
	 */
	public void add(Topic topic);
	
	/**
	 * 根据id查询一条记录
	 * @param id
	 * @return
	 * @author zym
	 * @date 2019.8.10
	 */
	public Topic findById(int TopicId);
	
	/**
	 * 保存修改权限信息
	 * @param sysRight
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.8.10
	 */
	public void update(Topic topic);
	
	/**
	 * 根据id删除一条记录
	 * @param id
	 * @author zym
	 * @date 2019.8.10
	 */
	public void delete(Integer TopicId);
	
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

package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.FillTopic;
import com.gxuwz.core.pagination.Result;

public interface IFillTopicService {

	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 * @author zym
	 * @date 2019.8.10
	 */
	
	public Result<FillTopic> find(FillTopic fillTopic, int page, int row);
	/**
	 * 添加权限
	 * @param sysRight
	  * @author zym
	 * @date 2019.8.10
	 */
	public void add(FillTopic fillTopic);
	
	/**
	 * 根据id查询一条记录
	 * @param id
	 * @return
	 * @author zym
	 * @date 2019.8.10
	 */
	public FillTopic findById(int topicId);
	
	/**
	 * 保存修改权限信息
	 * @param sysRight
	 * @author zym
	 * @date 2019.8.10
	 */
	public void update(FillTopic fillTopic);
	
	/**
	 * 根据id删除一条记录
	 * @param id
	 * @author zym
	 * @date 2019.8.10
	 */
	public void delete(Integer topicId);
	
	/**
	 * 查询所有权限
	 * @return
	 */
	public List<FillTopic> getTopicAll();
	
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
	public Result<FillTopic> getlistByTopicBankName(FillTopic fillTopic, int page, int row,String topicBankName);
	
}
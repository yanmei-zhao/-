package com.gxuwz.Market.business.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.TopicDAO;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.core.pagination.Result;

/**
 * <p>Title: 类名：权限-业务逻辑--实现</p>
 * <p>Description:mailsender-业务逻辑/n</p>
 * @author:	卢善坚，汪嘉惠
 * @date:2015.07.31
 */
@Service("topicService")
public class TopicServiceImpl implements TopicService {
	@Autowired
	private TopicDAO topicDAO;
	
	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.8.10
	 */
	public Result<Topic> find(Topic topic, int page, int row) {
		
		return topicDAO.find(topic, page, row);
	}


	/**
	 * 添加权限
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.8.10
	 */
	@Override
	public void add(Topic topic) {
		topicDAO.save(topic);
		
	}

	/**
	 * 根据id查询一条记录
	 * @param idfpp
	 * @return
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.8.10
	 */
	@Override
	public Topic findById(int topicId) {
		
		return topicDAO.get(Topic.class, topicId);
	}

	/**
	 * 保存修改权限信息
	 * @param sysRight 
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.8.10
	 */
	@Override
	public void update(Topic topic) {
		topicDAO.update(topic);
	}

	/**
	 * 根据id删除一条记录
	 * @param id
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.8.10
	 */
	@Override
	public void delete(Integer topicId) {
		topicDAO.delete(topicId);
		
	}

	/**
	 * 查询所有试题
	 * @return
	 */
	@Override
	public List<Topic> getTopicAll() {
		return topicDAO.getAllTopic();
	}

	/**
	 * 查询所有题库信息 12.29 16.53
	 * @return
	 */
	@Override
	public List<String> getTopicBankNameAll() {
		// TODO Auto-generated method stub
		return topicDAO.getTopicBankNameAll();
	}
	
	
	
	
}

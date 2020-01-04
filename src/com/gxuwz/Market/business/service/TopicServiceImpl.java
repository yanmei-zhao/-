package com.gxuwz.Market.business.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.TopicDAO;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.core.pagination.Result;

/**
 *<p>Title:TopicServiceImpl</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年1月3日下午7:26:32
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
	 */
	public Result<Topic> find(Topic topic, int page, int row) {
		return topicDAO.find(topic, page, row);
	}


	/**
	 * 添加试题
	 */
	@Override
	public void add(Topic topic) {
		topicDAO.save(topic);
	}
	
	/**
	 * 根据id查询一条记录
	 * @param id
	 */
	@Override
	public Topic findById(int id) {
		return topicDAO.get(Topic.class, id);
	}

	/**
	 * 保存修改试题信息
	 * @param sysRight 
	 */
	@Override
	public void update(Topic topic) {
		topicDAO.update(topic);
	}

	/**
	 * 根据id删除一条记录
	 * @param id
	 */
	@Override
	public void delete(Integer id) {
		topicDAO.delete(id);
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
	
	/**
	 * 根据题库id查询试题列表
	 * @return
	 */
	public Result<Topic> getlistByTopicBankName(Topic topic, int page, int row, String topicBankName) {
		// TODO Auto-generated method stub
		return topicDAO.getlistByTopicBankName(topic, page, row, topicBankName);
	}
}

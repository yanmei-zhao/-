package com.gxuwz.Market.business.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.TopicDAO;
import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.entity.FillTopic;
import com.gxuwz.Market.business.entity.Group;
import com.gxuwz.Market.business.entity.JudgeTopic;
import com.gxuwz.Market.business.entity.MultipleTopic;
import com.gxuwz.Market.business.entity.Testpaper;
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
	 * 查询所有单选题库信息 12.29 16.53
	 * @return
	 */
	@Override
	public List<String> getChoiceTopicBankNameAll() {
		// TODO Auto-generated method stub
		return topicDAO.getChoiceTopicBankNameAll();
	}
	
	/**
	 * 查询所有填空题库信息 12.29 16.53
	 * @return
	 */
	@Override
	public List<String> getFillTopicBankNameAll() {
		// TODO Auto-generated method stub
		return topicDAO.getFillTopicBankNameAll();
	}

	/**
	 * 查询所有简答题库信息 12.29 16.53
	 * @return
	 */
	@Override
	public List<String> getTopicBankNameAll() {
		// TODO Auto-generated method stub
		return topicDAO.getTopicBankNameAll();
	}
	
	/**
	 * 查询所有判断题库信息 12.29 16.53
	 * @return
	 */
	@Override
	public List<String> getJudgeTopicBankNameAll() {
		// TODO Auto-generated method stub
		return topicDAO.getJudgeTopicBankNameAll();
	}

	/**
	 * 查询所有多选题库信息 12.29 16.53
	 * @return
	 */
	@Override
	public List<String> getMultipleTopicBankNameAll() {
		// TODO Auto-generated method stub
		return topicDAO.getMultipleTopicBankNameAll();
	}
	
	/**
	 * 根据题库id查询单选试题列表
	 * @return
	 */
	public Result<ChoiceTopic> getChoicelistByTopicBankId(ChoiceTopic choiceTopic, int page, int row, int topicBankId) {
		// TODO Auto-generated method stub
		return topicDAO.getChoicelistByTopicBankId(choiceTopic, page, row, topicBankId);
	}
	
	/**
	 * 根据题库id查询填空试题列表
	 * @return
	 */
	public Result<FillTopic> getFilllistByTopicBankId(FillTopic fillTopic, int page, int row, int topicBankId) {
		// TODO Auto-generated method stub
		return topicDAO.getFilllistByTopicBankId(fillTopic, page, row, topicBankId);
	}
	
	/**
	 * 根据题库id查询简答试题列表
	 * @return
	 */
	public Result<Topic> getlistByTopicBankId(Topic topic, int page, int row, int topicBankId) {
		// TODO Auto-generated method stub
		return topicDAO.getlistByTopicBankId(topic, page, row, topicBankId);
	}

	/**
	 * 批量添加试题
	 * @return
	 */
	@Override
	public void addBatch(List<Topic> list) {
		// TODO Auto-generated method stub
		for (Topic topic : list) {
			topicDAO.save(topic);
		}
	}

	/**
	 * 随机组卷1
	 * @param testpaper
	 * @param topicTypes
	 * @param topicBankName
	 * @param TopicDegree
	 * @param topicNum
	 * @param topicScores
	 */
	@Override
	public void composeTopicRandom(Testpaper testpaper, String topicTypes, String topicBankName, String difficulty,int topicNum, int topicScores) {
		// TODO Auto-generated method stub
		topicDAO.composeTopicRandom(testpaper, topicTypes, topicBankName, difficulty,topicNum,  topicScores);
	}

	/**
	 * 查询所有简答题的数量 12.29 16.53
	 * @return
	 */
	@Override
	public int getAllTopicNum() {
		// TODO Auto-generated method stub
		return topicDAO.getAllTopicNum();
	}

	/**
	 * 批量删除简答题
	 * @return
	 * @throws Exception
	 */
	@Override
	public void deleteBatch(List<Topic> list) {
		// TODO Auto-generated method stub
		for(Topic topic : list){
			int id = topic.getId();
			topicDAO.remove(findById(id));
		}
	}

	/**
	 * 练习简答题
	 * @return
	 * @throws Exception
	 */
	@Override
	public Result<Topic> find1(String difficulty, String topicBankName, int page, int row1) {
		// TODO Auto-generated method stub
		return topicDAO.find1(difficulty,topicBankName, page, row1);
	}

	/**
	 * 根据题库id查询多选题列表
	 * @param topic
	 * @param page
	 * @param row
	 * @param topicBankName
	 * @return
	 */
	@Override
	public Result<MultipleTopic> getMultiplelistByTopicBankId(MultipleTopic multipleTopic, int page, int row, int topicBankId) {
		// TODO Auto-generated method stub
		return topicDAO.getMultiplelistByTopicBankId(multipleTopic, page, row, topicBankId);
	}

	/**
	 * 根据题库id查询判断题列表
	 * @param topic
	 * @param page
	 * @param row
	 * @param topicBankName
	 * @return
	 */
	@Override
	public Result<JudgeTopic> getJudgelistByTopicBankId(JudgeTopic judgeTopic, int page, int row, int topicBankId) {
		// TODO Auto-generated method stub
		return topicDAO.getJudgelistByTopicBankId(judgeTopic, page, row, topicBankId);
	}

}

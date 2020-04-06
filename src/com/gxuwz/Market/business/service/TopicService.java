package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.entity.FillTopic;
import com.gxuwz.Market.business.entity.Group;
import com.gxuwz.Market.business.entity.JudgeTopic;
import com.gxuwz.Market.business.entity.MultipleTopic;
import com.gxuwz.Market.business.entity.Testpaper;
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
	 * 添加试题
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
	 * 查询所有试题
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
	 * 查询所有选择题库信息 12.29 16.53
	 * @return
	 */
	public List<String> getChoiceTopicBankNameAll();
	
	/**
	 * 查询所有填空题库信息 12.29 16.53
	 * @return
	 */
	public List<String> getFillTopicBankNameAll();

	/**
	 * 查询所有简答题库信息 12.29 16.53
	 * @return
	 */
	public List<String> getTopicBankNameAll();
	
	/**
	 * 查询所有判断题库信息 12.29 16.53
	 * @return
	 */
	public List<String> getJudgeTopicBankNameAll();
	
	/**
	 * 查询所有多选题库信息 12.29 16.53
	 * @return
	 */
	public List<String> getMultipleTopicBankNameAll();
	
	/**
	 * 根据题库id查询单选题列表
	 * @param choiceTopic
	 * @param page
	 * @param row
	 * @param topicBankId
	 * @return
	 */
	public Result<ChoiceTopic> getChoicelistByTopicBankId(ChoiceTopic choiceTopic, int page, int row,int topicBankId);
	
	/**
	 * 根据题库id查询填空题列表
	 * @param fillTopic
	 * @param page
	 * @param row
	 * @param topicBankId
	 * @return
	 */
	public Result<FillTopic> getFilllistByTopicBankId(FillTopic fillTopic, int page, int row,int topicBankId);
	
	/**
	 * 根据题库id查询简答题列表
	 * @param topic
	 * @param page
	 * @param row
	 * @param topicBankName
	 * @return
	 */
	public Result<Topic> getlistByTopicBankId(Topic topic, int page, int row,int topicBankId);
	
	/**
	 * 根据题库id查询多选题列表
	 * @param topic
	 * @param page
	 * @param row
	 * @param topicBankName
	 * @return
	 */
	public Result<MultipleTopic> getMultiplelistByTopicBankId(MultipleTopic multipleTopic, int page, int row,int topicBankId);
	
	/**
	 * 根据题库id查询多选题列表
	 * @param topic
	 * @param page
	 * @param row
	 * @param topicBankName
	 * @return
	 */
	public Result<JudgeTopic> getJudgelistByTopicBankId(JudgeTopic judgeTopic, int page, int row,int topicBankId);
	
	/**
	 * 批量添加试题
	 * @return
	 */
	 public void addBatch(List<Topic> list);

	/**
	 * 随机组卷1
	 * @param testpaper
	 * @param topicTypes
	 * @param topicBankName
	 * @param TopicDegree
	 * @param topicNum
	 * @param topicScores
	 */
	public void composeTopicRandom(Testpaper testpaper,String topicTypes,String topicBankName,String difficulty, int topicNum,int topicScores);
	
	/**
	 * 查询所有简答题的数量 12.29 16.53
	 * @return
	 */
	public int getAllTopicNum();

	/**
	 * 批量删除简答题
	 * @return
	 * @throws Exception
	 */
	public void deleteBatch(List<Topic> list);

	/**
	 * 练习简答题
	 * @return
	 * @throws Exception
	 */
	public Result<Topic> find1(String difficulty, String topicBankName, String way,int page, int row1);
}

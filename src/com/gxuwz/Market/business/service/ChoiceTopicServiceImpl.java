package com.gxuwz.Market.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.ChoiceTopicDAO;
import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.core.pagination.Result;

/**
 *<p>Title:ChoiceServiceImpl</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年1月4日下午5:01:18
 */
@Service("choiceTopicService")
public class ChoiceTopicServiceImpl implements IChoiceTopicService{
	@Autowired
	private ChoiceTopicDAO choiceTopicDAO;

	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@Override
	public Result<ChoiceTopic> find(ChoiceTopic choiceTopic, int page, int row) {
		// TODO Auto-generated method stub
		return choiceTopicDAO.find(choiceTopic, page, row);
	}

	/**
	 * 添加试题
	 */
	@Override
	public void add(ChoiceTopic choiceTopic) {
		// TODO Auto-generated method stub
		choiceTopicDAO.save(choiceTopic);
	}

	/**
	 * 根据id查询一条记录
	 */
	@Override
	public ChoiceTopic findById(int id) {
		// TODO Auto-generated method stub
		return choiceTopicDAO.get(ChoiceTopic.class, id);
	}

	/**
	 * 更新一条试题
	 */
	@Override
	public void update(ChoiceTopic choiceTopic) {
		// TODO Auto-generated method stub
		choiceTopicDAO.update(choiceTopic);
	}

	/**
	 * 删除试题
	 */
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		choiceTopicDAO.delete(id);
	}

	/**
	 * 查询所有试题
	 * @return
	 */
	@Override
	public List<ChoiceTopic> getTopicAll() {
		// TODO Auto-generated method stub
		return choiceTopicDAO.getAllTopic();
	}

	/**
	 * 查询所有题库信息 12.29 16.53
	 * @return
	 */
	@Override
	public List<String> getTopicBankNameAll() {
		// TODO Auto-generated method stub
		return choiceTopicDAO.getTopicBankNameAll();
	}

	/**
	 * 根据题库id查询试题列表
	 * @return
	 */
	@Override
	public Result<ChoiceTopic> getlistByTopicBankName(ChoiceTopic choiceTopic, int page, int row,
			String topicBankName) {
		// TODO Auto-generated method stub
		return choiceTopicDAO.getlistByTopicBankName(choiceTopic, page, row, topicBankName);
	}

	/**
	 * 查询所有单选题的数量 12.29 16.53
	 * @return
	 */
	@Override
	public int getAllChoiceTopicNum() {
		// TODO Auto-generated method stub
		return choiceTopicDAO.getAllChoiceTopicNum();
	}

	/**
	 * 批量删除单选题
	 * @return
	 * @throws Exception
	 */
	@Override
	public void deleteBatch(List<ChoiceTopic> list) {
		// TODO Auto-generated method stub
		for(ChoiceTopic choiceTopic : list){
			int id = choiceTopic.getId();
			choiceTopicDAO.remove(findById(id));
		}
	}

	/**
	 * 批量导入单选题
	 * @param list
	 */
	@Override
	public void addBatch(List<ChoiceTopic> list) {
		// TODO Auto-generated method stub
		for (ChoiceTopic choicetopic : list) {
			choiceTopicDAO.save(choicetopic);
		}
	}

	/**
	 * 练习选择题
	 * @param choiceTopic
	 * @param page1
	 * @param row1
	 * @return
	 */
	@Override
	public Result<ChoiceTopic> find1(String difficulty, String topicBankName,String way, int page, int row1) {
		// TODO Auto-generated method stub
		return choiceTopicDAO.find1(difficulty,topicBankName,way, page, row1);
	}

}

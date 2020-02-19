package com.gxuwz.Market.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.ChoiceTopicDAO;
import com.gxuwz.Market.business.dao.JudgeTopicDAO;
import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.entity.JudgeTopic;
import com.gxuwz.core.pagination.Result;

/**
 * 
 *<p>Title:JudgeTopicServiceImpl</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年2月18日下午7:29:50
 */
@Service("judgeTopicService")
public class JudgeTopicServiceImpl implements IJudgeTopicService{
	@Autowired
	private JudgeTopicDAO judgeTopicDAO;
	
	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@Override
	public Result<JudgeTopic> find(JudgeTopic judgeTopic, int page, int row) {
		// TODO Auto-generated method stub
		return judgeTopicDAO.find(judgeTopic, page, row);
	}

	/**
	 * 添加试题
	 */
	@Override
	public void add(JudgeTopic judgeTopic) {
		// TODO Auto-generated method stub
		judgeTopicDAO.save(judgeTopic);
	}

	/**
	 * 根据id查询一条记录
	 */
	@Override
	public JudgeTopic findById(int id) {
		// TODO Auto-generated method stub
		return judgeTopicDAO.get(JudgeTopic.class, id);
	}

	/**
	 * 更新试题
	 */
	@Override
	public void update(JudgeTopic judgeTopic) {
		// TODO Auto-generated method stub
		judgeTopicDAO.update(judgeTopic);
	}

	/**
	 * 删除试题
	 */
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		judgeTopicDAO.remove(findById(id));
	}

	/**
	 * 查询所有试题
	 * @return
	 */
	@Override
	public List<JudgeTopic> getTopicAll() {
		// TODO Auto-generated method stub
		return judgeTopicDAO.getAllTopic();
	}

	/**
	 * 查询所有题库信息 12.29 16.53
	 * @return
	 */
	@Override
	public List<String> getTopicBankNameAll() {
		// TODO Auto-generated method stub
		return judgeTopicDAO.getTopicBankNameAll();
	}

	/**
	 * 根据题库id查询试题列表
	 * @return
	 */
	@Override
	public Result<JudgeTopic> getlistByTopicBankName(JudgeTopic judgeTopic, int page, int row, String topicBankName) {
		// TODO Auto-generated method stub
		return judgeTopicDAO.getlistByTopicBankName(judgeTopic, page, row, topicBankName);
	}

	/**
	 * 查询所有判断题的数量 12.29 16.53
	 * @return
	 */
	@Override
	public int getAllJudgeTopicNum() {
		// TODO Auto-generated method stub
		return judgeTopicDAO.getAllChoiceTopicNum();
	}

	/**
	 * 批量删除判断题
	 * @return
	 * @throws Exception
	 */
	@Override
	public void deleteBatch(List<JudgeTopic> list) {
		// TODO Auto-generated method stub
		for(JudgeTopic judgeTopic : list){
			int id = judgeTopic.getId();
			judgeTopicDAO.remove(findById(id));
		}
	}

	/**
	 * 批量导入判断题
	 * @param list
	 */
	@Override
	public void addBatch(List<JudgeTopic> list) {
		// TODO Auto-generated method stub
		for (JudgeTopic judgeTopic : list) {
			judgeTopicDAO.save(judgeTopic);
		}
	}

	/**
	 * 练习判断题
	 * @param choiceTopic
	 * @param page1
	 * @param row1
	 * @return
	 */
	@Override
	public Result<JudgeTopic> find1(String difficulty, String topicBankName, int page, int row1) {
		// TODO Auto-generated method stub
		return judgeTopicDAO.find1(difficulty, topicBankName, page, row1);
	}

}

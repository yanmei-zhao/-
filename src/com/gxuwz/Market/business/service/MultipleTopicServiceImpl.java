package com.gxuwz.Market.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.ChoiceTopicDAO;
import com.gxuwz.Market.business.dao.MultipleTopicDAO;
import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.entity.JudgeTopic;
import com.gxuwz.Market.business.entity.MultipleTopic;
import com.gxuwz.core.pagination.Result;

/**
 * 
 *<p>Title:MultipleTopicServiceImpl</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年2月18日下午7:30:04
 */
@Service("multipleTopicService")
public class MultipleTopicServiceImpl implements IMultipleTopicService{
	@Autowired
	private MultipleTopicDAO multipleTopicDAO;

	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@Override
	public Result<MultipleTopic> find(MultipleTopic multipleTopic, int page, int row) {
		// TODO Auto-generated method stub
		return multipleTopicDAO.find(multipleTopic, page, row);
	}

	/**
	 * 添加试题
	 */
	@Override
	public void add(MultipleTopic multipleTopic) {
		// TODO Auto-generated method stub
		multipleTopicDAO.save(multipleTopic);
	}

	/**
	 * 根据id查询一条记录
	 */
	@Override
	public MultipleTopic findById(int id) {
		// TODO Auto-generated method stub
		return multipleTopicDAO.get(MultipleTopic.class, id);
	}

	/**
	 * 更新试题
	 */
	@Override
	public void update(MultipleTopic multipleTopic) {
		// TODO Auto-generated method stub
		multipleTopicDAO.update(multipleTopic);
	}

	/**
	 * 删除试题
	 */
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		multipleTopicDAO.remove(findById(id));
	}

	/**
	 * 查询所有试题
	 */
	@Override
	public List<MultipleTopic> getTopicAll() {
		// TODO Auto-generated method stub
		return multipleTopicDAO.getAllTopic();
	}

	/**
	 * 查询所有题库信息
	 */
	@Override
	public List<String> getTopicBankNameAll() {
		// TODO Auto-generated method stub
		return multipleTopicDAO.getTopicBankNameAll();
	}

	/**
	 * 根据题库id查询试题列表
	 * @return
	 */
	@Override
	public Result<MultipleTopic> getlistByTopicBankName(MultipleTopic multipleTopic, int page, int row,
			String topicBankName) {
		// TODO Auto-generated method stub
		return multipleTopicDAO.getlistByTopicBankName(multipleTopic, page, row, topicBankName);
	}

	/**
	 * 查询所有多选题的数量 12.29 16.53
	 * @return
	 */
	@Override
	public int getAllMultipleTopicNum() {
		// TODO Auto-generated method stub
		return multipleTopicDAO.getAllMultipleTopicNum();
	}

	/**
	 * 批量删除多选题
	 * @return
	 * @throws Exception
	 */
	@Override
	public void deleteBatch(List<MultipleTopic> list) {
		// TODO Auto-generated method stub
		for(MultipleTopic multipleTopic : list){
			int id = multipleTopic.getId();
			multipleTopicDAO.remove(findById(id));
		}
	}

	/**
	 * 批量导入多选题
	 * @param list
	 */
	@Override
	public void addBatch(List<MultipleTopic> list) {
		// TODO Auto-generated method stub
		for (MultipleTopic multipleTopic : list) {
			multipleTopicDAO.save(multipleTopic);
		}
	}
	
	/**
	 * 练习多选题
	 * @param choiceTopic
	 * @param page1
	 * @param row1
	 * @return
	 */
	@Override
	public Result<MultipleTopic> find1(String difficulty, String topicBankName, String way,int page, int row1) {
		// TODO Auto-generated method stub
		return multipleTopicDAO.find1(difficulty, topicBankName,way, page, row1);
	}

}

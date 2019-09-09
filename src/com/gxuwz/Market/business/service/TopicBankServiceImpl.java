package com.gxuwz.Market.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.TopicBankDAO;
import com.gxuwz.Market.business.entity.TopicBank;
import com.gxuwz.core.pagination.Result;
/**
 * 
 *<p>Title:TopicBankServiceImpl</p>
 *<p>Description:题库接口实现类</p>
 * @author 赵艳梅
 * @date 2019年1月21日下午12:24:31
 */
@Service("topicbankService")
public class TopicBankServiceImpl implements ITopicBankService {
	@Autowired
	private TopicBankDAO topicBankDAO;
	@Override
	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 */
	public Result<TopicBank> find(TopicBank topicBank, int page, int row) {
		// TODO Auto-generated method stub
		return topicBankDAO.find(topicBank, page, row);
	}
    /**
     * 添加题库
     */
	@Override
	public void add(TopicBank topicBank) {
		// TODO Auto-generated method stub
		topicBankDAO.save(topicBank);
	}
    /**
     * 根据id查询一条记录
     * @param id
     */
	@Override
	public TopicBank findById(Integer topicBankId) {
		// TODO Auto-generated method stub
		return topicBankDAO.get(TopicBank.class, topicBankId);
	}
	/**
     * 根据name查询一条记录
     * @param name
     */
	@Override
	public TopicBank findByName(String topicBankName) {
		// TODO Auto-generated method stub
		return topicBankDAO.get(TopicBank.class,topicBankName);
	}
   /**
    * 保存修改信息
    * @param topicBank 
    */
	@Override
	public void update(TopicBank topicBank) {
		// TODO Auto-generated method stub
		topicBankDAO.update(topicBank);
	}
	/**
	 * 根据id删除一条记录
	 * @param id
	 */
	@Override
	public void delete(Integer topicBankId) {
		// TODO Auto-generated method stub
		topicBankDAO.remove(findById(topicBankId));
	}
    /**
     * 查询所有题库
     */
	@Override
	public List<TopicBank> getTopicBankAll() {
		// TODO Auto-generated method stub
		return topicBankDAO.getAllTopicBank();
	}

	/**
	 * 验证题库编号是否重复
	 * @param topicBankId 题库编号
	 */
	@Override
	public String checkTopicBankId(Integer topicBankId) {
		// TODO Auto-generated method stub
		TopicBank topicBank = topicBankDAO.get(TopicBank.class, topicBankId);
		if(null != topicBank){
			return "no";
		}else{
			return "ok";
		}
	}
	/**
	 * 查询所有题库名称
	 */
	@Override
	public List<String> gettopicBankNameAll() {
		// TODO Auto-generated method stub
		return topicBankDAO.gettopicBankNameAll();
	}
	
	/**
	 * 二级联动查询题库名称
	 * @return
	 */
	@Override
	public List<String> gettopicBankName() {
		// TODO Auto-generated method stub
		return topicBankDAO.gettopicBankNameAll();
	}
	
}

package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.Student;
import com.gxuwz.Market.business.entity.ChoiceTopic;
import com.gxuwz.Market.business.entity.TopicBank;
import com.gxuwz.core.pagination.Result;

/**
 * 
 *<p>Title:ITopicBankService</p>
 *<p>Description:题库接口</p>
 * @author 赵艳梅
 * @date 2019年1月21日下午12:14:37
 */
public interface ITopicBankService {

	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 */
	public Result<TopicBank> find(TopicBank topicBank, int page, int row);
	
	/**
	 * 添加新题库
	 * @param sysMerchantUnit 模型
	 */
	public void add(TopicBank topicBank);
	
	/**
	 * 根据id查询一条记录
	 * @param id
	 */
	public TopicBank findById(Integer topicBankId);
	
	/**
	 * name查询一条记录
	 * @param name
	 */
	public TopicBank findByName(String topicBankName);
	
	/**
	 * 保存修改权限信息
	 * @param sysRight
	 */
	public void update(TopicBank topicBank);
	
	/**
	 * 根据id删除一条记录
	 * @param id
	 */
	public void delete(Integer topicBankId);
	
	/**
	 * 查询所有题库
	 * @return
	 */
	public List<TopicBank> getTopicBankAll();
	
	/**
	 * 验证题库编号是否重复
	 * @param topicBankId
	 * @return
	 */
	public String checkTopicBankId(Integer topicBankId);
	
	/**
	 * 查询所有题库信息
	 * @return
	 */
	public List<String> gettopicBankNameAll();
	
	/**
	 * 二级联动查询题库名称
	 * @param courseName 
	 * @return
	 */
	public List<String> gettopicBankName();
	
	/**
	 * 查询所有符合题库id的试题数量12.30 13.48
	 * @return
	 */
	public int getAllTopicNum(int topicBankId);

	/**
	 * 查询题库数量
	 * @return
	 */
	public int getAlltopicBankNum();
	
}

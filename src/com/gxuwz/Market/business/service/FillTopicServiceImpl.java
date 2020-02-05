package com.gxuwz.Market.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.FillTopicDAO;
import com.gxuwz.Market.business.entity.FillTopic;
import com.gxuwz.core.pagination.Result;

/**
 * <p>Title: 类名：填空题-业务逻辑--实现</p>
 * <p>Description:mailsender-业务逻辑/n</p>
 * @author:	zym
 * @date:2019.8.10
 */
@Service("fillTopicService")
public class FillTopicServiceImpl implements IFillTopicService{
	@Autowired
	private FillTopicDAO fillTopicDAO;
	
	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 * @author zym
	 * @date 2019.8.10
	 */
	@Override
	public Result<FillTopic> find(FillTopic fillTopic, int page, int row) {
		// TODO Auto-generated method stub
		return fillTopicDAO.find(fillTopic, page, row);
	}

	/**
	 * 添加试题
	 * @author zym
	 * @date 2019.8.10
	 */
	@Override
	public void add(FillTopic fillTopic) {
		// TODO Auto-generated method stub
		fillTopicDAO.save(fillTopic);
	}

	/**
	 * 根据id查询一条记录
	 * @param idfpp
	 * @return
	 * @author zym
	 * @date 2019.8.10
	 */
	@Override
	public FillTopic findById(int id) {
		// TODO Auto-generated method stub
		return fillTopicDAO.get(FillTopic.class, id);
	}

	/**
	 * 保存修改试题信息
	 * @param sysRight 
	 * @author zym
	 * @date 2019.8.10
	 */
	@Override
	public void update(FillTopic fillTopic) {
		// TODO Auto-generated method stub
		fillTopicDAO.update(fillTopic);
	}

	/**
	 * 根据id删除一条记录
	 * @param id
	 * @author zym
	 * @date 2019.8.10
	 */
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		fillTopicDAO.delete(id);
	}

	/**
	 * 查询所有试题
	 * @return
	 */
	@Override
	public List<FillTopic> getTopicAll() {
		// TODO Auto-generated method stub
		return fillTopicDAO.getAllTopic();
	}

	/**
	 * 查询所有题库信息 12.29 16.53
	 * @return
	 */
	@Override
	public List<String> getTopicBankNameAll() {
		// TODO Auto-generated method stub
		return fillTopicDAO.getTopicBankNameAll();
	}

	/**
	 * 根据题库id查询试题列表
	 * @return
	 */
	@Override
	public Result<FillTopic> getlistByTopicBankName(FillTopic fillTopic, int page, int row, String topicBankName) {
		// TODO Auto-generated method stub
		return fillTopicDAO.getlistByTopicBankName(fillTopic, page, row, topicBankName);
	}

	/**
	 * 查询所有填空题的数量 12.29 16.53
	 * @return
	 */
	@Override
	public int getAllFillTopicNum() {
		// TODO Auto-generated method stub
		return fillTopicDAO.getAllFillTopicNum();
	}

	/**
	 * 批量删除填空题
	 * @return
	 * @throws Exception
	 */
	@Override
	public void deleteBatch(List<FillTopic> list) {
		// TODO Auto-generated method stub
		for(FillTopic fillTopic : list){
			int id = fillTopic.getId();
			fillTopicDAO.remove(findById(id));
		}
	}

}

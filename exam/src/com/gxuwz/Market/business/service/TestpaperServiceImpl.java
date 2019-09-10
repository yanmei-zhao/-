package com.gxuwz.Market.business.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.Market.business.dao.TestpaperDAO;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.Market.business.entity.TopicBank;
import com.gxuwz.core.pagination.Result;

/**
 * 试卷业务实现
* <p>Title: TestpaperServiceImpl</p>     
* @author 小胜  
* @date 下午1:07:49
 */
@Service("testpaperService")
public class TestpaperServiceImpl implements TestpaperService {
	@Autowired
	private TestpaperDAO testpaperDAO;
	
	/**
	 * 分页
	 */
	public Result<Testpaper> find(Testpaper testpaper, int page, int row) {
		
		return testpaperDAO.find(testpaper, page, row);
	}


	/**
	 * 添加
	 */
	@Override
	public void add(Testpaper testpaper) {
		System.out.println(testpaper.getTestpaperName());
		System.out.println(testpaper.getTestpaperId());
		//System.out.println("11111111");
		testpaperDAO.save(testpaper);
		
	}

	/**
	 * 查询
	 */
	@Override
	public Testpaper findById(Integer id) {
		
		return testpaperDAO.get(Testpaper.class, id);
	}

	/**
	 * 更新保存
	 */
	@Override
	public void update(Testpaper testpaper) {
		//System.out.println(testpaper.getTestpaperId()+"1111111");
		testpaperDAO.update(testpaper);
	}	
	/**
	 *删除
	 */
    @Override
	public void delete(Integer id) {
		testpaperDAO.remove(findById(id));
		
	}

	/**
	 * 查询所有
	 */
	@Override
	public List<Testpaper> getTestpaperAll() {
		return testpaperDAO.getAllTestpaper();
	}
	/**
	 * 验证
	* @Title: checkTestpaperId      
	* @return String    返回类型   
	* @throws
	 */
	@Override
	public String checkTestpaperId(Integer testpaperId) {
		// TODO Auto-generated method stub
		Testpaper testpaper = testpaperDAO.get(Testpaper.class, testpaperId);
		if(null != testpaper){
			return "no";
		}else{
			return "ok";
		}
	}

/**
 * 查询所有试卷名称
 */
	@Override
	public List<String> getTestpaperNameAll() {
		// TODO Auto-generated method stub
		return testpaperDAO.getTestpaperNameAll();
	}
	@Override
	public List<String> getAllTopicId(Integer testpaperId){
		return testpaperDAO.getAllTopicId(testpaperId);
	};
}

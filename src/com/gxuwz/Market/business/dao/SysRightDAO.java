package com.gxuwz.Market.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxuwz.Market.business.entity.SysRight;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

@Repository("sysRightDAO")
public class SysRightDAO extends BaseDaoImpl<SysRight>{
	
	/**
	 * 根据条件查找分页
	 * @param SysRole 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<SysRight> find(SysRight sysRight, int page, int row){
		String queryString="from SysRight where 1=1";
		if(null != sysRight.getRightName()){
			queryString = queryString + " and rightName like '%"+sysRight.getRightName()+"%'";
		}
		int start=(page-1)*row;
		int limit =row;
		return (Result<SysRight>)super.find(queryString, null, null, start, limit);
	}
	/**
	 * 升序查询所有权限
	 * @return
	 */
	public List<SysRight> getAllRight(){
		String queryString="from SysRight where 1=1";
		return (List<SysRight>) getHibernateTemplate().find(queryString);
	}
}

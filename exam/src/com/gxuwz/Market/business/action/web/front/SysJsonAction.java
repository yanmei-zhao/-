package com.gxuwz.Market.business.action.web.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.gxuwz.Market.business.entity.SysRight;
import com.gxuwz.Market.business.service.ISysRightService;
import com.gxuwz.Market.business.service.ITopicBankService;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * <p>Title: 类名：（系统设置相关）使用Json数据表的形式，返回数据</p>
 * <p>Description:控制器/n</p>
 * @author:	梧州学院 软件开发中心  卢善坚，汪嘉惠  <a href=mailto:116861519@qq.com>庞光垚 </a>
 * @date:2015.07.31
 */
@SuppressWarnings({ "serial", "unchecked", "rawtypes" })
public class SysJsonAction extends BaseAction implements Preparable{

	private static final long serialVersionUID = -4104125263890869018L;
	
	@Autowired
	private ITopicBankService topicBankService;
	@Autowired
	private ISysRightService sysRightService;
	
	private String checkName;//用户输入的要校验名字
	private Integer checkId;//用户输入的要校验Id
	private String rawPassword;
	public void prepare() throws Exception {
		
	}

	/**
	 * 验证题库编号是否有重复
	 * @return
	 * @throws IOException
	 */
	public String checkTopicBankId() throws IOException{
		String check = topicBankService.checkTopicBankId(checkId);
		Gson gson = new Gson();
		String json = gson.toJson(check);
		PrintWriter writer = getPrintWriter();
		writer.write(json);
		writer.flush();
		writer.close();
		return null;
	}
	/**
	 * 验证权限编号是否有重复
	 * @return
	 * @throws IOException
	 */
	public String checkRightName() throws IOException{
		String check = sysRightService.checkRightId(checkName);
		Gson gson = new Gson();
		String json = gson.toJson(check);
		PrintWriter writer = getPrintWriter();
		writer.write(json);
		writer.flush();
		writer.close();
		return null;
	}
	
	public String getCheckName() {
		return checkName;
	}
	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public Integer getCheckId() {
		return checkId;
	}

	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}
	
}

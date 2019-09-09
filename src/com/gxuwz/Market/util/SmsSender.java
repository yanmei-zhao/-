package com.gxuwz.Market.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import util.SMSApi;

import com.bcloud.msg.http.HttpSender;

/**
 * 短信发送：接口中转。负责把内部信息发送到外部短信接口
 * <p>Description:mailsender-业务逻辑/n</p>
 * @author:庞光垚
 * @date:2015.08.10
 *
 */
public class SmsSender {
	
	/**
	 * 将一个字符串以逗号分割
	 * @param returnString
	 * @return 返回分割后的一个数组
	 */
	public String[] StringSplit(String returnString){
		return returnString.split(",");
	}
	
	/**
	 * 发送短信，并且返回状态
	 * @param mobiles 手机号码。多个号码使用","分割。
	 * @param content 短信内容
	 * @return Object类型，长度三个。第一：响应时间；第二：状态，0是成功，其他很多（略）；第三：msgid，批次代码
	 */
	public Object[] sendSMS(String mobiles,String content){
		Object[] temO = new Object[3];

		String uri = SMSApi.getApi_url();//应用地址
		String account = SMSApi.getApi_account();//账号
		String pswd = SMSApi.getApi_pswd();//密码
		boolean needstatus = true;//是否需要状态报告，需要true，不需要false
		String product = null;//产品ID
		String extno = null;//扩展码
		 
		try {
			String returnString = HttpSender.batchSend(uri, account, pswd, mobiles, content, needstatus, product, extno);
			//分析出返回而结果，存入temO
			if(null != returnString){
				String[] resultSplit = StringSplit(returnString);
				temO[0] = resultSplit[0].trim();
				temO[1] = resultSplit[1].substring(0,1).trim();
				temO[2] = resultSplit[1].substring(1,resultSplit[1].length()-1).trim();
			}else{
				temO = null;
			}
			
			//TODO 处理返回值,参见HTTP协议文档
		} catch (Exception e) {
			//TODO 处理异常
			e.printStackTrace();
		}
		return temO;
	}
	
	
	
	
	/**
	 * 手机短信验证码，生成随机的四位数
	 * @return result
	 * @author 潘恒飞
	 * @date 2015.09.21
	 */
	public String randomNumber(){
		String[] randomNumber = new String[] {"1","2","3","4","5","6","7","8","9","0"};  
	     List list = Arrays.asList(randomNumber);  
	     Collections.shuffle(list);  
	     StringBuilder sb = new StringBuilder();  
	     for (int i = 0; i < list.size(); i++) {  
	         sb.append(list.get(i));  
	     }  
	     String afterShuffle = sb.toString();  
	     String result = afterShuffle.substring(3,7);
	     return result;
	}
}

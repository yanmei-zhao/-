package com.gxuwz.Market.util; 

import java.util.Enumeration;
import java.util.PropertyResourceBundle;

/**
 * Created by 赖绍辉  on 2018/5/10.
 * 配置python 接口 IP 和  端口号
 */
public class Constant {
	
	private final static String fileName = "CrawlerServerApi";
	
	private static String WechatSogouURL = "";
	private static String WechatSogouPORT = "";

    public static final String serverUrl = Constant.getWechatSogouURL();
    public static final String serverPort = Constant.getWechatSogouPORT();

	
    static {
		config();
	}
    
    
    private static void config() {
		// 读取系统配置
		PropertyResourceBundle resourceBundle = (PropertyResourceBundle) PropertyResourceBundle
				.getBundle(fileName);
		// 将系统设置赋值给类变量
		Enumeration<?> enu = resourceBundle.getKeys();
		while (enu.hasMoreElements()) {
			String propertyName = enu.nextElement().toString();
			if (propertyName.equals("WechatSogouURL")){
				WechatSogouURL = resourceBundle.getString("WechatSogouURL");
			}
			if (propertyName.equals("WechatSogouPORT")){
				WechatSogouPORT = resourceBundle.getString("WechatSogouPORT");
			}
			
		}

	}


	public static String getWechatSogouURL() {
		return WechatSogouURL;
	}


	public static void setWechatSogouURL(String wechatSogouURL) {
		WechatSogouURL = wechatSogouURL;
	}


	public static String getWechatSogouPORT() {
		return WechatSogouPORT;
	}


	public static void setWechatSogouPORT(String wechatSogouPORT) {
		WechatSogouPORT = wechatSogouPORT;
	}
    
    
    
    
	
}

package com.gxuwz.Market;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import util.MyTime;

/**
 * 全局常量配置
 * @author Mr.xucb
 * @version 1.0
 */
public final class SystemContext {
	public static final Integer DEFUALT_PAGE_SIZE=12;//默认分页数,Result有一个BUG，
	public static final Integer DEFUALT_PAGE_NUM=1;//默认分页码

	public static final String ACTION_CONTENT_TYPE="application/json;charset=utf-8";//默认传输编码，注意utf-8
	
	public static final int TIME_INTERVAL_MSG = 900;//单位，秒。2次发送短信的时间间隔不能少于900秒
	
	public static final String QRCODE_SPKEY = "MeiYou8652492_GuiLv7896y";//
	
	private static final String SITE_WIDE_SECRET = "GXUWZ_0774_KEY";  
	private static final PasswordEncoder encoder = new StandardPasswordEncoder(SITE_WIDE_SECRET); 
	
	/**
	 * 密码加密
	 * @param rawPasswd 需要加密的密码
	 * @return
	 */
	public static String passwdEncryption(String rawPasswd){
		//System.out.println("rawPasswd="+rawPasswd);
		String str = encoder.encode(rawPasswd);
		return str;
	}

	/**
	 * 密码校验
	 * @param rawPassword 明文密码（需要匹配的用户输入的那份）
	 * @param password 数据库保存的加密的密码
	 * @return true = 通过，fasle=失败
	 */
	public static boolean passwdDecryption(String rawPasswd, String password){
//		System.out.println("rawPasswd="+rawPasswd);
//		System.out.println("password="+password);
		boolean isT = false;
		try {
			isT = encoder.matches(rawPasswd, password);
			//isT = encoder.matches("123",passwdEncryption("123"));
			//System.out.println("密码匹配--完毕"+isT);
		} catch (Exception e) {
			System.out.println("密码匹配："+e);
		}
		return isT;
	}
	
	
	/**
	 * 拼凑短信发送内容	
	 */
	public String sendContext(){
		return "您的验证码：";
	}

	public static String encodeDownloadFilename(String filename, String agent) {
		// TODO Auto-generated method stub
		return null;
	}
}

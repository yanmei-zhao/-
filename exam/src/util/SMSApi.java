package util;

import java.util.Enumeration;
import java.util.PropertyResourceBundle;

public class SMSApi {
	
	private final static String fileName = "SMSApi";
	private static String api_url = "";//api.uri
	private static String api_account = "";//api.account
	private static String api_pswd = "";//api.pswd
	
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
			if (propertyName.equals("api.uri")){
				api_url = resourceBundle.getString("api.uri");
			}
			if (propertyName.equals("api.account")){
				api_account = resourceBundle.getString("api.account");
			}
			if (propertyName.equals("api.pswd")){
				api_pswd = resourceBundle.getString("api.pswd");
			}
		}

	}

	public static String getApi_url() {
		return api_url;
	}

	public static void setApi_url(String api_url) {
		SMSApi.api_url = api_url;
	}

	public static String getApi_account() {
		return api_account;
	}

	public static void setApi_account(String api_account) {
		SMSApi.api_account = api_account;
	}

	public static String getApi_pswd() {
		return api_pswd;
	}

	public static void setApi_pswd(String api_pswd) {
		SMSApi.api_pswd = api_pswd;
	}

	public static String getFilename() {
		return fileName;
	}
	
}

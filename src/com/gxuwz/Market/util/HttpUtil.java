package com.gxuwz.Market.util;

import java.io.*;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.net.ssl.HttpsURLConnection;

public class HttpUtil {

	// User-Agent
	public static final String USERAGENT_FIREFOX = "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:39.0) Gecko/20100101 Firefox/39.0";  
	public static final String USERAGENT_IE = "Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; rv:11.0) like Gecko";  
	
	private CloseableHttpClient httpClient;

	private BasicCookieStore cookieStore;
	private HttpGet get;
	private HttpPost post;

    public static StringBuffer httpsRequest(String requestUrl, String requestMethod, String output) throws IOException {
        URL url = new URL(requestUrl);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestMethod(requestMethod);
        if (null != output) {
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(output.getBytes("UTF-8"));
            outputStream.close();
        }
        // 从输入流读取返回内容
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = null;
        StringBuffer buffer = new StringBuffer();
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        inputStream = null;
        connection.disconnect();
        return buffer;
    }

	
	public HttpResult doGet(String url, Map<String, String> headers, Map<String, String> params) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, ClientProtocolException, IOException {

		if (url == null|| url.equals("")) {
			return null;
		}

		SSLContextBuilder builder = new SSLContextBuilder();
		builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
		cookieStore = new BasicCookieStore();
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore)
				.setSSLSocketFactory(sslsf).build();

		HttpResult result = null;
		try {

			url = url + "?" + parseParams(params);
			HttpGet httpget = new HttpGet(url);
			httpget.setHeaders(parseHeader(headers));

			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				HttpEntity entity = response.getEntity();

				if (entity != null) {
					result = new HttpResult();
					result.setCookies(cookieStore.getCookies());
					result.setStatusCode(response.getStatusLine().getStatusCode());
					result.setHeaders(response.getAllHeaders());
					result.setBody(EntityUtils.toString(entity));
				}

			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}

		return result;
		
	}

	public HttpResult doPost(String url, Map<String, String> headers, Map<String, String> postData, String encoding) throws Exception {

		if (url == null|| url.equals("")) {
			return null;
		}
		if (encoding == null|| encoding.equals("")) {
			encoding = "utf-8";
		}
		
		SSLContextBuilder builder = new SSLContextBuilder();
		builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
		cookieStore = new BasicCookieStore();
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore)
				.setSSLSocketFactory(sslsf).build();

		post = new HttpPost(url);
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		for (String tmp : postData.keySet()) {
			list.add(new BasicNameValuePair(tmp, postData.get(tmp)));
		}
		post.setEntity(new UrlEncodedFormEntity(list, encoding));
		post.setHeaders(parseHeader(headers));

		CloseableHttpResponse response = httpClient.execute(post);
		HttpEntity entity = response.getEntity();

		HttpResult result = new HttpResult();
		result.setCookies(cookieStore.getCookies());
		result.setStatusCode(response.getStatusLine().getStatusCode());
		result.setHeaders(response.getAllHeaders());
		result.setBody(EntityUtils.toString(entity, encoding));

		close(entity, response);

		return result;
	}

	private String parseParams(Map<String, String> params) {
		if (params == null || params.isEmpty()) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		for (String key : params.keySet()) {
			sb.append(key + "=" + params.get(key) + "&");
		}
		return sb.substring(0, sb.length() - 1);

	}

	private Header[] parseHeader(Map<String, String> headers) {
		if (headers == null || headers.isEmpty()) {
			return getDefaultHeaders();
		}

		Header[] retHeader = new BasicHeader[headers.size()];
		int i = 0;
		for (String str : headers.keySet()) {
			retHeader[i++] = new BasicHeader(str, headers.get(str));
		}
		return retHeader;
	}

	private Header[] getDefaultHeaders() {
		Header[] headers = new BasicHeader[3];
		headers[0] = new BasicHeader("User-Agent", USERAGENT_IE);
		headers[1] = new BasicHeader("Accept-Encoding", "gzip, deflate");
		headers[2] = new BasicHeader("Accept-Language", "en-US,en;q=0.8,zh-Hans-CN;q=0.5,zh-Hans;q=0.3");
		return headers;
	}

	private void close(HttpEntity entity, CloseableHttpResponse response) {
		try {
			if (entity != null) {
				InputStream input = entity.getContent();
				input.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
	}

	
	/**
	 * 下载文件
	 * @param url 下载文件的链接
	 * @param destFile 包含路径的目标文件名
	 * @param headers 请求头
	 * @return 
	 */
	public HttpResult downloadFile(String url, String destFile, Map<String, String> headers) throws Exception {
		
		SSLContextBuilder builder = new SSLContextBuilder();
		builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
		BasicCookieStore cookieStore = new BasicCookieStore();
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).setSSLSocketFactory(sslsf).build();
		
		HttpGet get = new HttpGet(url);
		get.setHeaders(parseHeader(headers));
		InputStream input = null;
		CloseableHttpResponse response = null;
		HttpResult result = null;
		
		try {
			response = httpclient.execute(get);
			HttpEntity entity = response.getEntity();
			input = entity.getContent();
			File file = new File(destFile);
			
			FileOutputStream fos = new FileOutputStream(file);
			int len = -1;
			byte[] tmp = new byte[1024];
			while((len=input.read(tmp)) != -1) {
				fos.write(tmp, 0, len);
			}
			fos.flush();
			fos.close();
			
			result = new HttpResult();
			result.setCookies(cookieStore.getCookies());
			result.setStatusCode(response.getStatusLine().getStatusCode());
			result.setHeaders(response.getAllHeaders());
			result.setBody(EntityUtils.toString(entity, Consts.UTF_8));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(input != null) {
					input.close();
				}
				if(response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	/**
     * json 字符串
     * @param url
     * @param param
     * @return
     */
    public static String getHTTP(String url,String param){
      /* 1 生成 HttpClinet 对象并设置参数 */
        HttpClient httpClient = new HttpClient();
        // 设置 Http 连接超时为5秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
      /* 2 生成 GetMethod 对象并设置参数 */
        GetMethod getMethod = new GetMethod(url);
        // 设置 get 请求超时为 5 秒
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
        // 设置请求重试处理，用的是默认的重试处理：请求三次
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        String response = "";
      /* 3 执行 HTTP GET 请求 */
        try {
            int statusCode = httpClient.executeMethod(getMethod);
         /* 4 判断访问的状态码 */
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("请求出错: "+ getMethod.getStatusLine());
            }
         /* 5 处理 HTTP 响应内容 */
            // HTTP响应头部信息，这里简单打印
            org.apache.commons.httpclient.Header[] headers = getMethod.getResponseHeaders();
            for (org.apache.commons.httpclient.Header h : headers)
                System.out.println(h.getName() + "------------ " + h.getValue());
            // 读取 HTTP 响应内容，这里简单打印网页内容
            byte[] responseBody = getMethod.getResponseBody();// 读取为字节数组
            response = new String(responseBody, param);
            System.out.println("----------response:" + response);
            // 读取为 InputStream，在网页内容数据量大时候推荐使用
            // InputStream response = getMethod.getResponseBodyAsStream();
        } catch (HttpException e) {
            // 发生致命的异常，可能是协议不对或者返回的内容有问题
            System.out.println("请检查输入的URL!");
            e.printStackTrace();
        } catch (IOException e) {
            // 发生网络异常
            System.out.println("发生网络异常!");
            e.printStackTrace();
        } finally {
         /* 6 .释放连接 */
            getMethod.releaseConnection();
        }
        return response;
    }
    /**
     * post请求
     * @param url
     * @param json
     * @return  JSONObject
     */
    public static JSONObject doPost(String url,JSONObject json){
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        JSONObject response = null;
        try {
            StringEntity s = new StringEntity(json.toString());
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            HttpResponse res = client.execute(post);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = res.getEntity();
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                response = JSONObject.fromObject(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
    
    //测试post 请求  和  get 请求
    public static void main(String[] args) {
//    	String url = "http://localhost:8080/wzinfo/Crawler/openXinwenCrawler?param=1";
//    	String url = "http://117.141.244.6:8822/getclassify";
//    	String param = "title=15岁天才少女花滑夺金 女单新时代中国依旧掉队";
    	String url = "http://117.141.244.6:8822/getclassify";
    	
    	
    	 //get 请求
//         String ret = getHTTP(url, param);
//         System.out.println("get 请求接收回的参数："+ret);
    	
    	HttpUtil httpUtil = new HttpUtil();
    	try {
    		Map<String, String> param = new HashMap<String, String>();
    		param.put("title", "15岁天才少女花滑夺金女单新时代中国依旧掉队");
    		
    		HttpResult httpResult = httpUtil.doGet(url, null, param);

			if (httpResult.getStatusCode() == 200) {
//				JsonParser jsonParser = new JsonParser();
//				JsonObject obj = (JsonObject) jsonParser.parse(httpResult
//						.getBody());
				System.out.println("getReturn: " + httpResult.getBody());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
	}
	
	
	

}

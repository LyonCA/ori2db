package com.c2uol.base.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.c2uol.base.constants.NetworkConstants;

/**
 * 
 * @描述: 网络连接工具
 * @作者: Lyon
 * @版本: v1.0
 * @时间: 2017年7月26日上午12:23:08
 *
 */
public class HttpClient {

	private HttpClient() {

	}

	Logger logger = LogManager.getLogger(HttpClient.class);

	private static HttpClient httpClient;

	Pattern http_pattern = Pattern.compile(NetworkConstants.HTTP_CONN_URL_REGEX);

	Pattern https_pattern = Pattern.compile(NetworkConstants.HTTPS_CONN_URL_REGEX);

	/**
	 * 
	 * @描述: 本地模式网络连接
	 * @参数: @return
	 * @返回值: NetworkKit
	 * @版本: v1.0
	 * @时间: 2017年7月26日上午12:26:34
	 *
	 */
	public static HttpClient newInstance() {
		if (httpClient == null) {
			httpClient = new HttpClient();
		}
		return httpClient;
	}

	/**
	 * 
	 * @描述: http请求
	 * @参数: @param path
	 * @参数: @return
	 * @返回值: byte[]
	 * @版本: v1.0
	 * @时间: 2017年7月26日上午12:44:33
	 *
	 */
	public byte[] httpUrlConnection(String path, String method, String content, Map<String, String> requestProperty, int readTimeout, int connTimeout) {
		logger.info("http connection:" + path);
		Matcher matcher = http_pattern.matcher((path == null ? "" : path));
		if (!matcher.find()) {
			logger.error("url error!");
			return null;
		}
		URL url = null;
		HttpURLConnection conn = null;
		try {
			url = new URL(path);
			conn = (HttpURLConnection) url.openConnection();

			/* 检查连接超时时间与读取超时时间 */
			if (readTimeout <= 0) {
				readTimeout = 10000;
			}
			if (connTimeout <= 0) {
				connTimeout = 10000;
			}
			conn.setReadTimeout(readTimeout);
			conn.setConnectTimeout(connTimeout);

			/* 配置请求头 */
			if (requestProperty != null && requestProperty.size() > 0) {
				for (Iterator<Entry<String, String>> iterator = requestProperty.entrySet().iterator(); iterator.hasNext();) {
					Entry<String, String> entry = iterator.next();
					conn.setRequestProperty(entry.getKey(), entry.getValue());
				}
			}

			/* 检查请求方式 */
			if (StringUtil.isEmpty(method) || (!NetworkConstants.GET.equals(method) && !method.equals(NetworkConstants.POST))) {
				method = NetworkConstants.GET;
			}
			conn.setRequestMethod(method);
			conn.setDoInput(true);
			conn.setDoOutput(true);

			/* 如果是post请求，并且请求全文不是空，写入数据 */
			if (NetworkConstants.POST.equals(method) && !StringUtil.isEmpty(content)) {
				OutputStream out = conn.getOutputStream();
				out.write(content.getBytes());
				out.flush();
				out.close();
			}

			int responseCode = conn.getResponseCode();
			logger.info("[√] url connection response code:{}", responseCode);
			int len = conn.getContentLength();
			logger.info("[√] response content length:{}", len);
			InputStream in = conn.getInputStream();
			byte[] data = IOUtils.toByteArray(in);
			in.close();
			conn.disconnect();
			return data;
		} catch (MalformedURLException e) {
			logger.error("[x] url error! [url:{}]", path, e);
			return null;
		} catch (IOException e) {
			logger.error("connection error! [url:{}]", path, e);
			return null;
		}
	}
}

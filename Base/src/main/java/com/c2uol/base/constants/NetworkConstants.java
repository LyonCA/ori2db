package com.c2uol.base.constants;

/**
 * 
 * @描述: 网络连接工具常量
 * @作者: Lyon
 * @版本: v1.0
 * @时间: 2017年7月26日上午12:30:08
 *
 */
public class NetworkConstants {
	private NetworkConstants() {

	}

	/**
	 * POST 请求
	 */
	public static final String POST = "POST";

	/**
	 * GET 请求
	 */
	public static final String GET = "GET";

	/**
	 * delete 请求
	 */
	public static final String DELETE = "DELETE";

	/**
	 * put 请求
	 */
	public static final String PUT = "PUT";

	/**
	 * http请求url过滤规则
	 */
	public static final String HTTP_CONN_URL_REGEX = "^(http:\\/\\/www\\.|http:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$";

	/**
	 * https请求url过滤规则
	 */
	public static final String HTTPS_CONN_URL_REGEX = "^(https:\\/\\/www\\.|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$";
}

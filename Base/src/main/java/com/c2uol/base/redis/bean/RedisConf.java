package com.c2uol.base.redis.bean;

/**
 * 
 * @描述: redis 配置对象
 * @作者: Lyon
 * @版本: v1.0
 * @时间: 2017年7月26日下午10:02:40
 *
 */
public class RedisConf {

	private String addr;
	private int port;
	private String auth;
	private int max_active;
	private int max_idle;
	private int max_wait;
	private int timeout;
	private boolean test_on_borrow;

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public int getMax_active() {
		return max_active;
	}

	public void setMax_active(int max_active) {
		this.max_active = max_active;
	}

	public int getMax_idle() {
		return max_idle;
	}

	public void setMax_idle(int max_idle) {
		this.max_idle = max_idle;
	}

	public int getMax_wait() {
		return max_wait;
	}

	public void setMax_wait(int max_wait) {
		this.max_wait = max_wait;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public boolean isTest_on_borrow() {
		return test_on_borrow;
	}

	public void setTest_on_borrow(boolean test_on_borrow) {
		this.test_on_borrow = test_on_borrow;
	}
}

package com.c2uol.base.utils;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 
 * @描述: redis 数据连接池
 * @作者: Lyon
 * @版本: v1.0
 * @时间: 2017年7月27日下午10:53:44
 *
 */
@Repository
public class RedisSourcePool {

	private Logger logger = LogManager.getLogger(RedisSourcePool.class);

	@Resource
	public Map<String, JedisPool> jedisPoolMap;

	/**
	 * 
	 * @描述: 获取数据源
	 * @参数: @param redisPoolKey
	 * @参数: @return
	 * @返回值: Jedis
	 * @版本: v1.0
	 * @时间: 2017年7月27日下午11:03:45
	 *
	 */
	public Jedis getResrouce(String redisPoolKey) throws NullPointerException {
		if (StringValidate.isEmpty(redisPoolKey)) {
			logger.error("获取数据源失败！数据源key为空！");
			return null;
		}
		if (!jedisPoolMap.containsKey(redisPoolKey)) {
			logger.error("获取数据源失败！数据源{}不存在！", redisPoolKey);
			return null;
		}
		logger.debug("获取key为{}的数据源开始！", redisPoolKey);
		Jedis jedis = null;
		try {
			jedis = jedisPoolMap.get(redisPoolKey).getResource();
		} catch (Exception e) {
			logger.error("从数据源{}获取连接对象异常！", redisPoolKey, e);
		}

		if (jedis != null) {
			logger.debug("从{}获取到连接对象成功！", redisPoolKey);
		} else {
			logger.error("从{}获取到连接对象失败！", redisPoolKey);
		}
		return jedis;
	}
}
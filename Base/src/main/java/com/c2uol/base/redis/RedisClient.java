package com.c2uol.base.redis;

import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.c2uol.base.utils.RedisSourcePool;
import redis.clients.jedis.Jedis;

/**
 * 
 * @描述: redis 客户端
 * @作者: Lyon
 * @版本: v1.0
 * @时间: 2017年7月28日上午2:23:52
 *
 */
@Repository
public class RedisClient {

	private Logger logger = LogManager.getLogger(RedisClient.class);

	@Resource
	RedisSourcePool redisSourcePool;

	public RedisClient() {

	}

	private Jedis jedis = null;

	/**
	 * 
	 * @描述: redis get
	 * @参数: @param key
	 * @参数: @return
	 * @返回值: String
	 * @版本: v1.0
	 * @时间: 2017年7月28日上午2:35:05
	 *
	 */
	public String get(String key) {
		try {
			return jedis.get(key);
		} catch (Exception e) {
			logger.error("", e);
		} finally {
			jedis.close();
		}
		return null;
	}
}

package com.c2uol.base.redis;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.c2uol.base.utils.RedisSourcePool;

import redis.clients.jedis.Jedis;

@Repository
public class RedisClient {

	@Resource
	RedisSourcePool redisSourcePool;

	public RedisClient() {

	}

	private Jedis jedis = null;

	public RedisClient(String database, int db_number) {
		jedis = redisSourcePool.getResrouce(database);
		if (db_number > 0) {
			jedis.select(db_number);
		} else {
			jedis.select(0);
		}
	}

	public String get(String key) {
		try {
			return jedis.get(key);
		} catch (Exception e) {

		} finally {
			jedis.close();
		}
		return null;
	}

}

package com.c2uol.base.utils;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.c2uol.base.redis.RedisClient;

import redis.clients.jedis.Jedis;

public class RedisSourcePoolTester {

	ApplicationContext applicationContext;

	@Before
	public void init() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	// @Test
	public void testerGetConnection() {
		RedisSourcePool redisSourcePool = applicationContext.getBean("redisSourcePool", RedisSourcePool.class);
		Jedis jedis = redisSourcePool.getResrouce("jedisPool_default");
		jedis.select(0);
		jedis.set("tester", "hello world");
		jedis.close();
	}

	@Test
	public void testerRedisClient() {
		RedisClient redisClient = applicationContext.getBean("redisClient", RedisClient.class);
		String data = redisClient.get("tester");
		System.out.println(data);
	}
}

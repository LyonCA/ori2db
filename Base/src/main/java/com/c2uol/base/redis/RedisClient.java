package com.c2uol.base.redis;

import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.c2uol.base.redis.exception.RedisClientException;
import com.c2uol.base.utils.RedisSourcePool;
import com.c2uol.base.utils.StringValidate;

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
@Scope(value = "prototype")
public class RedisClient {

    private Logger logger = LogManager.getLogger(RedisClient.class);

    @Resource
    RedisSourcePool redisSourcePool;

    public RedisClient(String db_name, int node) {

    }

    private String db_name;
    private int node;

    /**
     * 
     * @描述: 配置使用的库以及使用的节点
     * @参数: @param db_name
     * @参数: @param node
     * @返回值: void
     * @版本: v1.0
     * @时间: 2017年7月29日上午12:41:50
     *
     */
    public void conf(String db_name, int node) {
        this.db_name = db_name;
        this.node = node;
    }

    private void validate() {
        if (db_name == null) {
            new RedisClientException("database name not is null.");
        }
        jedis = redisSourcePool.getResrouce(db_name);
        if (node > 0) {
            jedis.select(node);
        }
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

    public void set(String key, String value, long expire) {
        
    }   

    public void set(String key, String value) {
        try {

        } catch (Exception e) {

        }
    }

    public void set(String key, byte[] value) {

    }

}

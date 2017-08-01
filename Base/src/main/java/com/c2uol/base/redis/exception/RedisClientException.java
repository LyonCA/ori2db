package com.c2uol.base.redis.exception;

/**
 * 
 * @描述: redis 客户端异常
 * @作者: Lyon
 * @版本: v1.0
 * @时间: 2017年7月29日上午12:49:57
 *
 */
public class RedisClientException extends RuntimeException {

    private static final long serialVersionUID = -5012852660580398109L;

    public RedisClientException(String messages) {
        super(messages);
    }
}

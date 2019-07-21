package com.hsjjc.redisservice.api;

import org.springframework.web.bind.annotation.RequestMapping;

public interface RedisServiceApi {
	String get(String key);

	String set(String key, String value);

	String hget(String hkey, String key);

	long hset(String hkey, String key, String value);

	long incr(String key);

	long expire(String key, Integer second);

	long ttl(String key);

	long del(String key);

	long hdel(String hkey, String key);
}

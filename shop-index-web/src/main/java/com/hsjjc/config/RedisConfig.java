package com.hsjjc.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration  
@EnableCaching
//@EnableRedisHttpSession//(maxInactiveIntervalInSeconds=7200)
public class RedisConfig extends CachingConfigurerSupport{
	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object o, Method method, Object... objects) {
				StringBuilder sb = new StringBuilder();
				sb.append(o.getClass().getName());
				sb.append(method.getName());
				for (Object object:objects) {
					sb.append(object.toString());
				}
				return sb.toString();
			}
		};
	}
	@SuppressWarnings("rawtypes")
	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate) {
		RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
		//设置缓存过期时间
		rcm.setDefaultExpiration(604800);//秒-----一个星期
		return rcm;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		StringRedisTemplate template = new StringRedisTemplate(factory);
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

}
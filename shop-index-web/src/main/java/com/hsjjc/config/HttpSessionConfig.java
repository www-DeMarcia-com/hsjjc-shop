package com.hsjjc.config;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession(maxInactiveIntervalInSeconds=7200)//两个小时
public class HttpSessionConfig {  
    /*@Bean  
    public JedisConnectionFactory connectionFactory() {  
            return new JedisConnectionFactory();  
    }*/  
} 

package com.hsjjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * 用来实现redis缓存消息的消费者
 * 当有消息修改时，会向消息系统发送消息，当消息系统收到消息的时候，会去更新缓存
 * rabbitMQ
 * 使用
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class RedisServiceAppliacation {
	public static void main(String[] args) {
		SpringApplication.run(RedisServiceAppliacation.class, args);
	}
}

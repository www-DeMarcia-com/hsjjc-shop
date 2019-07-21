package com.hsjjc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsjjc.pojo.TbUser;
import com.hsjjc.service.VerifyService;
import com.hsjjc.sso.service.api.SsoServiceApi;


@RestController
@CacheConfig(cacheNames="users")
public class VerifyController implements SsoServiceApi{
	static final Logger log= LoggerFactory.getLogger(VerifyController.class);
	@Autowired
	VerifyService verifyService;
	@Autowired
	RedisTemplate<String, String> redisTemplate;
	
	
	@Cacheable(key="'user_name_'+#username", condition="#username.length()>5")
	public String hasUserByUseranme(@RequestParam("username")String username) {
		List<TbUser>list=verifyService.findByUsername(username);
		System.out.println(list);
		if(list!=null) {
			if(list.size()>0) {
				return "false";
			}else {
				return "true";
			}
		}else {
			return "true";
		}
	}

	@Cacheable(key="'user_phone_'+#phone",condition="#phone.length()>5")
	public String hasUserByPhone(@RequestParam("phone")String phone) {
		List<TbUser>list=verifyService.findByPhone(phone);		
		if(list!=null) {
			if(list.size()>0) {
				return "false";
			}else {
				return "true";
			}
		}else {
			return "true";
		}
	}

	public int insertUser(@RequestBody TbUser user) {
		try {
			TbUser tbuser=verifyService.insertUser(user);
			redisTemplate.opsForValue().set("user_phone_"+user.getPhone(), user.getPhone());/*set("user_phone_"+user.getPhone(), user.getPhone());*/
			redisTemplate.opsForValue().set("user_name_"+user.getUsername(), user.getUsername());
			if(tbuser!=null) {
				return 200;
			}

		}catch (Exception e) {
			log.error(e.toString());
		}
		return 500;
	}
	
	@Cacheable(key="'user_name_pwd_'+#username+'_'+#password", condition="#username.length()>5")
	public TbUser hasUserByUseranmeAndPassword(@RequestParam("username")String username, @RequestParam("password")String password) {
		TbUser user=verifyService.findByUsernameAndPassword(username,password);
		return user;
	}

}

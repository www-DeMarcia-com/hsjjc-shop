package com.hsjjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hsjjc.feignservice.SsoFeignService;
import com.hsjjc.pojo.TbUser;

@Service
@CacheConfig(cacheNames="ssoService")
public class SsoService {
	@Autowired
	SsoFeignService ssoService;
	@Cacheable(key="'user_name_pwd_'+#username+'_'+#jmpassword", condition="#username.length()>5")
	public TbUser hasUserByUseranmeAndPassword(String username, String jmpassword) {
		return ssoService.hasUserByUseranmeAndPassword(username, jmpassword);
	}
	@Cacheable(key="'user_name_'+#username", condition="#username.length()>5")
	public String hasUserByUseranme(String username) {
		return ssoService.hasUserByUseranme(username);
	}
	@Cacheable(key="'user_phone_'+#phone",condition="#phone.length()>5")
	public String hasUserByPhone(String phone) {
		return ssoService.hasUserByPhone(phone);
	}
//	@CachePut(key="'user_name_'+#user.getUsername()")
	public int insertUser(TbUser user) {
		return ssoService.insertUser(user);
	}
}

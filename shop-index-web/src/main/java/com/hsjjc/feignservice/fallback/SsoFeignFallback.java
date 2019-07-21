package com.hsjjc.feignservice.fallback;

import org.springframework.stereotype.Component;

import com.hsjjc.feignservice.SsoFeignService;
import com.hsjjc.pojo.TbUser;
@Component
public class SsoFeignFallback implements SsoFeignService{

	@Override
	public String hasUserByUseranme(String Username) {
		return "false";
	}

	@Override
	public String hasUserByPhone(String phone) {
		return "false";
	}

	@Override
	public int insertUser(TbUser user) {
		return 401;
	}

	@Override
	public TbUser hasUserByUseranmeAndPassword(String username, String password) {
		return null;
	}

}

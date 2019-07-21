package com.hsjjc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsjjc.dao.VerifyDao;
import com.hsjjc.pojo.TbUser;

@Service
public class VerifyService {
	@Autowired
	VerifyDao verify;
	public List<TbUser> findByPhone(String phone){
		return verify.findByPhone(phone);
	}
	
	public List<TbUser> findByUsername(String username){
		return verify.findByUsername(username);
	}
	
	public TbUser insertUser(TbUser user){
		return verify.insertUser(user);
	}
	
	public TbUser findByUsernameAndPassword(String username, String password) {
		return verify.findByUsernameAndPassword(username,password);
	}
}

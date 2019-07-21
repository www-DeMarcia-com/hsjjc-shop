package com.hsjjc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hsjjc.jpa.UserJPA;
import com.hsjjc.pojo.TbUser;

@Repository
public class VerifyDao {
	@Autowired
	UserJPA userJPA;
	public List<TbUser> findByPhone(String phone){
		return userJPA.findByPhone(phone);
	}
	public List<TbUser> findByUsername(String username){
		return userJPA.findByUsername(username);
	}
	public TbUser insertUser(TbUser user){
		return userJPA.saveAndFlush(user);
	}
	public TbUser findByUsernameAndPassword(String username, String password) {
		return userJPA.findByUsernameAndPassword(username,password);
	}
}

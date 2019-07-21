package com.hsjjc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.hsjjc.jpa.UserJPA;
import com.hsjjc.pojo.TbUser;

@Repository
public class UserDao {
	 @Autowired
	private UserJPA userJPA;
	public TbUser getUserById(Long id) {
		return userJPA.getOne(id);
	}
	public TbUser getUserByUsername(String name) {
		return userJPA.findByUsername(name);
	}
}

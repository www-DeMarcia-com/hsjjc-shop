package com.hsjjc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsjjc.dao.UserDao;
import com.hsjjc.pojo.TbUser;


@Service
@Transactional(rollbackFor=Exception.class)
public class UserService {
	@Autowired
	UserDao userdao;
	public TbUser getOne(Long id) {
		return userdao.getUserById(id);
	}
	
	public TbUser getUserByUsername(String name) {
		return userdao.getUserByUsername(name);
	}
}

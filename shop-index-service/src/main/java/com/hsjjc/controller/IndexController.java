package com.hsjjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsjjc.jpa.UserJPA;
import com.hsjjc.pojo.TbUser;
import com.hsjjc.service.UserService;
import com.hsjjc.service.api.IndexService;

/**
 * 负责返回首页数据
 * 需要有缓存
 * 
 * @author Administrator
 *
 */
@RestController
public class IndexController implements IndexService{
	 @Autowired
	UserService userService;
	@Override
	public String getIndex() {
		return userService.getOne(10L).getPassword();
	}
	@RequestMapping("/name")
	public TbUser getUsername() {
		return userService.getUserByUsername("zhangsan");
	}
	

}

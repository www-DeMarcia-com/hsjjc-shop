package com.hsjjc.sso.service.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsjjc.pojo.TbUser;

public interface SsoServiceApi {
	@RequestMapping(value="/queryuserbyname",method=RequestMethod.GET)
	public String hasUserByUseranme(@RequestParam("username") String Username);
	@RequestMapping(value="/queryuserbyphone",method=RequestMethod.GET)
	public String hasUserByPhone(@RequestParam("phone")String phone);
	
	@RequestMapping(value="/insertuser",method=RequestMethod.POST)
	public int insertUser(@RequestBody TbUser user);
	
	@RequestMapping(value="/queryuserbynameandpwd",method=RequestMethod.GET)
	public TbUser hasUserByUseranmeAndPassword(@RequestParam("username")String username, @RequestParam("password")String password);
	
}

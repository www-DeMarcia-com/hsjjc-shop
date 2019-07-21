package com.hsjjc.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsjjc.pojo.TbUser;
import com.hsjjc.service.SsoService;

import cn.binux.pojo.ResponseResult;
import cn.binux.utils.MD5Util;

@Controller
public class LoginAndLogoutController {
	static final Logger log= LoggerFactory.getLogger(LoginAndLogoutController.class);
	@Autowired
	SsoService ssoService;

	
	@RequestMapping("/login")
	public String login(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object attribute = session.getAttribute("user");
		if(attribute!=null) {
			return "index";
		}
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model,HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "index";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/log",method=RequestMethod.POST)
	public ResponseResult log(HttpServletRequest request,
			@RequestParam("username")String username,
			@RequestParam("password")String password,
			@RequestParam("yzm")String yzm) {
		ResponseResult result=null;
		Object obj=request.getSession().getAttribute("randomString");
		String str=obj==null?"":obj.toString().toLowerCase();
		if(!str.equals(yzm.toLowerCase())){
			result=new ResponseResult(401,"验证码输入错",null);
		}else {
			//密码加密
			String jmpassword=MD5Util.getMD5(MD5Util.getMD5(username+password));
			TbUser user=ssoService.hasUserByUseranmeAndPassword(username,jmpassword);
			System.out.println(user);
			if(user!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				result=new ResponseResult(200,"/shop-index-web/index",null);
				log.info(username+"-->登录成功，ip："+request.getHeader("X-Forwarded-For")+"-->sessionID"+session.getId());
				String redirect = request.getParameter("redirect");
				if(redirect!=null&&!"".equals(redirect)) {
					result=new ResponseResult(200,redirect,null);
				}
			}else {
				result=new ResponseResult(401,"用户名或密码错误",null);
			}
		}
		return result;
	}
	
}

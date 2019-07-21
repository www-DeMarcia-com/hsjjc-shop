package com.hsjjc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hsjjc.feignservice.SsoFeignService;
import com.hsjjc.util.CaptchaUtil;

@Controller

public class Verifcode {
	@Autowired
	SsoFeignService ssoService;
	@RequestMapping(value = "/captcha", method = RequestMethod.GET)
	@ResponseBody
	public void captcha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		CaptchaUtil.outputCaptcha(request, response);
	}

	@RequestMapping(value = "/verifybyusername", method = RequestMethod.POST)
	@ResponseBody
	public String verifyByusername(@RequestParam("username")String username) {
		if ("true".equals(ssoService.hasUserByUseranme(username))) {
			return "{\"valid\":true}";
		}
		return "{\"valid\":false}";
	}

	@RequestMapping(value = "/verifybyphone", method = RequestMethod.POST)
	@ResponseBody
	public String verifyByphone(@RequestParam("phone")String phone) {
		if("true".equals(ssoService.hasUserByPhone(phone))) {
			return "{\"valid\":true}";
		}
		return "{\"valid\":false}";
	}
	@RequestMapping(value = "/verifybyyzm", method = RequestMethod.POST)
	@ResponseBody
	public String verifyByphone(@RequestParam("yzm")String yzm,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object attribute = session.getAttribute("randomString");
		String str=attribute==null?"":attribute.toString().toLowerCase();
		if(str.equals(yzm.toLowerCase().trim())) {
			return "{\"valid\":true}";
		}
		return "{\"valid\":false}";
	}
}

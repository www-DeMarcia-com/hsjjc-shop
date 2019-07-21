package com.hsjjc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import cn.binux.utils.PhoneUtil;

@Controller
public class RegistryController {
	@Autowired
	SsoService ssoService;
	@Value("${isneedSMS}")
	String isneedSMS; 
	@RequestMapping("/registry")
	public String registry(Model model,HttpServletRequest request) {
		model.addAttribute("isneedSMS", isneedSMS);
		HttpSession session = request.getSession();
		Object attribute = session.getAttribute("user");
		if(attribute!=null) {
			return "index";
		}
		return "registry";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public ResponseResult reg(@RequestParam("username")String username
			,@RequestParam("userPassword")String userPassword,
			@RequestParam("userPassword2")String userPassword2,
			@RequestParam("phone")String phone,
			@RequestParam("nickname")String nickname,
			@RequestParam("yzm")String yzm,HttpServletRequest request) {
		
		ResponseResult result=null;
		//先判断是否是密码是否相同，然后用户名是否已经存在，然后判断手机号码是否已经存在，判断验证码是否正确，
		//判断是否启用手机验证码，如果有则判断手机验证码，如果，诶呦
		HttpSession session = request.getSession();
		Object obj=session.getAttribute("randomString");
		String str=obj==null?"":obj.toString().toLowerCase();
		if(!userPassword.equals(userPassword2)) {
			result=new ResponseResult(401,"密码输入不一致",null);
		}else if(!"true".equals(ssoService.hasUserByUseranme(username))){
			result=new ResponseResult(401,"注册失败，用户名已存在",null);
		}if(!"true".equals(ssoService.hasUserByPhone(phone))){
			result=new ResponseResult(401,"注册失败，手机号码已存在",null);
		}if(!str.equals(yzm.toLowerCase())){
			result=new ResponseResult(401,"验证码输入错",null);
		}else {
			if("0".equals(isneedSMS)) {
				String sjyzm=request.getParameter("sjyzm").toLowerCase();
				Object attribute = session.getAttribute("sjyzmrandom");
				String sjyzm2=attribute==null?"":attribute.toString().toLowerCase();
				if(!sjyzm2.equals(sjyzm)) {
					return new ResponseResult(401,"手机验证码输入错误",null);
				}
			}
			TbUser user=new TbUser();
			user.setNickname(nickname);
			user.setCreated(new Date());
			user.setUsername(username);
			user.setPassword(MD5Util.getMD5(MD5Util.getMD5(username+userPassword)));//两边MD5加密
			user.setPhone(PhoneUtil.AESEncode(phone));
			int code=ssoService.insertUser(user);
			switch (code) {
			case 200:
				result=new ResponseResult(200,"注册成功",null);
				break;
			case 500:
				result=new ResponseResult(500,"系统繁忙请稍后重试",null);
				break;
			case 401:
				result=new ResponseResult(401,"系统繁忙请稍后重试",null);
				break;
			}
		}
		return result;	
	}
	
}

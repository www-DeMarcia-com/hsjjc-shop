package com.hsjjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutUsController {
	//这个直接返回静态页面就可以
	@RequestMapping("/about")
	public String AboutUs() {
		return "about";
	}
}

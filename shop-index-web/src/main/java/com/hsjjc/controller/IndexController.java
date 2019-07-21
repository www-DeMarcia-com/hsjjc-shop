package com.hsjjc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsjjc.pojo.CategoriesSum;
import com.hsjjc.pojo.TbCategory;
import com.hsjjc.service.CategoryService;
import com.hsjjc.service.IndexService;
@Controller
public class IndexController {
	
	/*@Autowired
	IndexService indexService;*/
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/index")
	public String getIndex(Model model,HttpServletRequest request) {
//		String str =indexService.getIndex();
		List<CategoriesSum> categories=categoryService.findAll();
		
		model.addAttribute("categories", categories);
		return "index";
	}
	

}

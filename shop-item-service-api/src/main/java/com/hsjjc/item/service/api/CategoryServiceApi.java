package com.hsjjc.item.service.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hsjjc.pojo.CategoriesSum;
import com.hsjjc.pojo.TbCategory;

public interface CategoryServiceApi {
	@RequestMapping(value="/querybycid",method=RequestMethod.GET)
	public TbCategory querybycid(@RequestParam("cid")Long cid);
	
	@RequestMapping(value="/querybycname",method=RequestMethod.GET)
	public TbCategory querybycname(@RequestParam("cname")String cname);
	
	@RequestMapping(value="/queryall",method=RequestMethod.GET)
	public List<CategoriesSum> queryAll();
}

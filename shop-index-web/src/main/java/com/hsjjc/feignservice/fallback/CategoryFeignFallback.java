package com.hsjjc.feignservice.fallback;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hsjjc.feignservice.CategoryFeignService;
import com.hsjjc.pojo.CategoriesSum;
import com.hsjjc.pojo.TbCategory;

@Component
public class CategoryFeignFallback implements CategoryFeignService{

	@Override
	public TbCategory querybycid(Long cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbCategory querybycname(String cname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriesSum> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

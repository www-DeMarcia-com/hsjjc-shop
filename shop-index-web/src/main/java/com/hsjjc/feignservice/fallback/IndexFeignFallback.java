package com.hsjjc.feignservice.fallback;

import org.springframework.stereotype.Component;
import com.hsjjc.feignservice.IndexFeignService;

@Component
public class IndexFeignFallback implements IndexFeignService{

	@Override
	public String getIndex() {
		return "fallback";
	}
}

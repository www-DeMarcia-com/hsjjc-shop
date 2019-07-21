package com.hsjjc.service.api;

import org.springframework.web.bind.annotation.RequestMapping;

public interface IndexService {
	@RequestMapping("/index")
	public String getIndex();
}

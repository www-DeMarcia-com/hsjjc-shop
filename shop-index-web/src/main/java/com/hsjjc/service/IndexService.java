package com.hsjjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hsjjc.feignservice.IndexFeignService;

@Service
@CacheConfig(cacheNames="indexService")
public class IndexService {
	@Autowired
	IndexFeignService indexService;
	@CachePut(key="'get_index'")
	public String getIndex() {
		return indexService.getIndex();
	}
}

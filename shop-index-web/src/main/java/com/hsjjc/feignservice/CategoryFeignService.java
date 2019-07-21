package com.hsjjc.feignservice;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.hsjjc.feignservice.fallback.CategoryFeignFallback;
import com.hsjjc.item.service.api.CategoryServiceApi;

@FeignClient(name="shop-item-service"/*,fallback=CategoryFeignFallback.class*/)
public interface CategoryFeignService extends CategoryServiceApi{

}

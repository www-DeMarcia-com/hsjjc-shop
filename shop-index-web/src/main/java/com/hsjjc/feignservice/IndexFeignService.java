package com.hsjjc.feignservice;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.hsjjc.feignservice.fallback.IndexFeignFallback;
import com.hsjjc.service.api.IndexService;
@FeignClient(name="shop-sso-service"/*,fallback=IndexFeignFallback.class*/)
public interface IndexFeignService extends IndexService{

}

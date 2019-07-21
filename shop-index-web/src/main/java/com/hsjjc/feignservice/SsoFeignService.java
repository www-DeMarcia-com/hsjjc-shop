package com.hsjjc.feignservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import com.hsjjc.feignservice.fallback.SsoFeignFallback;
import com.hsjjc.sso.service.api.SsoServiceApi;
@FeignClient(name="shop-sso-service"/*,fallback=SsoFeignFallback.class*/)
public interface SsoFeignService extends SsoServiceApi{

	

}

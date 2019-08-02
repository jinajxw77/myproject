package com.jixw.cboot.eurekaclient1.feign;

import com.jixw.cboot.eurekaclient1.feign.fallback.ClientFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cboot-eureka-client2", fallback = ClientFeignImpl.class)
public interface ClientFeign {

    @GetMapping("/test/hello")
    String helloWord();
}

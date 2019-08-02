package com.jixw.cboot.eurekaclient1.feign.fallback;

import com.jixw.cboot.eurekaclient1.feign.ClientFeign;
import org.springframework.stereotype.Service;

@Service
public class ClientFeignImpl implements ClientFeign {
    @Override
    public String helloWord() {
        System.out.println("import fallback");
        return "fallback";
    }
}

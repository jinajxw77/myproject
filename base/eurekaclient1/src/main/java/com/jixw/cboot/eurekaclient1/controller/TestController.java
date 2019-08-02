package com.jixw.cboot.eurekaclient1.controller;

import com.jixw.cboot.eurekaclient1.feign.ClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private ClientFeign clientFeign;

    @RequestMapping("hello")
    public String helloWord(){
        String val = clientFeign.helloWord();
        System.out.println(val);
        return "hello 111";
    }
}

package com.jixw.cboot.eurekaclient2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("hello")
    public String helloWord(){
        System.out.println("hello 222");
        return "hello 222";
    }
}

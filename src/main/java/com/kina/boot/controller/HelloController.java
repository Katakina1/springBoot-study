package com.kina.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
// RestController = ResponseBody and Controller
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String handle01() {
        return "hello, SpringBoot!!";
    }
}

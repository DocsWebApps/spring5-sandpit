package com.docswebapps.spring5sandpit.controller;

import com.docswebapps.spring5sandpit.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    private final HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(@Qualifier("helloWorldServiceImpl") HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping
    public String sayHello() {
        return this.helloWorldService.sayHello();
    }
}

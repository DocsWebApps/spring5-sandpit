package com.docswebapps.spring5sandpit.service.impl;

import com.docswebapps.spring5sandpit.service.HelloWorldService;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    public String sayHello() {
        return "Hello, :-)";
    }
}

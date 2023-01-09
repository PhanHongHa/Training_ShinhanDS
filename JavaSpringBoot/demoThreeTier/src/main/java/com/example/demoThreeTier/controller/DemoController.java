package com.example.demoThreeTier.controller;

import com.example.demoThreeTier.service.DemoService;
import com.example.demoThreeTier.service.impl.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping(value = "/")
    public String getHelloWorld(){

        return demoService.getDemo();
    }
}

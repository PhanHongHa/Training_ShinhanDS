package com.example.demoThreeTier.service.impl;

import com.example.demoThreeTier.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String getDemo() {
        return "Hello World";
    }


}

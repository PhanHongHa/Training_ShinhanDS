package com.example.demoDocker;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping
public class Controller {
    @GetMapping("/")
    public String testDocker(){
        return "TestDocker";
    }
}

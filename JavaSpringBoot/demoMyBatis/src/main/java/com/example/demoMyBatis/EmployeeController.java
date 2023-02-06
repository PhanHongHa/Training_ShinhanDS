package com.example.demoMyBatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAllEmployee")
    public List<Employee> getALlEmployees(){
        return employeeService.findAll();
    }


}

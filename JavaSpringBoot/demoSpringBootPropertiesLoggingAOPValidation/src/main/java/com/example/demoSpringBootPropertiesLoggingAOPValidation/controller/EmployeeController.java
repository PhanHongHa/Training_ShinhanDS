package com.example.demoSpringBootPropertiesLoggingAOPValidation.controller;

import com.example.demoSpringBootPropertiesLoggingAOPValidation.dto.EmployeeDto;
import com.example.demoSpringBootPropertiesLoggingAOPValidation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    List<EmployeeDto> list = new ArrayList<EmployeeDto>();
    @PostMapping("/employee")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.getEmployeeDto(employeeDto));
    }
}


package com.example.demoSpringBootPropertiesLoggingAOPValidation.controller;
import com.example.demoSpringBootPropertiesLoggingAOPValidation.dto.DepartmentDto;
import com.example.demoSpringBootPropertiesLoggingAOPValidation.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/department")
    public ResponseEntity<DepartmentDto> addEmployee(@RequestBody @Valid DepartmentDto departmentDto){


        return ResponseEntity.ok(departmentService.getDepartmentDto(departmentDto));
    }
}
package com.example.demoSpringBootPropertiesLoggingAOPValidation.service.impl;

import com.example.demoSpringBootPropertiesLoggingAOPValidation.dto.DepartmentDto;
import com.example.demoSpringBootPropertiesLoggingAOPValidation.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final Logger LOGGER =  LoggerFactory.getLogger(DepartmentServiceImpl.class);
    @Override
    public DepartmentDto getDepartmentDto(DepartmentDto departmentDto) {
        LOGGER.info(departmentDto.toString());
        return departmentDto;
    }
}
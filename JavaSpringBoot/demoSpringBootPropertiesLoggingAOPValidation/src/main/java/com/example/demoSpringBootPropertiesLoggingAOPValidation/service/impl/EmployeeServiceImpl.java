package com.example.demoSpringBootPropertiesLoggingAOPValidation.service.impl;
import com.example.demoSpringBootPropertiesLoggingAOPValidation.dto.EmployeeDto;
import com.example.demoSpringBootPropertiesLoggingAOPValidation.service.EmployeeService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Override
    public EmployeeDto getEmployeeDto(EmployeeDto employeeDto) {
        LOGGER.info(employeeDto.toString());
        return employeeDto;
    }
}


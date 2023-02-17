package com.example.demoSpringBootPropertiesLoggingAOPValidation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private long id;

    @NotEmpty(message = "name cannot be empty")
    @Size(max = 50, min = 10, message = "length from 10 to 50 characters")
    private String name;
    private Date birthDate;
    private boolean gender;
    @Email
    @NotEmpty(message = "email cannot be empty")
    private String email;
}

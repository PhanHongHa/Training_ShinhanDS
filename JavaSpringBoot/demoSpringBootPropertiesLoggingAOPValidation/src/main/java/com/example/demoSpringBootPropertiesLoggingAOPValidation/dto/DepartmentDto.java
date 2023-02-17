package com.example.demoSpringBootPropertiesLoggingAOPValidation.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private long id;
    @NotEmpty(message = "deptName cannot to empty")
    @Size(max = 50, min = 10, message = "length from 10 to 50 characters")
    private String deptName;
    @NotEmpty(message = "description cannot to empty")
    private String description;
    @NotEmpty(message = "not null")
    @Valid
    private List<EmployeeDto> employeeDto;
}

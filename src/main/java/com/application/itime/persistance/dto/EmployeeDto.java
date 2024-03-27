package com.application.itime.persistance.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeDto {

    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Special characters not allowed in name !")
    private String empName;
    private String empCode;
    private String shiftName;
}

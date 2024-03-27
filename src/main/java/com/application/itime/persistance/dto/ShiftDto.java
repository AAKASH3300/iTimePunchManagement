package com.application.itime.persistance.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ShiftDto {

    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Special characters not allowed !")
    private String shiftName;

    private String shiftType;
    private String startTime;
    private String endTime;
    private String startFrom;
    private String endAt;


}

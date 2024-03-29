package com.application.itime.persistance.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ShiftDto {


    private String shiftName;
    private String shiftType;
    private String startTime;
    private String endTime;
    private String startFrom;
    private String endAt;


}

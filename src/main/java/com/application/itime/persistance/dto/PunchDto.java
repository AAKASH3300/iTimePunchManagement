package com.application.itime.persistance.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class PunchDto {

    private String punchTime;

    private String punchType;

    private String empCode;

}

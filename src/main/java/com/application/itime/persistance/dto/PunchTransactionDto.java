package com.application.itime.persistance.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PunchTransactionDto {

    private String punchIn;

    private String punchOut;

    private String nextPunchType;

    private String workingHours;

}

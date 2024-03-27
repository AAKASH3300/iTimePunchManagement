package com.application.itime.service;

import com.application.itime.enumeration.EnumPunchType;
import com.application.itime.exceptions.CommonExcption;
import com.application.itime.persistance.dto.PunchDto;

public interface PunchService {

    String punch(String empId, EnumPunchType punchType) throws CommonExcption;


}

package com.application.itime.service.implementation;

import com.application.itime.enumeration.EnumPunchType;
import com.application.itime.exceptions.CommonExcption;
import com.application.itime.persistance.entity.Employee;
import com.application.itime.persistance.entity.Punch;
import com.application.itime.persistance.conversion.EmployeeMapper;
import com.application.itime.persistance.conversion.PunchMapper;
import com.application.itime.persistance.dto.PunchDto;
import com.application.itime.repository.EmployeeRepository;
import com.application.itime.repository.PunchRepository;
import com.application.itime.service.CommonService;
import com.application.itime.service.PunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PunchImpl implements PunchService {

    @Autowired
    PunchRepository punchRepository;
    @Autowired
    PunchMapper punchMapper;

    @Autowired
    CommonService commonService;

    @Override
    public String punch(String empId, EnumPunchType punchType) throws CommonExcption {

        PunchDto punchModel = new PunchDto();
        Employee employee = commonService.findByEmployeeId(empId);
        punchModel.setPunchType(punchType.getPunchType());

        Punch punch = punchMapper.modelToEntity(punchModel, employee);
        punchRepository.save(punch);

        return "Successfully Punched";
    }


}

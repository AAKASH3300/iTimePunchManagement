package com.application.itime.service.implementation;

import com.application.itime.enumeration.EnumPunchType;
import com.application.itime.exceptions.CommonExcption;
import com.application.itime.persistance.conversion.PunchMapper;
import com.application.itime.persistance.dto.PunchDto;
import com.application.itime.persistance.dto.PunchTransactionDto;
import com.application.itime.persistance.entity.Employee;
import com.application.itime.persistance.entity.Punch;
import com.application.itime.repository.PunchRepository;
import com.application.itime.service.CommonService;
import com.application.itime.service.PunchService;
import com.application.itime.utils.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

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

    @Override
    public PunchTransactionDto punchDetails(String empId, String date) throws CommonExcption {

        Employee employee = commonService.findByEmployeeId(empId);
        Timestamp shiftStart = TimeFormat.dateTimeFormat(TimeFormat.timeFormat(date), employee.getShiftName().getStartTime());
        Timestamp shiftEnd = TimeFormat.dateTimeFormat(TimeFormat.timeFormat(date), employee.getShiftName().getEndTime());

        Punch punchIN = punchRepository.findFirstByEmpCodeAndPunchTypeAndPunchTimeBetweenOrderByPunchTimeAsc(
                employee, EnumPunchType.IN, shiftStart, shiftEnd);
        Punch punchOUT = punchRepository.findFirstByEmpCodeAndPunchTypeAndPunchTimeBetweenOrderByPunchTimeAsc(
                employee, EnumPunchType.OUT, shiftStart, shiftEnd);
        Punch lastPunch = punchRepository.findFirstByEmpCodeAndPunchTimeBetweenOrderByPunchTimeDesc(
                employee, shiftStart, shiftEnd);

        String nextPunch;

        if (lastPunch.getPunchType().getPunchType().equals("IN")) {
            nextPunch = "OUT";
        } else {
            nextPunch = "IN";
        }

        long workingMilliseconds = shiftEnd.getTime() - shiftStart.getTime();
        long workingHours = workingMilliseconds / (60 * 60 * 1000);



//        PunchTransactionDto punchTransactionDto = new PunchTransactionDto();
//        punchTransactionDto.setPunchIn(punchIN.toString());
//        punchTransactionDto.setPunchOut(punchOUT.toString());
//        punchTransactionDto.setNextPunchType(nextPunch);


        return punchMapper.statusEntityToModel(punchIN.getPunchTime().toString(), punchOUT.getPunchTime().toString(), nextPunch, String.valueOf(workingHours));
    }


}

package com.application.itime.persistance.conversion;

import com.application.itime.enumeration.EnumPunchType;
import com.application.itime.persistance.dto.PunchTransactionDto;
import com.application.itime.persistance.entity.Employee;
import com.application.itime.persistance.entity.Punch;
import com.application.itime.persistance.dto.PunchDto;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;

@Component
public class PunchMapper {

    public Punch modelToEntity(PunchDto punchModel, Employee employee) {

        Punch punch = new Punch();

        punch.setPunchTime(new Timestamp(System.currentTimeMillis()));
        punch.setPunchType(EnumPunchType.valueOfPunchType(punchModel.getPunchType()));
        punch.setEmpCode(employee);

        return punch;
    }

    public PunchDto entityToModel(Punch punch) {

        PunchDto punchModel = new PunchDto();

        punchModel.setPunchTime(String.valueOf(punch.getPunchTime()));
        punchModel.setPunchType(String.valueOf(punch.getPunchType()));
        punchModel.setEmpCode(String.valueOf(punch.getEmpCode().getEmpCode()));


        return punchModel;
    }


    public PunchTransactionDto statusEntityToModel(String punchIn,String punchOut,String punchType,String workingHours){
        PunchTransactionDto punchModel = new PunchTransactionDto();

        punchModel.setPunchIn(punchIn);
        punchModel.setPunchOut(punchOut);
        punchModel.setNextPunchType(punchType);
        punchModel.setWorkingHours(workingHours);
        return punchModel;
    }

}

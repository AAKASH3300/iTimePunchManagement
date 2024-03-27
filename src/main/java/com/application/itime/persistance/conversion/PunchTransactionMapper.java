package com.application.itime.persistance.conversion;

import com.application.itime.enumeration.EnumPunchType;
import com.application.itime.persistance.dto.PunchTransactionDto;
import com.application.itime.persistance.entity.PunchTransaction;
import org.springframework.stereotype.Component;

import java.sql.Time;

@Component
public class PunchTransactionMapper {

    public PunchTransaction modelToEntity(PunchTransactionDto punchModel){
        PunchTransaction punch = new PunchTransaction();

        punch.setPunchIn(Time.valueOf(punchModel.getPunchIn()));
        punch.setPunchOut(Time.valueOf(punchModel.getPunchOut()));
        punch.setPunchType(EnumPunchType.valueOf(punchModel.getPunchType()));
        punch.setWorkingHours(punchModel.getWorkingHours());
        return punch;
    }

    public PunchTransactionDto entityToModel(PunchTransaction punchTransaction){
        PunchTransactionDto punchModel = new PunchTransactionDto();

        punchModel.setPunchIn(String.valueOf(punchTransaction.getPunchIn()));
        punchModel.setPunchOut(String.valueOf(punchTransaction.getPunchOut()));
        punchModel.setPunchType(String.valueOf(punchTransaction.getPunchType()));
        punchModel.setWorkingHours(punchTransaction.getWorkingHours());
        return punchModel;
    }
}

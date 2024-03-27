package com.application.itime.mapper;

import com.application.itime.enumeration.EnumPunchType;
import com.application.itime.persistance.conversion.PunchMapper;
import com.application.itime.persistance.dto.PunchDto;
import com.application.itime.persistance.entity.Employee;
import com.application.itime.persistance.entity.Punch;
import org.hibernate.annotations.CurrentTimestamp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Time;
import java.sql.Timestamp;

@ExtendWith(MockitoExtension.class)
public class PunchMapperTest {

    @InjectMocks
    PunchMapper punchMapper;

    Punch punch = new Punch();
    Employee employee = new Employee();
    PunchDto punchDto = new PunchDto();

    Time CurrentTimestamp;
    @BeforeEach
    void init(){

        punch.setPunchType(EnumPunchType.valueOfPunchType("IN"));
        punch.setPunchTime(CurrentTimestamp);
        punch.setEmpCode(employee);

        punchDto.setPunchType("IN");
        punchDto.setPunchTime(String.valueOf(CurrentTimestamp));
        punchDto.setEmpCode(employee.getEmpCode());
    }


    @Test
    void modelToEntityTest(){

        Punch punch1 = punchMapper.modelToEntity(punchDto,employee);
        Assertions.assertEquals(punch.getEmpCode().getEmpCode(),punch1.getEmpCode().getEmpCode());
        Assertions.assertEquals(punch.getPunchType(),punch1.getPunchType());
        Assertions.assertEquals(punch.getPunchTime(),punch1.getPunchTime());

    }

    @Test
    void entityToModelTest(){
        PunchDto punchDto1 = punchMapper.entityToModel(punch);
        Assertions.assertEquals(punchDto.getEmpCode(),punchDto1.getEmpCode());
        Assertions.assertEquals(punchDto.getPunchType(),punchDto1.getPunchType());
        Assertions.assertEquals(punchDto.getPunchTime(),punchDto1.getPunchTime());


    }

}

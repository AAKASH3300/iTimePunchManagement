package com.application.itime.persistance.conversion;

import com.application.itime.enumeration.EnumShiftType;
import com.application.itime.persistance.entity.Shift;
import com.application.itime.persistance.dto.ShiftDto;
import org.springframework.stereotype.Component;

import java.sql.Time;

@Component
public class ShiftMapper {
    public static Shift modelToEntity(ShiftDto shiftModel) {

        Shift shift = new Shift();

        shift.setShiftName(shiftModel.getShiftName());
        shift.setShiftType(EnumShiftType.valueOfShiftType(shiftModel.getShiftType()));
        shift.setStartFrom(shiftModel.getStartFrom());
        shift.setStartTime(Time.valueOf(shiftModel.getStartTime()));
        shift.setEndTime(Time.valueOf(shiftModel.getEndTime()));
        shift.setEndAt(shiftModel.getEndAt());


        return shift;
    }

    public ShiftDto entityToModel(Shift shift) {

        ShiftDto shiftModel = new ShiftDto();

        shiftModel.setShiftName(shift.getShiftName());
        shiftModel.setShiftType(String.valueOf(shift.getShiftType()));
        shiftModel.setStartFrom(shift.getStartFrom());
        shiftModel.setStartTime(String.valueOf(shift.getStartTime()));
        shiftModel.setEndTime(String.valueOf(shift.getEndTime()));
        shiftModel.setEndAt(shift.getEndAt());


        return shiftModel;
    }
}

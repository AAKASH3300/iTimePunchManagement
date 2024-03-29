package com.application.itime.service.implementation;

import com.application.itime.persistance.conversion.ShiftMapper;
import com.application.itime.persistance.dto.ShiftDto;
import com.application.itime.persistance.entity.Shift;
import com.application.itime.repository.ShiftRepository;
import com.application.itime.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiftImpl implements ShiftService {

    @Autowired
    ShiftMapper shiftMapper;

    @Autowired
    ShiftRepository shiftRepository;

    @Override
    public String addShift(ShiftDto shiftDto) {

        Shift shift = shiftMapper.modelToEntity(shiftDto);
        shiftRepository.save(shift);
        return "Shift Added Successfully";
    }
}

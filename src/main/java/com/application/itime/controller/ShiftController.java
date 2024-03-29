package com.application.itime.controller;

import com.application.itime.persistance.dto.ShiftDto;
import com.application.itime.service.ShiftService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shift")
@SecurityRequirement(name = "aakashAuth")
public class ShiftController {

    @Autowired
    ShiftService shiftService;

    @PostMapping("/add")
    public ResponseEntity<String> addShiftDetails(ShiftDto shiftDto) {
        String response = shiftService.addShift(shiftDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


}

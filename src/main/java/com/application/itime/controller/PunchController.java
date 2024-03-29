package com.application.itime.controller;

import com.application.itime.enumeration.EnumPunchType;
import com.application.itime.exceptions.CommonExcption;
import com.application.itime.persistance.dto.PunchTransactionDto;
import com.application.itime.service.PunchService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/punch")
@SecurityRequirement(name = "aakashAuth")
public class PunchController {

    @Autowired
    PunchService punchService;

    @PostMapping("")
    public ResponseEntity<String> registerPunch(@RequestParam(name = "empId") String empId, @RequestParam(name = "punchType") EnumPunchType punchType) throws CommonExcption {
        String response = punchService.punch(empId, punchType);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/dayStatus")
    public ResponseEntity<PunchTransactionDto> displayPunchDetails(@RequestParam(name="empId")String empId, @RequestParam(name="date")String date) throws CommonExcption {
        PunchTransactionDto daysStatus = punchService.punchDetails(empId,date);
        return new ResponseEntity<>(daysStatus,HttpStatus.OK);

    }

}

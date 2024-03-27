package com.application.itime.controller;

import com.application.itime.enumeration.EnumPunchType;
import com.application.itime.exceptions.CommonExcption;
import com.application.itime.persistance.dto.PunchTransactionDto;
import com.application.itime.service.PunchService;
import com.application.itime.service.PunchTransactionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@SecurityRequirement(name = "aakashAuth")
public class PunchController {

    @Autowired
    PunchService punchService;

    @Autowired
    PunchTransactionService punchTransactionService;

    @PostMapping("/punch/{empId}/{punchType}")
    public ResponseEntity<String> registerPunch(@PathVariable(name = "empId") String empId, @PathVariable(name = "punchType") EnumPunchType punchType) throws CommonExcption {
        String response = punchService.punch(empId, punchType);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    ///{empid}
    @GetMapping("/display/punchDetails")
    public ResponseEntity<List<PunchTransactionDto>> displayPunchDetails(){
        List<PunchTransactionDto> response = punchTransactionService.punchDetails();
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }

}

package com.application.itime.controller;

import com.application.itime.enumeration.EnumPunchType;
import com.application.itime.exceptions.CommonExcption;
import com.application.itime.service.PunchService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@SecurityRequirement(name = "aakashAuth")
public class PunchController {

    @Autowired
    PunchService punchService;

    @PostMapping("/punch/{empId}/{punchType}")
    public ResponseEntity<String> registerPunch(@PathVariable(name = "empId") String empId, @PathVariable(name = "punchType") EnumPunchType punchType) throws CommonExcption {
        String response = punchService.punch(empId, punchType);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}

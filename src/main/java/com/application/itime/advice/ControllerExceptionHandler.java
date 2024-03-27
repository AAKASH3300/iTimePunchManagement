package com.application.itime.advice;

import com.application.itime.exceptions.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

        @ExceptionHandler(value = {EmployeeNotFoundException.class})
        @ResponseStatus(value = HttpStatus.NOT_FOUND)
        public Map<String, String> resourceNotFoundException(EmployeeNotFoundException exception) {
           Map<String, String> msg = new HashMap<>();

           msg.put("Error Message : ", exception.getMessage());
           msg.put("Status code : ", HttpStatus.NOT_FOUND.toString());

            return msg;
        }

}

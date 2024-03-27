package com.application.itime.service;

import com.application.itime.exceptions.CommonExcption;
import com.application.itime.exceptions.EmployeeNotFoundException;
import com.application.itime.persistance.entity.Employee;
import com.application.itime.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommonService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee findByEmployeeId(String empId) throws CommonExcption {

        Optional<Employee> employee = employeeRepository.findById(Integer.parseInt(empId));

        if(employee.isEmpty()){

//            throw exception: employee not present
            throw new EmployeeNotFoundException("Employee with the id" + empId + "Not Exist .. !");
        }



        return employee.get();
    }
}

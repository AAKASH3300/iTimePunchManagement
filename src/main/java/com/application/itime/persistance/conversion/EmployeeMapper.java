package com.application.itime.persistance.conversion;

import com.application.itime.persistance.entity.Employee;
import com.application.itime.persistance.entity.Shift;
import com.application.itime.persistance.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {


    public static Employee modelToEntity(EmployeeDto employeeModel) {

        Employee employee = new Employee();

        employee.setEmpCode(employeeModel.getEmpCode());
        employee.setEmpName(employeeModel.getEmpName());
        Shift shift = convertShiftNameToEntity(employeeModel.getShiftName());
        employee.setShiftName(shift);
        return employee;
    }

    public EmployeeDto entityToModel(Employee employee) {

        EmployeeDto employeeModel = new EmployeeDto();

        employeeModel.setEmpCode(employee.getEmpCode());
        employeeModel.setEmpName(employee.getEmpName());
        employeeModel.setShiftName(String.valueOf(employee.getShiftName()));

        return employeeModel;
    }

    private static Shift convertShiftNameToEntity(String shiftName) {

        Shift shift = new Shift();
        shift.setShiftName(shiftName);
        return shift;
    }
}

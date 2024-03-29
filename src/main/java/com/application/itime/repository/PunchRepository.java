package com.application.itime.repository;

import com.application.itime.enumeration.EnumPunchType;
import com.application.itime.persistance.entity.Employee;
import com.application.itime.persistance.entity.Punch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface PunchRepository extends JpaRepository<Punch, Integer> {


    Punch findFirstByEmpCodeAndPunchTypeAndPunchTimeBetweenOrderByPunchTimeAsc(Employee employee, EnumPunchType punchType, Timestamp shiftStart, Timestamp shiftEnd);

    Punch findFirstByEmpCodeAndPunchTimeBetweenOrderByPunchTimeDesc(Employee employee, Timestamp shiftStart, Timestamp shiftEnd);
}

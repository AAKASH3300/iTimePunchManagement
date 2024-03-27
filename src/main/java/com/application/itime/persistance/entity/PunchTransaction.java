package com.application.itime.persistance.entity;

import com.application.itime.enumeration.EnumPunchType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PunchTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "punch_in")
    private Time punchIn;

    @Column(name="punch_out")
    private Time punchOut;

    @Enumerated(EnumType.STRING)
    @Column(name="punch_type")
    private EnumPunchType punchType;

    @Column(name="working_hrs")
    private String workingHours;
}

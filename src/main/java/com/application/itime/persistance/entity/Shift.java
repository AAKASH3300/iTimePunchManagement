package com.application.itime.persistance.entity;

import com.application.itime.enumeration.EnumShiftType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_shift")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="shift_name",length = 25)
    private String shiftName;

    @Enumerated(EnumType.STRING)
    @Column(name="shift_type",length = 10)
    private EnumShiftType shiftType;

    @Column(name="start_time")
    private Time startTime;

    @Column(name="end_time")
    private Time endTime;

    @Column(name="start_from",length = 25)
    private String startFrom;

    @Column(name="end_at",length = 25)
    private String endAt;

}

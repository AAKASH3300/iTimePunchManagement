package com.application.itime.persistance.entity;

import com.application.itime.enumeration.EnumPunchType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_punch")
public class Punch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "punch_time", length = 25)
    private Timestamp punchTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "punch_type", length = 10)
    private EnumPunchType punchType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "emp_code",
            referencedColumnName = "emp_code"
    )
    private Employee empCode;



}

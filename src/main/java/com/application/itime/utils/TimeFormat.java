package com.application.itime.utils;

import org.springframework.context.annotation.Configuration;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class TimeFormat {

    public static LocalDate timeFormat(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(date, formatter);
    }

    public static Timestamp dateTimeFormat(LocalDate date, Time time) {

        LocalTime timePart = LocalTime.parse(time.toString());
        LocalDateTime dateTime = LocalDateTime.of(date, timePart);
        return Timestamp.valueOf(dateTime);
    }

    TimeFormat() {
    }
}

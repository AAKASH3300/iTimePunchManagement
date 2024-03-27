package com.application.itime.enumeration;

import lombok.Getter;

@Getter
public enum EnumShiftType {
    DAY_SHIFT("DAY_SHIFT"), NIGHT_SHIFT("NIGHT_SHIFT");

    final String shift_type;

    EnumShiftType(String shift_type) {
        this.shift_type = shift_type;
    }

    public static EnumShiftType valueOfShiftType(String value) {
        for (EnumShiftType a : values()) {
            if (a.getShift_type().equals(value)) {
                return a;
            }
        }
        return null;
    }

}

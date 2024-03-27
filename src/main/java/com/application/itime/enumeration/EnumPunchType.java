package com.application.itime.enumeration;

import lombok.Getter;

@Getter
public enum EnumPunchType {

    IN("IN"), OUT("OUT");

    final String punchType;

    EnumPunchType(String punchType) {
        this.punchType = punchType;
    }

    public static EnumPunchType valueOfPunchType(String value) {
        for (EnumPunchType a : values()) {
            if (a.getPunchType().equals(value)) {
                return a;
            }
        }
        return null;
    }

}

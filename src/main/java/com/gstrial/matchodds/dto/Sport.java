package com.gstrial.matchodds.dto;

public enum Sport {
    FOOTBALL_SPORT("FOOTBALL"),
    BASKETBALL_SPORT("BASKETBALL");

    private final String sportName;

    Sport(String sportName) {
        this.sportName = sportName;
    }

    public String value() {
        return sportName;
    }
}

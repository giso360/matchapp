package com.gstrial.matchodds.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class MatchInfo {

    private String matchDescription;

    private Date matchDate;

    private String matchTeamA;

    private String matchTeamB;

    private LocalTime matchTime;

    private String sportName;

}

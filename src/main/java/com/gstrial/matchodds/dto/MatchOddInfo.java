package com.gstrial.matchodds.dto;

import lombok.Data;

import java.util.List;

@Data
public class MatchOddInfo {

    private MatchInfo matchInfo;

    private List<OddInfo> oddInfoList;

}

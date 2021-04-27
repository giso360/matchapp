package com.gstrial.matchodds.service;

import com.gstrial.matchodds.dto.MatchInfo;
import com.gstrial.matchodds.dto.MatchOddInfo;
import com.gstrial.matchodds.entity.Match;

import java.util.List;

public interface MatchService {

    List<MatchInfo> getAllMatches();

    List<MatchOddInfo> getAllMatchesWithOdds();

    MatchOddInfo getOneMatchOddInfo(int matchId);

    MatchInfo getOneMatchInfo(int matchId);

    Match addNewMatch(MatchInfo matchInfo);

    Match updateMatch(Match match, MatchOddInfo matchOddInfo, int matchId);
}

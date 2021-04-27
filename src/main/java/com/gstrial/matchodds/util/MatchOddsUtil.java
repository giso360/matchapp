package com.gstrial.matchodds.util;

import com.gstrial.matchodds.dto.MatchInfo;
import com.gstrial.matchodds.dto.MatchOddInfo;
import com.gstrial.matchodds.dto.OddInfo;
import com.gstrial.matchodds.dto.Sport;
import com.gstrial.matchodds.entity.Match;
import com.gstrial.matchodds.entity.MatchOdd;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatchOddsUtil {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static MatchInfo convertMatchToMatchInfo(Match match){
        MatchInfo matchInfo = modelMapper.map(match, MatchInfo.class);

        if (match.getMatchSportIdentifier() == 1){
            matchInfo.setSportName(Sport.FOOTBALL_SPORT.value());
        } else {
            matchInfo.setSportName(Sport.BASKETBALL_SPORT.value());
        }

        return matchInfo;
    }

    public static Match convertMatchInfoToMatch(MatchInfo matchInfo){
        Match match = modelMapper.map(matchInfo, Match.class);
        if (matchInfo.getSportName().equals(Sport.FOOTBALL_SPORT.value())){
            match.setMatchSportIdentifier(1);
        } else {
            match.setMatchSportIdentifier(2);
        }
        return match;
    }

    public static Match convertMatchOddInfoToMatch(MatchOddInfo matchOddInfo, int matchId){
        List<MatchOdd> matchOdds = new ArrayList<>();
        MatchInfo matchInfo = matchOddInfo.getMatchInfo();
        Match match = convertMatchInfoToMatch(matchInfo);
        match.setMatchId((long) matchId);
        List<OddInfo> oddInfoList = matchOddInfo.getOddInfoList();
        oddInfoList.forEach(oddInfo -> {
            MatchOdd matchOdd = modelMapper.map(oddInfo, MatchOdd.class);
            matchOdd.setOddMatchId(match);
            matchOdds.add(matchOdd);
        });

        Set<MatchOdd> matchOddSet = new HashSet<>(matchOdds);
        match.setMatchOdds(matchOddSet);
        return match;
    }

}

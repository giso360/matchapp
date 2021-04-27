package com.gstrial.matchodds.service;

import static com.gstrial.matchodds.util.MatchOddsUtil.*;

import com.gstrial.matchodds.dto.MatchInfo;
import com.gstrial.matchodds.dto.MatchOddInfo;
import com.gstrial.matchodds.entity.Match;
import com.gstrial.matchodds.exception.MatchNotFoundException;
import com.gstrial.matchodds.exception.MatchOddsGeneralException;
import com.gstrial.matchodds.repository.MatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchesRepository matchesRepository;

    @Override
    public List<MatchInfo> getAllMatches() {
        List<MatchInfo> matchInfoList = new ArrayList<>();
        List<Match> matchList = matchesRepository.findAll();
        matchList.forEach(match -> matchInfoList.add(convertMatchToMatchInfo(match)));
        return matchInfoList;
    }

    @Override
    public List<MatchOddInfo> getAllMatchesWithOdds() {
        return null;
    }

    @Override public MatchOddInfo getOneMatchOddInfo(int matchId) {
        return null;
    }

    @Override
    public MatchInfo getOneMatchInfo(int matchId) {
        Optional<Match> matchById = matchesRepository.findById((long) matchId);
        if (matchById.isPresent()){
            return convertMatchToMatchInfo(matchById.get());
        } else {
            if (matchById.isEmpty()){
                throw new MatchNotFoundException("could not retrieve match with id: " + matchId);
            } else {
                throw new MatchOddsGeneralException("something else happened!!!");
            }
        }
    }

    @Override
    public Match addNewMatch(MatchInfo matchInfo) {
        Match match = convertMatchInfoToMatch(matchInfo);
        matchesRepository.save(match);
        return match;
    }

    @Override public Match updateMatch(Match match, MatchOddInfo matchOddInfo, int matchId) {
        Match matchToSave = convertMatchOddInfoToMatch(matchOddInfo, matchId);
        matchesRepository.save(matchToSave);
        return matchToSave;
    }

}

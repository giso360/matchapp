package com.gstrial.matchodds.controller;

import com.gstrial.matchodds.dto.MatchInfo;
import com.gstrial.matchodds.dto.MatchOddInfo;
import com.gstrial.matchodds.entity.Match;
import com.gstrial.matchodds.entity.MatchOdd;
import com.gstrial.matchodds.exception.MatchNotFoundException;
import com.gstrial.matchodds.exception.MatchOddNotFoundException;
import com.gstrial.matchodds.repository.MatchOddsRepository;
import com.gstrial.matchodds.repository.MatchesRepository;
import com.gstrial.matchodds.service.MatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("matchapp")
@Slf4j
public class MatchOddController {

    private final MatchesRepository matchesRepository;
    private final MatchOddsRepository matchOddsRepository;
    private final MatchService matchService;

    public MatchOddController(MatchesRepository matchesRepository,
                              MatchOddsRepository matchOddsRepository,
                              MatchService matchService) {
        this.matchesRepository = matchesRepository;
        this.matchOddsRepository = matchOddsRepository;
        this.matchService = matchService;
    }

    @GetMapping("/all/withOdds")
    public ResponseEntity<List<Match>> getAllMatchesWithOdds() {
        try {
            return ResponseEntity.ok(matchesRepository.findAll());
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<MatchInfo>> getAllMatches() {
        try {
            return ResponseEntity.ok(matchService.getAllMatches());
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/withOdds/{matchId}")
    public ResponseEntity<Match> getSingleMatchWithOdds(@PathVariable int matchId) {
        try {
            return ResponseEntity.ok(matchesRepository.findById((long) matchId).get());
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<MatchInfo> getSingleMatch(@PathVariable int matchId) {
        try {
            return ResponseEntity.ok(matchService.getOneMatchInfo(matchId));
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Match> addNewMatch(@RequestBody MatchInfo matchInfo) {
        return ResponseEntity.ok(matchService.addNewMatch(matchInfo));
    }

    @PutMapping("/matchOdds/{matchId}")
    public ResponseEntity<Match> addNewOddForExistingMatch(@PathVariable int matchId,
                                                           @RequestBody MatchOddInfo matchOddInfo) {
        Optional<Match> matchOptional = matchesRepository.findById((long) matchId);
        if (matchOptional.isPresent()){
            Match match = matchOptional.get();
            Match saveMatch = matchService.updateMatch(match, matchOddInfo, matchId);
            return ResponseEntity.ok(saveMatch);
        } else {
            throw new MatchNotFoundException("match with id: " + matchId + " was not found");
        }
    }

    @DeleteMapping("/{matchId}")
    public void deleteSingleMatch(@PathVariable int matchId){
        Optional<Match> matchOptional = matchesRepository.findById((long) matchId);
        if (matchOptional.isPresent()){
            matchesRepository.deleteById((long) matchId);
        } else {
            throw new MatchNotFoundException("match with id: " + matchId + " was not found");
        }
    }

    @DeleteMapping("/odd/{matchOddId}")
    public void deleteSingleMatchOdd(@PathVariable int matchOddId){
        Optional<MatchOdd> matchOddOptional = matchOddsRepository.findById((long) matchOddId);
        if (matchOddOptional.isPresent()){
            matchOddsRepository.deleteById((long) matchOddId);
        } else {
            throw new MatchOddNotFoundException("matchOdd with id: " + matchOddId + " was not found");
        }
    }

}

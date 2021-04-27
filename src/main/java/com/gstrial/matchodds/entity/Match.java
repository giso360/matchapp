package com.gstrial.matchodds.entity;

import lombok.Data;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "MATCHES")
@SequenceGenerator(name = "match_seq", initialValue = 100, allocationSize = 1)
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "match_seq")
    @Column(name = "MATCH_ID")
    private Long matchId;

    @Column(name = "DESCRIPTION")
    private String matchDescription;

    @Column(name = "MATCH_DATE")
    private Date matchDate;

    @Column(name = "TEAM_A")
    private String matchTeamA;

    @Column(name = "TEAM_B")
    private String matchTeamB;

    @Column(name = "MATCH_TIME")
    private LocalTime matchTime;

    @Column(name = "SPORT")
    private int matchSportIdentifier;

    @OneToMany(mappedBy = "oddMatchId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MatchOdd> matchOdds;

}

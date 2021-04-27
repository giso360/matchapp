package com.gstrial.matchodds.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "MATCH_ODDS")
@SequenceGenerator(name = "odd_seq", initialValue = 100, allocationSize = 1)
public class MatchOdd {

    @Id
    @Column(name = "ODD_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odd_seq")
    @JsonIgnore
    private Long oddId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MATCH_ID", nullable = false)
    @JsonIgnore
    private Match oddMatchId;

    @Column(name = "SPECIFIER")
    private String oddSpecifier;

    @Column(name = "ODD")
    private Double oddValue;

}

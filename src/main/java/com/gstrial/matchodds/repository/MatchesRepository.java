package com.gstrial.matchodds.repository;

import com.gstrial.matchodds.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchesRepository extends JpaRepository<Match, Long> {
}

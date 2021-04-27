package com.gstrial.matchodds.repository;

import com.gstrial.matchodds.entity.MatchOdd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchOddsRepository extends JpaRepository<MatchOdd, Long> {
}

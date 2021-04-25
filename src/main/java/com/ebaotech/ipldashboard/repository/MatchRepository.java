package com.ebaotech.ipldashboard.repository;

import java.util.List;
import com.ebaotech.ipldashboard.model.Match;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> getMatchByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);

    default List<Match> findLatestMatchesPlayedByTeam(String teamName1, int countMatches)
    {
        Pageable pageable = PageRequest.of(0, countMatches);
       return  getMatchByTeam1OrTeam2OrderByDateDesc(teamName1, teamName1, pageable);

    }
    
}

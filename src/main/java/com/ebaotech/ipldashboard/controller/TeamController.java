package com.ebaotech.ipldashboard.controller;


import java.time.LocalDate;
import java.util.List;

import com.ebaotech.ipldashboard.model.Match;
import com.ebaotech.ipldashboard.model.Team;
import com.ebaotech.ipldashboard.repository.MatchRepository;
import com.ebaotech.ipldashboard.repository.TeamRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {

    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    
    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository)
    {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }



    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable("teamName") String teamName)
    {
        
        Team team =   this.teamRepository.findByTeamName(teamName);
       
        team.setTeamMatches(this.matchRepository.findLatestMatchesPlayedByTeam(teamName, 4));
        return team;
    }

    @GetMapping("/team/{teamName}/matches")
    public List<Match> getMatchesForTeam(@PathVariable("teamName") String teamName, @RequestParam("year") int year)
    {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year+1, 1, 1);
        return this.matchRepository.getMatchesByTeamBetweenDates(
        teamName,
        startDate,
        endDate
       );
        
    }
    
}

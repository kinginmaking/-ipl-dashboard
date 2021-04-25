package com.ebaotech.ipldashboard.controller;


import com.ebaotech.ipldashboard.model.Team;
import com.ebaotech.ipldashboard.repository.MatchRepository;
import com.ebaotech.ipldashboard.repository.TeamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
    
}

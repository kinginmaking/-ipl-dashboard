package com.ebaotech.ipldashboard.repository;

import com.ebaotech.ipldashboard.model.Team;

import org.springframework.data.repository.CrudRepository;



public interface TeamRepository extends CrudRepository<Team, Long>{

   Team findByTeamName(String teamName);
    
}

package com.ebaotech.ipldashboard.data;



import java.time.LocalDate;


import com.ebaotech.ipldashboard.model.Match;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

  private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

  @Override
  public Match process(final MatchInput person) throws Exception {
    Match match = new Match();
    match.setId(Long.parseLong(person.getId()));
    match.setCity(person.getCity());
    match.setDate(LocalDate.parse(person.getDate()));
    match.setPlayer_of_match(person.getPlayer_of_match());
    match.setVenue(person.getVenue());

    String firstInningTeam="", secondInningTeam="";

   // System.out.println("Team 1:" + person.getTeam1()+"\n Team 2"+person.getTeam2());
    if("bat".equals(person.getToss_decision()))
    {
        firstInningTeam = person.getToss_winner();
        secondInningTeam = person.getToss_winner().equals(person.getTeam1())
        ? person.getTeam2():
        person.getTeam1();
    }
    else
     { 
         secondInningTeam = person.getToss_winner();
         firstInningTeam = person.getToss_winner().equals(person.getTeam1())?
        person.getTeam2():
        person.getTeam1();
     }
    

     match.setTeam1(firstInningTeam);

     match.setTeam2(secondInningTeam);

     match.setToss_winner(person.getToss_winner());
     match.setToss_decision(person.getToss_decision());
     match.setResult(person.getResult());
     match.setMatchWinner(person.getWinner());
     match.setResult_margin(person.getResult_margin());
     match.setUmpire1(person.getUmpire1());
     match.setUmpire2(person.getUmpire2());

    return match;
  }

}
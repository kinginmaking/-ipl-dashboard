import { React, useEffect, useState } from "react";
import { MatchDetailCard } from "../components/MatchDetailCard";
import { MatchSmallCard } from "../components/MatchSmallCard";

export const TeamPage = () => {
  const [team, setTeam] = useState({ teamMatches: [] });

  useEffect(() => {
    const fetchMatches = async () => {
      console.log("inside fetchMatches");
      const response = await fetch(
        "http://localhost:8080/team/Kolkata Knight Riders"
      );
      const data = await response.json();
      console.log(data);
      setTeam(data);
    };
    fetchMatches();
  }, []);

  return (
    <div className="TeamPage">
      <h1>{team.teamName}</h1>
      <MatchDetailCard match={team.teamMatches[0]} />
      {team.teamMatches.slice(1).map((match) => (
        <MatchSmallCard match={match} />
      ))}
    </div>
  );
};

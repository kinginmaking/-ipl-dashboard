import { React, useEffect, useState } from "react";
import { MatchDetailCard } from "../components/MatchDetailCard";
import { MatchSmallCard } from "../components/MatchSmallCard";
import { useParams } from "react-router-dom";

export const TeamPage = () => {
  const [team, setTeam] = useState({ teamMatches: [] });
  const { teamName } = useParams();

  useEffect(() => {
    const fetchMatches = async () => {
      console.log("inside fetchMatches");
      const response = await fetch(`http://localhost:8080/team/${teamName}`);
      const data = await response.json();
      console.log(data);
      setTeam(data);
    };
    fetchMatches();
  }, [teamName]);

  if (!team || !team.teamName) return <h1>Team not found</h1>;

  return (
    <div className="TeamPage">
      <h1>{team.teamName}</h1>
      <MatchDetailCard teamName={team.teamName} match={team.teamMatches[0]} />
      {team.teamMatches.slice(1).map((match) => (
        <MatchSmallCard teamName={team.teamName} match={match} />
      ))}
    </div>
  );
};

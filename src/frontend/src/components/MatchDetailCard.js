import { React } from "react";
import { Link } from "react-router-dom";

export const MatchDetailCard = ({ teamName, match }) => {
  if (!match) return null;

  const otherTeam = teamName === match.team1 ? match.team2 : match.team1;
  const otherTeamRoute = `/teams/${otherTeam}`;
  return (
    <div className="MatchDetailCard">
      <h3>Latest matches</h3>

      <h1>
        vs <Link to={otherTeamRoute}>{otherTeam}</Link>
      </h1>
      <h2>{match.date}</h2>
      <h3>at {match.venue}</h3>
      <h3>
        {match.matchWinner} won by {match.result_margin} {match.result}
      </h3>
    </div>
  );
};

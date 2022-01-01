import { React } from 'react';
import { Link } from 'react-router-dom';

export const MatchSmallCard = ({teamName,match}) => {
  if(!match) return null;
  const otherTeam=match.team1===teamName ? match.team2 :match.team1
  const otherTeamRouts=`/teams/${otherTeam}`;
    return (
        <div className="MatchSmallCard">
          <h3>Vs <Link to={otherTeamRouts}>{otherTeam}</Link></h3>
          <p>{match.matchWinner} Won By {match.resultMargin} {match.result}</p>
        </div>
    );
}
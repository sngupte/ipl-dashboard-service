import { React } from 'react';
import { Link } from 'react-router-dom';

export const MatchDetailCard = ({teamName,match}) => {
   if(!match) return null;
   const otherTeam=match.team1===teamName ? match.team2 :match.team1
   const otherTeamRouts=`/teams/${otherTeam}`;
    return (
        <div className="MatchDetailCard">
            <h4>Latest Match</h4>
            <h1> Vs <Link to={otherTeamRouts}>{otherTeam}</Link></h1>
            <h2>{match.date}</h2>
            <h3>at {match.city}</h3>
            <p>{match.matchWinner} Won By {match.resultMargin} {match.result}</p>
        </div>
    );
}
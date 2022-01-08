import { React } from 'react';
import { Link } from 'react-router-dom';
import './MatchSmallCard.scss'

export const MatchSmallCard = ({teamName,match}) => {
  if(!match) return null;
  const otherTeam=match.team1===teamName ? match.team2 :match.team1
  const otherTeamRouts=`/teams/${otherTeam}`;
  const isMatchWon= match.matchWinner==teamName;
    return (
        <div className={isMatchWon ? 'MatchSmallCard won-card' : 'MatchSmallCard lost-card'}>
           <span className="vs">vs</span>
          <h3><Link to={otherTeamRouts}>{otherTeam}</Link></h3>
          <p className="match-result">{match.matchWinner} Won By {match.resultMargin} {match.result}</p>
        </div>
    );
}
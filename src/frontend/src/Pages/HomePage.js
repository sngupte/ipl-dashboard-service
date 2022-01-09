import { React, useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { useParams } from 'react-router-dom';
import { MatchDetailCard } from '../Components/MatchDetailsCard';
import { MatchSmallCard } from '../Components/MatchSmallCard';
import { PieChart } from 'react-minimal-pie-chart';
import './HomePage.scss';
import { TeamTile } from '../Components/TeamTile';

export const HomePage = () => {

    const [teams, setTeams] = useState([]);
    useEffect(
        () => {
            const fetchTeams = async () => {
                const response = await fetch(`http://localhost:8080/team`);
                const data = await response.json();
                console.log(data);
                setTeams(data);
            };
            fetchTeams();
        }, []
    );

    return (
        <div className="HomePage">
            <div className="header-section">
                <h1 className='app-name'> Saurabh IPL Dashboard </h1>
            </div>
            <div className="team-grid">{teams.map(team => <TeamTile teamName={team.teamName} />)}</div>
        </div>
    );
}
package io.ipl.ipldashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.ipl.ipldashboard.model.Team;
import io.ipl.ipldashboard.repository.MatchRepository;
import io.ipl.ipldashboard.repository.TeamRepository;

@RestController
@CrossOrigin
public class TeamController {

	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private MatchRepository matchRepository;

	

	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String teamName) {
		System.out.println(teamName);
		Team team = teamRepository.findByTeamName(teamName);
		team.setMatches(matchRepository.findLatestMatchesByTeam(teamName, 4));
		return team;
	} 

}

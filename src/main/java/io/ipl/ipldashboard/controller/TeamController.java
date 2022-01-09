package io.ipl.ipldashboard.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.ipl.ipldashboard.model.Match;
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

	@GetMapping("/team")
	public Iterable<Team> getAllTeam(){
		return teamRepository.findAll();
	}
	

	@GetMapping("/team/{teamName}/matches")
	public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {
		LocalDate startDate = LocalDate.of(year, 1, 1);
		LocalDate endDate = LocalDate.of(year + 1, 1, 1);
		List<Match> matchList = matchRepository.getMatchesByTeamBetweenDates(teamName, startDate, endDate);
		System.out.println(matchList);
		return matchList;
	}

}

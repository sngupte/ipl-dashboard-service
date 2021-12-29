package io.ipl.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;

import io.ipl.ipldashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

	Team findByTeamName(String teamName);
}

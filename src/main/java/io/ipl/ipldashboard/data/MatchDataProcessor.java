package io.ipl.ipldashboard.data;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import io.ipl.ipldashboard.model.Match;

public class MatchDataProcessor implements ItemProcessor<Matchinput, Match> {

	private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

	@Override
	public Match process(final Matchinput matchinput) throws Exception {
		Match match = new Match();
		match.setId(Long.parseLong(matchinput.getId()));
		match.setCity(matchinput.getCity());
		match.setDate(LocalDate.parse(matchinput.getDate()));
		match.setPlayerOfMatch(match.getPlayerOfMatch());
		String firstInningsTeam, secoundInningsTeam;
		if ("bat".equals(matchinput.getToss_winner())) {
			firstInningsTeam = matchinput.getToss_decision();
			secoundInningsTeam = matchinput.getToss_winner().equals(matchinput.getTeam1()) ? matchinput.getTeam2()
					: matchinput.getTeam1();
		} else {
			secoundInningsTeam = matchinput.getToss_winner();
			firstInningsTeam = matchinput.getToss_winner().equals(matchinput.getTeam1()) ? matchinput.getTeam2()
					: matchinput.getTeam1();

		}
		match.setTeam1(firstInningsTeam);
		match.setTeam2(secoundInningsTeam);
		match.setTossWinner(matchinput.getToss_winner());
		match.setMatchWinner(matchinput.getWinner());
		match.setTossDecision(matchinput.getToss_decision());
		match.setResultMargin(matchinput.getResult_margin());
		match.setResult(matchinput.getResult());
		match.setUmpire1(matchinput.getUmpire1());
		match.setUmpire2(matchinput.getUmpire2());
		return match;
	}

}

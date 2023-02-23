package com.example.amf.edu.monolithic.service;

import com.example.amf.edu.monolithic.domain.model.Team;

import java.util.List;

public interface TeamService {
	List<Team> selectAllTeams();
	Team selectTeamById(Long id);

    Team createTeam(Team team);

	Team updateTeam(Long teamId, Team team);

	Boolean deleteTeam(Long teamId);
}

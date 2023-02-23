package com.example.amf.edu.monolithic.service.impl;

import com.example.amf.edu.monolithic.domain.model.Team;
import com.example.amf.edu.monolithic.domain.repository.TeamRepository;
import com.example.amf.edu.monolithic.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {
	private final TeamRepository teamRepository;

	@Override
	public List<Team> selectAllTeams() {
		return teamRepository.selectAllTeam();
	}

	@Override
	public Team selectTeamById(Long id) {
		return teamRepository.selectTeamById(id);
	}

	@Override
	public Team createTeam(Team team) {
		Integer result = teamRepository.createTeam(team);
		if (result == null || 0 == result) {
			return null;
		}
		return selectTeamById(team.getId());
	}

	@Override
	public Team updateTeam(Long teamId, Team team) {
		Integer result = teamRepository.updateTeam(teamId, team);
		if (result == null || 0 == result) {
			return null;
		}
		return selectTeamById(team.getId());
	}

	@Override
	public Boolean deleteTeam(Long teamId) {
		Integer result = teamRepository.deleteTeam(teamId);
		return result != null && 0 != result;
	}

}

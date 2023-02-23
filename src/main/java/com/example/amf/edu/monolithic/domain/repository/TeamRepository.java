package com.example.amf.edu.monolithic.domain.repository;

import com.example.amf.edu.monolithic.domain.model.Team;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeamRepository {
	List<Team> selectAllTeam();
	Team selectTeamById(Long id);

    Integer createTeam(Team team);

	Integer updateTeam(Long teamId, Team team);

	Integer deleteTeam(Long teamId);
}

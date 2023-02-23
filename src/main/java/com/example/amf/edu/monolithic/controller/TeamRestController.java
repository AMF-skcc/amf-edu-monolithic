package com.example.amf.edu.monolithic.controller;

import com.example.amf.edu.monolithic.domain.model.Team;
import com.example.amf.edu.monolithic.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class TeamRestController {
	private final TeamService teamService;

	@GetMapping("/teams")
    public ResponseEntity<List<Team>> selectAllTeams() {
        List<Team> members = teamService.selectAllTeams();
        return ResponseEntity.ok().body(members);
    }

	@GetMapping("/teams/{teamId}")
    public ResponseEntity<Team> selectTeamById(@PathVariable Long teamId) {
        Team member = teamService.selectTeamById(teamId);
        return ResponseEntity.ok().body(member);
    }

    @PostMapping("/teams")
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        Team savedTeam = teamService.createTeam(team);
        return ResponseEntity.ok().body(savedTeam);
    }

    @PutMapping("/teams/{teamId}")
    public ResponseEntity<Team> updateTeam(@RequestBody Team team, @PathVariable Long teamId) {
        if (teamId == null || !teamId.equals(team.getId())) {
            return ResponseEntity.badRequest().body(null);
        }
        Team savedTeam = teamService.updateTeam(teamId, team);
        return ResponseEntity.ok().body(savedTeam);
    }

    @DeleteMapping("/teams/{teamId}")
    public ResponseEntity<Boolean> deleteTeam(@PathVariable Long teamId) {
        Boolean success = teamService.deleteTeam(teamId);
        return ResponseEntity.ok().body(success);
    }
}

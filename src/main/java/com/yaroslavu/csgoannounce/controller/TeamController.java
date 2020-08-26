package com.yaroslavu.csgoannounce.controller;

import com.yaroslavu.csgoannounce.controller.exception.TeamNotFoundException;
import com.yaroslavu.csgoannounce.model.Team;
import com.yaroslavu.csgoannounce.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team/")
public class TeamController {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("{id}")
    public Team getTeam(@PathVariable Long id) throws TeamNotFoundException {
        return teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
    }

    @PostMapping
    public Team addTeam(@RequestBody Team team) throws TeamNotFoundException {
        team.getLogo().setTeam(team);
        Team savedTeam = teamRepository.save(team);
        return getTeam(savedTeam.getId());
    }
}

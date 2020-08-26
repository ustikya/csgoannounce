package com.yaroslavu.csgoannounce.controller;

import com.yaroslavu.csgoannounce.controller.exception.TeamNotFoundException;
import com.yaroslavu.csgoannounce.model.Team;
import com.yaroslavu.csgoannounce.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team/")
public class TeamController implements ResourceController<Team> {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> get() {
        return teamRepository.findAll();
    }

    @Override
    public Team get(Long id) throws TeamNotFoundException {
        return teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
    }

    @Override
    public Team add(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team update(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void delete(Team team) throws TeamNotFoundException {
        teamRepository.findById(team.getId()).orElseThrow(() -> new TeamNotFoundException(team.getId()));
        teamRepository.delete(team);
    }
}

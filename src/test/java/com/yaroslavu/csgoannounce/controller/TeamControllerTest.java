package com.yaroslavu.csgoannounce.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaroslavu.csgoannounce.model.Logo;
import com.yaroslavu.csgoannounce.model.Team;
import com.yaroslavu.csgoannounce.repository.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TeamController.class)
public class TeamControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    TeamRepository teamRepository;

    @Test
    public void getTeamShouldReturnTeam() throws Exception {
        Team team = Team.builder().id(0L).logo(new Logo()).name("navi").build();

        when(teamRepository.findById(team.getId())).thenReturn(java.util.Optional.of(team));

        mvc.perform(get("/team/" + team.getId()))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(team)));
    }

    @Test
    public void getTeamShouldReturnTeamNotFoundErrorMessage() throws Exception {
        Team team = Team.builder().id(0L).logo(new Logo()).name("navi").build();

        when(teamRepository.findById(team.getId())).thenReturn(Optional.empty());

        mvc.perform(get("/team/" + team.getId()))
                .andExpect(status().isNotFound());
    }
}

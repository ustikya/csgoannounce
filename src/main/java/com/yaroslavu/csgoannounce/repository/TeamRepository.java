package com.yaroslavu.csgoannounce.repository;

import com.yaroslavu.csgoannounce.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}

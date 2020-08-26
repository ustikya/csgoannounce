package com.yaroslavu.csgoannounce.repository;

import com.yaroslavu.csgoannounce.model.Logo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogoRepository extends JpaRepository<Logo, Long> {
}

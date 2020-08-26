package com.yaroslavu.csgoannounce.controller;

import com.yaroslavu.csgoannounce.controller.exception.LogoNotFoundException;
import com.yaroslavu.csgoannounce.model.Logo;
import com.yaroslavu.csgoannounce.repository.LogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logo/")
public class LogoController {
    private final LogoRepository logoRepository;

    @Autowired
    public LogoController(LogoRepository logoRepository) {
        this.logoRepository = logoRepository;
    }

    @GetMapping("{id}")
    public Logo getTeam(@PathVariable Long id) throws LogoNotFoundException {
        return logoRepository.findById(id).orElseThrow(() -> new LogoNotFoundException(id));
    }

    @PostMapping
    public Logo addTeam(@RequestBody Logo logo) {
        return logoRepository.save(logo);
    }
}

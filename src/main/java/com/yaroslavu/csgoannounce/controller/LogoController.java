package com.yaroslavu.csgoannounce.controller;

import com.yaroslavu.csgoannounce.controller.exception.LogoNotFoundException;
import com.yaroslavu.csgoannounce.model.Logo;
import com.yaroslavu.csgoannounce.repository.LogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logo/")
public class LogoController implements ResourceController<Logo>{
    private final LogoRepository logoRepository;

    @Autowired
    public LogoController(LogoRepository logoRepository) {
        this.logoRepository = logoRepository;
    }

    @Override
    public List<Logo> get() {
        return logoRepository.findAll();
    }

    @GetMapping("{id}")
    public Logo get(@PathVariable Long id) throws LogoNotFoundException {
        return logoRepository.findById(id).orElseThrow(() -> new LogoNotFoundException(id));
    }

    @PostMapping
    public Logo add(@RequestBody Logo logo) {
        return logoRepository.save(logo);
    }

    @Override
    public Logo update(Logo logo) {
        return logoRepository.save(logo);
    }

    @Override
    public void delete(Logo logo) throws LogoNotFoundException {
        logoRepository.findById(logo.getId()).orElseThrow(() -> new LogoNotFoundException(logo.getId()));
        logoRepository.delete(logo);
    }
}

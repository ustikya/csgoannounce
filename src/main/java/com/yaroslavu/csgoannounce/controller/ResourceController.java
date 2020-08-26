package com.yaroslavu.csgoannounce.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ResourceController<T> {
    @GetMapping
    List<T> get();

    @GetMapping("{id}")
    T get(@PathVariable Long id) throws Exception;

    @PostMapping
    T add(@RequestBody T resource);

    @PutMapping
    T update(@RequestBody T resource);

    @DeleteMapping
    void delete(@RequestBody T resource) throws Exception;
}

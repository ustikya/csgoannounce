package com.yaroslavu.csgoannounce.controller.exception;

public class TeamNotFoundException extends Exception {
    public TeamNotFoundException(Long id) {
        super("Could not find a team with id = " + id);
    }
}

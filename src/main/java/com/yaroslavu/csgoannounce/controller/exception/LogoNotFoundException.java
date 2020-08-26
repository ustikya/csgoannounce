package com.yaroslavu.csgoannounce.controller.exception;

public class LogoNotFoundException extends Exception {
    public LogoNotFoundException(Long id) {
        super("Could not find a logo with id = " + id);
    }
}

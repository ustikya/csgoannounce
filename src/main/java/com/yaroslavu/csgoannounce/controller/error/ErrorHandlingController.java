package com.yaroslavu.csgoannounce.controller.error;

import com.yaroslavu.csgoannounce.controller.exception.LogoNotFoundException;
import com.yaroslavu.csgoannounce.controller.exception.TeamNotFoundException;
import com.yaroslavu.csgoannounce.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandlingController {
    @ExceptionHandler({TeamNotFoundException.class, LogoNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleTeamNotFoundException(Exception exception, final HttpServletRequest request) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .path(request.getServletPath())
                .message(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value()).build(), HttpStatus.NOT_FOUND);
    }
}

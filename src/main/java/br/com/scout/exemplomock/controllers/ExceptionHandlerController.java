package br.com.scout.exemplomock.controllers;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<ExceptionResponseDTO> handleRunTimeException(final Exception e) {
        final ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(e.getMessage(), INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(exceptionResponse, INTERNAL_SERVER_ERROR);
    }
}

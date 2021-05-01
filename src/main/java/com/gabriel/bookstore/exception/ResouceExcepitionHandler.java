package com.gabriel.bookstore.exception;

// essa class é um manipulador de Excepition

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class ResouceExcepitionHandler {
    //  manipula a exceção da classe   ObjectNotFoundException
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError>
    ObjectNotFoundException(ObjectNotFoundException e, ServletRequest request) {
        StandardError error =
                new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    // manipula a exceção da classe  DataIntergrityViolationException
    @ExceptionHandler(DataIntergrityViolationException.class)
    public ResponseEntity<StandardError>
    dataIntergrityViolationException(DataIntergrityViolationException e, ServletRequest request) {
        StandardError error =
        new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),  e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }
}

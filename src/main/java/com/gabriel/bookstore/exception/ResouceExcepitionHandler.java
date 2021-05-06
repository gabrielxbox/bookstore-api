package com.gabriel.bookstore.exception;

// essa class é um manipulador de Excepition

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    // manipula a exceção da classe  DataIntergrityViolationException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError>
        validationError(MethodArgumentNotValidException e, ServletRequest request) {
        ValidationError error = new ValidationError(
                System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                "erro na validação dos campos");
        for (FieldError erro : e.getBindingResult().getFieldErrors()){
            error.addErrors(erro.getField(), erro.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}

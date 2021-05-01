package com.gabriel.bookstore.exception;

//para tratar quando for deletar categoria relacionada com livro
public class DataIntergrityViolationException  extends RuntimeException {

    public DataIntergrityViolationException(String message) {
        super(message);
    }

    public DataIntergrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}

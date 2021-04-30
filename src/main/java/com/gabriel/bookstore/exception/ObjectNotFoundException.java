package com.gabriel.bookstore.exception;

public class ObjectNotFoundException extends RuntimeException {

    // recebe a mensagem de error
    public ObjectNotFoundException(String message) {
        super(message);
    }
    // recebe a caussa
    public ObjectNotFoundException(Throwable cause) {
        super(cause);
    }
}

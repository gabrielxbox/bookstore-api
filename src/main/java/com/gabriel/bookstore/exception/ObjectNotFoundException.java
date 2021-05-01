package com.gabriel.bookstore.exception;

import java.io.Serializable;

public class ObjectNotFoundException extends RuntimeException implements Serializable {

    // recebe a mensagem de error
    public ObjectNotFoundException(String message) {
        super(message);
    }
    // recebe a caussa
    public ObjectNotFoundException(Throwable cause) {
        super(cause);
    }
}

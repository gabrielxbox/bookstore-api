package com.gabriel.bookstore.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMensage> errors = new ArrayList<FieldMensage>();

    public ValidationError() {
    }

    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }


    public List<FieldMensage> getErrors() {
        return errors;
    }
    // adicionando o erro de 1 por 1
    public void addErrors(String fieldName, String messagem) {
        this.errors.add(new FieldMensage(fieldName, messagem));
    }
}

package com.gabriel.bookstore.exception;

import java.io.Serializable;

public class FieldMensage  implements Serializable {

    private String fieldName;

    private String mensage;

    public FieldMensage() {
        super();
    }

    public FieldMensage(String fieldName, String mensage) {
        super();
        this.fieldName = fieldName;
        this.mensage = mensage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }
}

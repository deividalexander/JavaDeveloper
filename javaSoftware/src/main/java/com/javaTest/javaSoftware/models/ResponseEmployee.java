package com.javaTest.javaSoftware.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class ResponseEmployee<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -382161710004614538L;
    private String status;
    private T data;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

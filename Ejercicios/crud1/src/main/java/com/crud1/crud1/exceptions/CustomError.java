package com.crud1.crud1.exceptions;

import java.util.Date;

public class CustomError {
    private Date timestamp;
    private int httpCode;
    private String mensaje;


    public CustomError(Date timestamp, String mensaje, int httpCode){
        super();
        this.timestamp = timestamp;
        this.mensaje = mensaje;
        this.httpCode = httpCode;
    }
    public int getHttpCode() {
        return httpCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMensaje() {
        return mensaje;
    }
}



package com.crud1.crud1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IdNoEncontrada.class)
    public final ResponseEntity<CustomError> IdNoEncontradaException(IdNoEncontrada ex, WebRequest request) {
        CustomError customError = new CustomError(
                new Date(),
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UnprocesableException.class)
    public final ResponseEntity<CustomError> UnprocesableExceptionEx(UnprocesableException ex, WebRequest request) {
        CustomError customError = new CustomError(
                new Date(),
                ex.getMessage(),
                HttpStatus.UNPROCESSABLE_ENTITY.value()
        );

        return new ResponseEntity<>(customError,HttpStatus.UNPROCESSABLE_ENTITY);
    }

}

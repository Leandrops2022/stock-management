package com.example.stock_management.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedHashMap;

@RestControllerAdvice
public class RequestExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object>  SQLIntegrityConstraintViolationExceptionHandler (SQLIntegrityConstraintViolationException ex) {
        String message = "The request could not be processed. A unique field " +
                "value already registered might be the cause of the error. Verify the data and try again." ;
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ErrorResponseDTO(message));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> constraintViolationExceptionHandler (MethodArgumentNotValidException ex) {
        LinkedHashMap<String,String> errorsMap = new LinkedHashMap<>();

        ex.getFieldErrors().forEach(e-> {
            errorsMap.put(e.getField(), e.getDefaultMessage());
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ValidationErrorDTO(errorsMap));
    }
}

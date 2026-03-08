package com.padaria.pablo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("Timesatmp", LocalDateTime.now());
        body.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("Error", "erro interno no servidor!");
        body.put("Message", exception.getMessage());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("Timesatmp", LocalDateTime.now());
        body.put("Status", HttpStatus.BAD_REQUEST.value());
        body.put("Error", "erro de validacao!");

        Map<String, String> fieldErrors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach((error) ->
                fieldErrors.put(error.getField(), error.getDefaultMessage())
        );

        body.put("FieldErrors", fieldErrors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("Timesatmp", LocalDateTime.now());
        body.put("Status", HttpStatus.NOT_FOUND.value());
        body.put("Error", "Recurso não encontrado");
        body.put("Message", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}

package com.example.employeecrmangulardemo.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {
            Throwable.class
    })
    public ResponseEntity<CustomException> processExceptions(Throwable e) {

        CustomException response = CustomException.builder()
                .name(e.getClass().getSimpleName())
                .message(e.getCause().getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}

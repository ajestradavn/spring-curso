package com.example.demo.exceptionshandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.customexceptions.NotFoundException;

@ControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<?> handleConflict(NotFoundException ex, WebRequest request) {
 
        return ResponseEntity.status(404).body(null);
    }

}

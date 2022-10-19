package com.mtzz.workshop.resources.exceptions;

import com.mtzz.workshop.services.exceptions.ObjectNotFoundExcepetion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundExcepetion.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExcepetion e, HttpServletRequest request){
        HttpStatus stts = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(System.currentTimeMillis(), stts.value(), "Not found",
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(stts).body(error);
    }
}

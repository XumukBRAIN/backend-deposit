package com.andersenlab.depositservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class RestAppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CardNotFoundException.class)
    protected ResponseEntity<Object> handleCardNotFoundException(RuntimeException e, WebRequest request){
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), NOT_FOUND, request);
    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> handleBadRequestException(RuntimeException e, WebRequest request){
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), BAD_REQUEST, request);
    }

    @ExceptionHandler(InternalServerException.class)
    protected ResponseEntity<Object> handleInternalServerException(RuntimeException e, WebRequest request){
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), INTERNAL_SERVER_ERROR, request);
    }

}

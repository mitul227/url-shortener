package com.urlshortener.main.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UrlServiceException.class)
    private ResponseEntity handleException(UrlServiceException e) {
        Map<String, String> body = new HashMap<>();
        body.put("message", e.errorCode.name());
        return new ResponseEntity(body, e.errorCode.getHttpStatus());
    }
}

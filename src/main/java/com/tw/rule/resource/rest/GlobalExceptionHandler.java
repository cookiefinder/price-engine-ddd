package com.tw.rule.resource.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public void handle(Exception ex) {
        log.warn("[GlobalExceptionHandler] {}", ex.getMessage(), ex);
    }
}
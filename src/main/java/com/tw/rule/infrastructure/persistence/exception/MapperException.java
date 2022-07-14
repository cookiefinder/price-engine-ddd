package com.tw.rule.infrastructure.persistence.exception;

public class MapperException extends RuntimeException {
    public MapperException() {
    }

    public MapperException(String message, Throwable cause) {
        super(message, cause);
    }
}

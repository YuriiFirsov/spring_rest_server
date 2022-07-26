package com.spring.rest.exception_handling;

public class NoSuchWorkerException extends RuntimeException{
    public NoSuchWorkerException(String message) {
        super(message);
    }
}

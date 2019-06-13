package com.hello.exception;

public class AException extends Exception {
    public AException() {
    }

    public AException(String message) {
        super(message);
    }

    public AException(String message, Throwable cause) {
        super(message, cause);
    }
}

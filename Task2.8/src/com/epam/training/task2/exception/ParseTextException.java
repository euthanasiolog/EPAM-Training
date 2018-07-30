package com.epam.training.task2.exception;

public class ParseTextException extends Exception {
    public ParseTextException() {
    }

    public ParseTextException(String message) {
        super(message);
    }

    public ParseTextException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParseTextException(Throwable cause) {
        super(cause);
    }

    public ParseTextException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

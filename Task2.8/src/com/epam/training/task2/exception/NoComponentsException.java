package com.epam.training.task2.exception;

public class NoComponentsException extends Exception{
    public NoComponentsException() {
    }

    public NoComponentsException(String message) {
        super(message);
    }

    public NoComponentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoComponentsException(Throwable cause) {
        super(cause);
    }

    public NoComponentsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

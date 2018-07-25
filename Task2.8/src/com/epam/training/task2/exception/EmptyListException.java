package com.epam.training.task2.exception;

/**
 * EmptyListException is the class-exception which throws the exception when user tries to work with empty list of
 * lines.
 *
 * 16 July 2018
 * @author Arthur Lyup
 */

public class EmptyListException extends Exception {
    public EmptyListException(String msg){
        super(msg);
    }
}

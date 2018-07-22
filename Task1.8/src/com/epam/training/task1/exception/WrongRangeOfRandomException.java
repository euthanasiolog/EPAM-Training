package com.epam.training.task1.exception;

/**
 * WrongRangeOfRandomException is the class-exception which throws the exception when user tries to random wrong
 * options.
 *
 * 18 July 2018
 * @author Arthur Lyup
 */

public class WrongRangeOfRandomException extends Exception {
    private int leftBorder;
    private int rightBorder;

    public WrongRangeOfRandomException(){}

    public WrongRangeOfRandomException(String msg){
        super(msg);
    }

    public WrongRangeOfRandomException(String msg, int leftBorder, int rightBorder){
        super(msg);
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
    }

    public WrongRangeOfRandomException(String msg, Exception e){
        super(msg, e);
    }
}

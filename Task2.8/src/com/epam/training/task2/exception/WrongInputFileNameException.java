package com.epam.training.task2.exception;

/**
 * WrongInputFileNameException is the class-exception which throws the exception when user enters a wrong input file
 * name.
 *
 * 16 July 2018
 * @author Arthur Lyup
 */

public class WrongInputFileNameException extends Exception {
    private String fileName;

    public WrongInputFileNameException(String msg, String fileName){
        super(msg);
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }
}

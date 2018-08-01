package com.epam.training.task2.service.parse;

public abstract class BaseParser implements Parser {
    protected Parser next;

    public void setNext(Parser next) {
        this.next = next;
    }
}

package com.epam.training.task2.service.parse;

import org.apache.log4j.Logger;

public abstract class BaseParser implements Parser {
    //link to next parser
    protected Parser next;
    //logging information
    protected static final Logger LOG = Logger.getLogger(BaseParser.class);

    public void setNext(Parser next) {
        this.next = next;
    }
}

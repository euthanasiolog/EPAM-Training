package com.epam.training.task2.service.parse;

import com.epam.training.task2.exception.ParseTextException;
import com.epam.training.task2.model.entity.composite.Component;

public interface Parser {
    void setNext(Parser parser);
    Component parse(String content) throws ParseTextException;
}

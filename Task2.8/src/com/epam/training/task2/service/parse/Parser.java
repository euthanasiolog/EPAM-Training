package com.epam.training.task2.service.parse;

import com.epam.training.task2.exception.ParseTextException;
import com.epam.training.task2.model.entity.composite.Composite;

public interface Parser {
    void setNext(Parser parser);
    Composite parse(String content) throws ParseTextException;
}

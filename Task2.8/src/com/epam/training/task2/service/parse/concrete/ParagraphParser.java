package com.epam.training.task2.service.parse.concrete;

import com.epam.training.task2.exception.ParseTextException;
import com.epam.training.task2.model.entity.composite.Component;
import com.epam.training.task2.model.entity.composite.Composite;
import com.epam.training.task2.service.parse.BaseParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends BaseParser {
    private static final String PARSE_TO_SENTENCES = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";
    @Override
    public Component parse(String paragraph) throws ParseTextException {
        if (paragraph.isEmpty()){
            throw new ParseTextException("Content is empty! Nothing to parse");
        }
        Pattern pattern = Pattern.compile(PARSE_TO_SENTENCES);
        Matcher matcher = pattern.matcher(paragraph.trim());
        Component sentences = new Composite();
        while (matcher.find()){
            sentences.addComponent(next.parse(matcher.group().trim()));
        }
        return sentences;
    }
}

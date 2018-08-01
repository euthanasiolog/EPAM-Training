package com.epam.training.task2.service.parse.concrete;

import com.epam.training.task2.exception.ParseTextException;
import com.epam.training.task2.model.entity.composite.Component;
import com.epam.training.task2.model.entity.composite.Composite;
import com.epam.training.task2.service.parse.BaseParser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends BaseParser {
    private static final String PARSE_TO_WORDS = "([^(\\s)]*)(\\s)*";
    @Override
    public Component parse(String sentence) throws ParseTextException {
        if (sentence.isEmpty()){
            throw new ParseTextException("Content is empty! Nothing to parse");
        }
        Pattern pattern = Pattern.compile(PARSE_TO_WORDS);
        Matcher matcher = pattern.matcher(sentence.trim());
        Component words = new Composite();
        while (matcher.find()){
            String word = matcher.group();
            if (!word.isEmpty()) {
                words.addComponent(next.parse(word));
            }
        }
        return words;
    }
}

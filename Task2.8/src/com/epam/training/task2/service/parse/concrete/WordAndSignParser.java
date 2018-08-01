package com.epam.training.task2.service.parse.concrete;

import com.epam.training.task2.exception.ParseTextException;
import com.epam.training.task2.model.entity.composite.Component;
import com.epam.training.task2.model.entity.composite.Composite;
import com.epam.training.task2.model.entity.composite.Leaf;
import com.epam.training.task2.service.parse.BaseParser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordAndSignParser extends BaseParser {
    private static final String PARSE_TO_SYMBOLS = ".{1}";

    @Override
    public Component parse(String wordWithSigns) throws ParseTextException {
        if (wordWithSigns.isEmpty()){
            throw new ParseTextException("Content is empty! Nothing to parse");
        }
        Pattern pattern = Pattern.compile(PARSE_TO_SYMBOLS);
        Matcher matcher = pattern.matcher(wordWithSigns);
        Component symbols = new Composite();
        while (matcher.find()){
            String symbol = matcher.group().trim();
            if (!symbol.isEmpty()) {
                symbols.addComponent(new Leaf(symbol));
            }
        }
        return symbols;
    }
}

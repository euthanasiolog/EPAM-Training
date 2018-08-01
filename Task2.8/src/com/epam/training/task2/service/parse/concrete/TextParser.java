package com.epam.training.task2.service.parse.concrete;

//import statements
import com.epam.training.task2.exception.ParseTextException;
import com.epam.training.task2.model.entity.composite.Component;
import com.epam.training.task2.model.entity.composite.Composite;
import com.epam.training.task2.model.entity.composite.Leaf;
import com.epam.training.task2.service.parse.BaseParser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser extends BaseParser {
    private static final String PARSE_TO_PARAGRAPHS_AND_LISTINGS = "([^(\\s{4}\\/\\*.+\\*\\/(?:(?:\\n.+)" +
            "|(\\n\\s{4}\\}))+)])(\\s*(.+))|(\\s{4}\\/\\*.+\\*\\/(?:(?:\\n.+)|(\\n\\s{4}\\}))+)";
    private static final String RECOGNIZE_LISTING = "(\\s{4}\\/\\*.+\\*\\/(?:(?:\\n.+)|(\\n\\s{4}\\}))+)";

    @Override
    public Component parse(String fileText) throws ParseTextException {
        if (fileText.isEmpty()){
            throw new ParseTextException("Content is empty! Nothing to parse");
        }
        Pattern pattern = Pattern.compile(PARSE_TO_PARAGRAPHS_AND_LISTINGS);
        Matcher matcher = pattern.matcher(fileText.trim());
        Component wholeText = new Composite();
        while(matcher.find()){
            String plotOfText = matcher.group();
            if (Pattern.matches(RECOGNIZE_LISTING, plotOfText)){
                wholeText.addComponent(new Leaf(plotOfText.trim()));
            } else {
                Component paragraph = next.parse(plotOfText.trim());
                wholeText.addComponent(paragraph);
            }
        }
        return wholeText;
    }
}
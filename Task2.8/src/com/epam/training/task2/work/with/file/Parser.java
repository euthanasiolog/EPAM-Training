package com.epam.training.task2.work.with.file;

//import statements
import com.epam.training.task2.exception.ParseTextException;
import com.epam.training.task2.model.entity.composite.Composite;
import com.epam.training.task2.model.entity.composite.leaf.Leaf;
import com.epam.training.task2.model.entity.composite.leaf.Lexeme;
import org.apache.log4j.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    //logger
    private static Logger LOG = Logger.getLogger(Parser.class);
    //regular expressions for parse
    private static final String PARSE_TO_PARAGRAPHS_AND_LISTING = "(\\s*(.+))([^(\\s*(Start listing)([^\\t]+)" +
            "(End listing)\\s)])|\\s*(Start listing)([^\\t]+)(End listing)";
    private static final String RECOGNIZE_LISTING = "\\s*(Start listing)([^\\t]+)(End listing)";
    private static final String PARSE_TO_SENTENCES = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";
    private static final String PARSE_TO_WORDS = "\\w+";

    public static Composite parseFile(String fileText) throws ParseTextException {
        if (fileText.isEmpty()){
            throw new ParseTextException("The file text is empty! Nothing to parse.");
        }
        Composite wholeText = new Composite();
        wholeText.addComponent(parseToParagraphsAndListings(fileText));
        return wholeText;
    }

    private static Composite parseToParagraphsAndListings(String fileText){
        LOG.info("Parsing to paragraphs and listings...");
        Pattern pattern = Pattern.compile(PARSE_TO_PARAGRAPHS_AND_LISTING);
        Matcher matcher = pattern.matcher(fileText);
        Composite paragraphsAndListings = new Composite();
        while (matcher.find()){
            String plotOfText = matcher.group();
            if (Pattern.matches(RECOGNIZE_LISTING, plotOfText)){
                paragraphsAndListings.addComponent(new Leaf(plotOfText.trim(), Lexeme.LISTING));
            } else {
                paragraphsAndListings.addComponent(new Leaf(plotOfText.trim(), Lexeme.PARAGRAPH));
                paragraphsAndListings.addComponent(parseParagraphToSentences(plotOfText));
            }
        }
        return paragraphsAndListings;
    }

    private static Composite parseParagraphToSentences(String paragraph){
        LOG.info("Parsing paragraphs to sentences...");
        Pattern pattern = Pattern.compile(PARSE_TO_SENTENCES);
        Matcher matcher = pattern.matcher(paragraph.trim());
        Composite sentences = new Composite();
        while(matcher.find()){
            sentences.addComponent(new Leaf(matcher.group(), Lexeme.SENTENCE));
            sentences.addComponent(parseSentenceToWords(matcher.group()));
        }
        return sentences;
    }

    private static Composite parseSentenceToWords(String sentence){
        LOG.info("Parsing sentences to words...");
        Pattern pattern = Pattern.compile(PARSE_TO_WORDS);
        Matcher matcher = pattern.matcher(sentence.trim());
        Composite words = new Composite();
        while(matcher.find()){
            words.addComponent(new Leaf(matcher.group(), Lexeme.WORD));
        }
        return words;
    }

    /*

    private static Composite parseWordsToWordsAndSigns(String word){
        Pattern pattern = Pattern.compile(PARSE_TO_WORDS_AND_SIGNS);
        Matcher matcher = pattern.matcher(word);
        Composite signs = new Composite();
        while (matcher.find()){
            signs.addComponent(parseToSymbol(matcher.group()));
        }
        return signs;
    }

    private static Composite parseToSymbol(String sign){
        Pattern pattern = Pattern.compile(PARSE_TO_SYMBOLS);
        Matcher matcher = pattern.matcher(sign);
        Composite symbols = new Composite();
        while(matcher.find()){
            symbols.addComponent(new Symbol(matcher.group()));
        }
        return symbols;
    }*/
}

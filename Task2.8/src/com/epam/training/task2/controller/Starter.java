package com.epam.training.task2.controller;

/**
 * Starter is the class-tester of business-logic.
 *
 * 1 August 2018
 * @version 1.2
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task2.exception.ParseTextException;
import com.epam.training.task2.model.entity.composite.Component;
import com.epam.training.task2.service.parse.Parser;
import com.epam.training.task2.service.parse.concrete.ParagraphParser;
import com.epam.training.task2.service.parse.concrete.SentenceParser;
import com.epam.training.task2.service.parse.concrete.TextParser;
import com.epam.training.task2.service.parse.concrete.WordAndSignParser;
import com.epam.training.task2.service.restore.FileRestorer;
import com.epam.training.task2.util.file.Printer;
import com.epam.training.task2.util.file.Reader;
import org.apache.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Starter {
    //log information
    private static Logger LOG = Logger.getLogger(Starter.class);

    public static void main(String[] args) {
        //path of input file
        String inputFilePath = "resources/Programming text.txt";
        try {
            LOG.info("Started reading file \"" + inputFilePath + "\"...");

            String inputFileTextToParse = Reader.readFile(inputFilePath);

            LOG.info("The file was read successfully. Printing it to console:\n" + inputFileTextToParse);

            String outputFilePathToPrintResultOfParsing = "resources/Result of parsing.txt";
            LOG.info("Started parsing file text and printing results to \"" + outputFilePathToPrintResultOfParsing
                    + "\"");

            //initialization of parsers. Chain of responsibility
            Parser textParser = new TextParser();
            Parser paragraphParser = new ParagraphParser();
            Parser sentenceParser = new SentenceParser();
            Parser wordAndSignParser = new WordAndSignParser();
            textParser.setNext(paragraphParser);
            paragraphParser.setNext(sentenceParser);
            sentenceParser.setNext(wordAndSignParser);
            Component resultOfParsing = textParser.parse(inputFileTextToParse);

            LOG.info("Parsing file was done successfully...");
            LOG.info("Printing result of parsing to file \"" + outputFilePathToPrintResultOfParsing + "\"...");
            Printer.writeToFile(resultOfParsing, outputFilePathToPrintResultOfParsing);
            LOG.info("Result of parsing was written successfully...");

            LOG.info("Restoring file by using parsed file...");
            String restoredFilePath = "resources/Restored programming text.txt";
            Component restoredFile = FileRestorer.restoreFile(outputFilePathToPrintResultOfParsing);
            Printer.writeToFile(restoredFile, restoredFilePath);

        } catch (FileNotFoundException e) {
            LOG.info(e.getMessage());
            LOG.error(e.getMessage(), e);
        } catch (IOException | ParseTextException e) {
            LOG.info(e.getMessage());
            LOG.error(e.getMessage(), e);
        } finally {
            LOG.info("The application stopped! Thank you for working with us:)");
        }
    }
}
package com.epam.training.task2.controller;

/**
 * Starter is the class-tester of business-logic.
 *
 * 30 July 2018
 * @version 1.0
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task2.exception.ParseTextException;
import com.epam.training.task2.model.entity.composite.Composite;
import com.epam.training.task2.work.with.file.Parser;
import com.epam.training.task2.work.with.file.Reader;
import com.epam.training.task2.work.with.file.Printer;
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
            String inputFileText = Reader.readFile(inputFilePath);
            LOG.info("The file was read successfully. Printing it to console:\n" + inputFileText);
            LOG.info("Started parsing file text...");
            Composite composite = Parser.parseFile(inputFileText);
            LOG.info("Parsing file was done successfully...");
            String outputFilePath = "resources/Result.txt";
            LOG.info("Printing result of parsing to file \"" + outputFilePath + "\"...");
            Printer.writeToFile(composite, outputFilePath);
            LOG.info("Result of parsing was written successfully...");
        } catch (FileNotFoundException e) {
            LOG.info(e.getMessage());
            LOG.error(e.getMessage(), e);
        } catch (IOException e) {
            LOG.info(e.getMessage());
            LOG.error(e.getMessage(), e);
        } catch (ParseTextException e) {
            LOG.info(e.getMessage());
            LOG.error(e.getMessage(), e);
        } finally {
            LOG.info("The application stopped! Thank you for working with us:)");
        }
    }
}


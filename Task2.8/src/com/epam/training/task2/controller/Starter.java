package com.epam.training.task2.controller;

/**
 * Starter is the class-tester of business-logic.
 *
 * -version 2.0
 * 25 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task2.exception.EmptyListException;
import com.epam.training.task2.exception.WrongInputFileNameException;
import com.epam.training.task2.model.entity.Word;
import com.epam.training.task2.logic.Sorter;
import com.epam.training.task2.work.with.file.reading.Reader;
import com.epam.training.task2.work.with.file.splitting.Splitter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Starter {
    public static void main(String[] args) {
        //name of input file
        String fileName = "resources/input.txt";
        try {
            //reading lines of input file and print them
            List<String> linesOfFile = Reader.readFile(fileName);
            System.out.println("Printing file:");
            for (String line : linesOfFile){
                System.out.println(line);
            }

            //splitting words and print them
            List<Word> words = new ArrayList<>();
            Splitter.getWords(linesOfFile, words);
            System.out.println("Words:");
            System.out.println(words);

            System.out.println("After sort words with first vowel letter by first consonant letter:");
            Sorter.sortWordsWithFirstVowelLetterByFirstConsonantLetter(words);
            System.out.println(words);
        } catch (IOException e) {
            System.err.println("The problem with file!");
        } catch (WrongInputFileNameException e) {
            System.err.println(e.getMessage() + e.getFileName());
        } catch (EmptyListException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("\nThe application was stopped! Thank you for working with us");
        }
    }
}

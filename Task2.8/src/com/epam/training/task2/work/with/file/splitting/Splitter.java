package com.epam.training.task2.work.with.file.splitting;

/**
 * Splitter is the class which splits lines into words by special dividers.
 *
 * 16 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task2.exception.EmptyListException;
import com.epam.training.task2.model.entity.Word;
import java.util.List;

public class Splitter {
    //line of dividers (regular expression)
    private static String dividers = "(\\W+|\\d+)";

    //method for splitting
    public static List<Word> getWords(List<String> linesOfFile, List<Word> words) throws EmptyListException {
        if (linesOfFile.isEmpty()){
            throw new EmptyListException("Lines of file are empty! Nothing to split.");
        }
        for (String line : linesOfFile){
            if (!line.isEmpty()) {
                String[] wordsInOneLine = line.split(dividers);
                for (String word : wordsInOneLine) {
                    if (!word.isEmpty()) {
                        words.add(new Word(word));
                    }
                }
            }
        }
        return words;
    }
}

package com.epam.training.task2.logic;

/**
 * Sorter is the class of business-logic which sorts words with the first vowel letter by first consonant letter.
 *
 * 16 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task2.exception.EmptyListException;
import com.epam.training.task2.model.entity.Word;
import java.util.Collections;
import java.util.List;

public class Sorter {
    //sort
    public static void sortWordsWithFirstVowelLetterByFirstConsonantLetter(List<Word> words) throws EmptyListException {
        if (words.isEmpty()){
            throw new EmptyListException("No words to sort!");
        }
        Collections.sort(words);
    }
}

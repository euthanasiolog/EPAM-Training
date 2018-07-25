package com.epam.training.task2.view;

/**
 * ConsoleWriter is the class which writes information to the console.
 *
 * 15 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task2.model.entity.Word;
import java.util.List;

public class ConsoleWriter {
    //printing file
    public static void printFile(List<String> linesOfFile){
        if (linesOfFile.size() == 0){
            System.out.println("Lines of file are empty! Nothing to print");
        } else {
            for (String line : linesOfFile){
                System.out.println(line);
            }
        }
    }

    //printing words of file
    public static void printWords(List<Word> words){
        if (words.size() == 0){
            System.out.println("No words! Nothing to print");
        } else {
            System.out.println(words);
        }
    }
}

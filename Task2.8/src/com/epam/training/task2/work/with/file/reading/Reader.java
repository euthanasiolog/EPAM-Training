package com.epam.training.task2.work.with.file.reading;

/**
 * Reader is the class which reads content of file.
 *
 * 16 July 2018
 * @author Arthur Lyup
 */

//import statements
import com.epam.training.task2.exception.WrongInputFileNameException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Reader {
    //reading file
    public static List<String> readFile(String fileName) throws IOException, WrongInputFileNameException {
        if (fileName.isEmpty()){
            throw new WrongInputFileNameException("Wrong input file name!: ", fileName);
        }
        return Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
    }
}

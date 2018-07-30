package com.epam.training.task2.work.with.file;

import com.epam.training.task2.model.entity.composite.Composite;

import java.io.FileWriter;
import java.io.IOException;

public class Printer {
    public static void writeToFile(Composite composite, String fileName){
        try(FileWriter fileWriter = new FileWriter(fileName, false)){
            fileWriter.write(composite.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.epam.training.task2.util.file;

import com.epam.training.task2.model.entity.composite.Component;
import java.io.FileWriter;
import java.io.IOException;

public class Printer {
    public static void writeToFile(Component component, String fileName){
        try(FileWriter fileWriter = new FileWriter(fileName, false)) {
            fileWriter.write(component.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

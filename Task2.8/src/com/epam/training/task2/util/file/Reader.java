package com.epam.training.task2.util.file;

//import statements
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Reader {
    public static String readFile(String filePath) throws IOException {
        String fileText;
        try(FileInputStream fileInputStream = new FileInputStream(filePath)) {
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            fileText = new String(bytes);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(filePath + "wasn't found!");
        } catch (IOException e) {
            throw new IOException(filePath + "isn't available!");
        }
        return fileText;
    }
}

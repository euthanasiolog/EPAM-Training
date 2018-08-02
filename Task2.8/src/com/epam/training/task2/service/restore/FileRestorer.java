package com.epam.training.task2.service.restore;

import com.epam.training.task2.model.entity.composite.Composite;
import com.epam.training.task2.model.entity.composite.Leaf;
import com.epam.training.task2.util.file.Reader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileRestorer {
    private static final String RECOGNIZE_PARAGRAPHS_AND_LISTINGS = "(Paragraph:.+)" +
            "|(Listing:\\n\\s{4}\\/\\*.+\\*\\/(?:(?:\\n.+)|(\\n\\s{4}\\}))+)";
    private static final String RECOGNIZE_PARAGRAPH = "(Paragraph:.+)";
    private static final int BEGIN_SUBSTRING_FOR_PARAGRAPHS = 10;
    private static final int BEGIN_SUBSTRING_FOR_LISTINGS = 8;

    public static Composite restoreFile(String parsedFile) throws IOException {
        Composite restoredFile = new Composite();
        try {
            String contentOfParsedFile = Reader.readFile(parsedFile);
            if (!contentOfParsedFile.isEmpty()){
                Pattern pattern = Pattern.compile(RECOGNIZE_PARAGRAPHS_AND_LISTINGS);
                Matcher matcher = pattern.matcher(contentOfParsedFile);
                while (matcher.find()){
                    String plotOfText = matcher.group();
                    if (Pattern.matches(RECOGNIZE_PARAGRAPH, plotOfText)){
                        plotOfText = plotOfText.substring(BEGIN_SUBSTRING_FOR_PARAGRAPHS);
                        restoredFile.addComponent(new Leaf("    " + plotOfText + "\n"));
                    } else {
                        plotOfText = plotOfText.substring(BEGIN_SUBSTRING_FOR_LISTINGS);
                        restoredFile.addComponent(new Leaf("    " + plotOfText + "\n"));
                    }
                }
            }
        } catch (IOException e) {
            throw new IOException("Error! Problem with file");
        }
        return restoredFile;
    }
}

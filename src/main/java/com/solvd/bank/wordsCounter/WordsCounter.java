package com.solvd.bank.wordsCounter;

import java.io.*;

import com.solvd.bank.workers.Archivist;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;


public class WordsCounter {
    private static final Logger LOGGER = LogManager.getLogger(WordsCounter.class);

    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void printResults() throws Exception {
        String string1 = "that";
        String string2 = "people";
        String string3 = "when";
        int counter1;
        int counter2;
        int counter3;
        try {
            String fileName = "D:\\\\Dev\\\\courses\\\\2\\\\src\\\\main\\\\resources\\\\inputFile.txt";
            String contents = readUsingFiles(fileName);
            counter1 = StringUtils.countMatches(contents.toLowerCase(Locale.ROOT), string1);
            counter2 = StringUtils.countMatches(contents.toLowerCase(Locale.ROOT), string2);
            counter3 = StringUtils.countMatches(contents.toLowerCase(Locale.ROOT), string3);
            try (FileWriter fw = new FileWriter("D:\\Dev\\courses\\2\\src\\main\\resources\\outputFile.txt",
                    true)) {
                fw.write("\nthat: " + "- " + counter1);
                fw.write("\npeople: " + "- " + counter2);
                fw.write("\nwhen: " + "- " + counter3);
            } catch (IOException ex) {
                LOGGER.info(ex.getMessage());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        printResults();
    }

}



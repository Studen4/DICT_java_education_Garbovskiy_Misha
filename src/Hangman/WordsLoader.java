package Hangman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class WordsLoader {
    private static final String FILE_PATH = "/home/misha/IdeaProjects/DICT_java_education_Garbovskiy_Misha/src/Hangman/Words.txt";

    public static String getRandomWord() {
        List<String> words = readWordsFromFile();
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    private static List<String> readWordsFromFile() {
        try {
            Path filePath = Paths.get(FILE_PATH);
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            System.err.println("Error reading words from file: " + e.getMessage());
            System.exit(1);
        }
        return List.of();
    }
}

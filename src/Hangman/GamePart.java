package Hangman;

import java.util.Arrays;
import java.util.Scanner;

public class GamePart {
    private final VisualPart visualPart;
    private String wordToGuess;
    private char[] guessedWord;
    private int remainingAttempts;

    public GamePart(VisualPart visualPart) {
        this.visualPart = visualPart;
    }

    public void startGame() {
        initializeGame();

        while (remainingAttempts > 0 && !isWordGuessed()) {
            visualPart.showGuessedWord(guessedWord);
            char guessedLetter = getUserInput();
            checkGuessedLetter(guessedLetter);
        }

        if (isWordGuessed()) {
            visualPart.showGameWon();
        } else {
            visualPart.showGameLost(wordToGuess);
        }
    }

    private void initializeGame() {
        wordToGuess = WordsLoader.getRandomWord();
        guessedWord = new char[wordToGuess.length()];
        Arrays.fill(guessedWord, '_');
        remainingAttempts = 8;
    }

    private char getUserInput() {
        Scanner scanner = new Scanner(System.in);
        char guessedLetter;

        do {
            visualPart.showRemainingAttempts(remainingAttempts);
            visualPart.showInputPrompt();
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                visualPart.showGoodbye();
                System.exit(0);
            }

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                visualPart.showInvalidInput();
                continue;
            }

            guessedLetter = input.charAt(0);

            if (hasGuessedLetter(guessedLetter)) {
                visualPart.showAlreadyGuessed();
            } else {
                break;
            }
        } while (true);

        return guessedLetter;
    }

    private boolean hasGuessedLetter(char letter) {
        for (char c : guessedWord) {
            if (c == letter) {
                return true;
            }
        }
        return false;
    }

    private void checkGuessedLetter(char letter) {
        boolean letterGuessed = false;

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                guessedWord[i] = letter;
                letterGuessed = true;
            }
        }

        if (!letterGuessed) {
            remainingAttempts--;
            visualPart.showIncorrectGuess(letter);
        }
    }

    private boolean isWordGuessed() {
        for (char c : guessedWord) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}

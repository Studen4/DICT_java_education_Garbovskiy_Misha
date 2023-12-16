package Hangman;

import java.util.Scanner;
public class VisualPart {
    private GamePart gamePart;

    public void setGamePart(GamePart gamePart) {
        this.gamePart = gamePart;
    }

    public void showMainMenu() {
        System.out.println("HANGMAN");
        System.out.println("Type \"play\" to play the game, \"exit\" to quit:");
        String input = getUserInput();

        if (input.equalsIgnoreCase("play")) {
            gamePart.startGame();
        } else if (input.equalsIgnoreCase("exit")) {
            showGoodbye();
            System.exit(0);
        } else {
            showInvalidInput();
            showMainMenu();
        }
    }


    public void showGuessedWord(char[] guessedWord) {
        System.out.println("Guessed word: " + new String(guessedWord));
    }

    public void showRemainingAttempts(int remainingAttempts) {
        System.out.println("You have " + remainingAttempts + " tries left.");
    }

    public void showIncorrectGuess(char letter) {
        System.out.println("Incorrect guess. Letter \"" + letter + "\" is not in the word.");
    }

    public void showGameWon() {
        System.out.println("Congratulations! You guessed the word!");
        showMainMenu();
    }

    public void showGameLost(String word) {
        System.out.println("You lost! The correct word was: " + word);
        showMainMenu();
    }

    public void showAlreadyGuessed() {
        System.out.println("You've already guessed this letter. Try another one.");
    }

    public void showInvalidInput() {
        System.out.println("Invalid input. Please enter a single letter.");
    }

    public void showGoodbye() {
        System.out.println("Goodbye, have a nice day!");
    }

    public void showInputPrompt() {
        System.out.print("Input a letter: ");
    }

    private String getUserInput() {
        return new Scanner(System.in).nextLine();
    }
}


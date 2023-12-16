package Hangman;

public class Main {
    public static void main(String[] args) {
        VisualPart visualPart = new VisualPart();
        GamePart gamePart = new GamePart(visualPart);

        visualPart.setGamePart(gamePart);

        visualPart.showMainMenu();
    }
}

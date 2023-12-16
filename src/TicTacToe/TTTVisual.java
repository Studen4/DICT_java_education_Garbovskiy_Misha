package TicTacToe;

import java.util.Scanner;
class TTTVisual {
    private static final Scanner scanner = new Scanner(System.in);

    public static int[] getPlayerMove() {
        System.out.print("Enter the coordinates (row and column): ");
        int[] coordinates = new int[2];
        coordinates[0] = scanner.nextInt() - 1;
        coordinates[1] = scanner.nextInt() - 1;
        return coordinates;
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}


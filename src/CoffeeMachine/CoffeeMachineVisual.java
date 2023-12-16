package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachineVisual {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getUserAction() {
        System.out.print("Write action (buy, fill, take, remaining, exit):\n> ");
        return scanner.nextLine();
    }

    public static String getCoffeeType() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:\n> ");
        return scanner.nextLine();
    }

    public static int getIngredientAmount(String ingredient) {
        System.out.printf("Write how many %s do you want to add:\n> ", ingredient);
        return Integer.parseInt(scanner.nextLine());
    }
}
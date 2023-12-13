
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        System.out.println("Hello! My name is MyBot.");
        System.out.println("I was created in 2023.");
        System.out.println("Victory");
        System.out.println("Victory 2 part");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, remind me your name.");
        String userName = scanner.nextLine();
        System.out.println("What a great name you have, " + userName + "!");

        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5, and 7.");

        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();

        int yourAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        System.out.println("Your age is " + yourAge + "; that's a good time to start programming!");

        System.out.println("Now I will prove to you that I can count to any number you want!");
        int userInp = scanner.nextInt();

        System.out.println("Let me count to " + userInp + "!");
        for (int i = 1; i <= userInp; i++) {
            System.out.println(i + "!");
        }

        System.out.println("Let's test your programming knowledge.");
        System.out.println("What means by \"Java\" word?");
        System.out.println("1. Useless");
        System.out.println("2. Completely useless");
        System.out.println("3. Amazing programming language");
        System.out.println("4. 100% useless");

        int userAnswer;

        do {
            userAnswer = scanner.nextInt();

            if (userAnswer != 3) {
                System.out.println("Please, try again. Your answer is incorrect.");
            }
        } while (userAnswer != 3);

        System.out.println("Congratulations! Your answer is correct.");
        System.out.println("Goodbye, have a nice day!");
    }
}
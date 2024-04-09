package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void greeting() {
        System.out.println("\n" + "Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = SCANNER.nextLine();
        System.out.println("Hello, " + userName + "!");

        SCANNER.close();
    }
}

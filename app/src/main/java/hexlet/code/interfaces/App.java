package hexlet.code.interfaces;

import hexlet.code.games.Even;
import java.util.Scanner;


public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter the game number and press Enter.");
        String listOfGames = "1 - Greet ,2 - Even ,3 - Calc ,4 - GCD ,5 - Progression ,6 - Prime ,0 - Exit";
        System.out.println(listOfGames.replaceAll(",", "\n"));


        System.out.print("Your choice: ");
        String userChoice = SCANNER.nextLine();

        switch (userChoice) {
            case "1":
                Cli.greeting();
                break;
            case "2":
                Even.evenGameStart();
                break;
            default:
                System.out.println("Nonexistent selection. Please, try again.");
        }

    }
}

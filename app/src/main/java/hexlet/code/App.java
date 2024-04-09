package hexlet.code;

import hexlet.code.games.ArithmeticProgression;
import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.GreatestCommonDivider;
import hexlet.code.games.PrimeNumber;

import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        String listOfGames = "1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit";
        System.out.println(listOfGames);

        System.out.print("Your choice: ");
        String userChoice = scanner.nextLine();

        switch (userChoice) {
            case "1":
                Cli.greeting();
                break;
            case "2":
                Even.launchEvenGame();
                break;
            case "3":
                Calculator.launchExpressionGame();
                break;
            case "4":
                GreatestCommonDivider.launchGCDGame();
                break;
            case "5":
                ArithmeticProgression.launchExpressionGame();
                break;
            case "6":
                PrimeNumber.launchEvenGame();
                break;
            case "0":
                System.out.println("See you later. Bye.");
                break;
            default:
                System.out.println("Nonexistent selection. Please, try again.");
                break;
        }

    }
}

package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");

        String[] listOfGames = new String[]{"1 - Greet", "0 - Exit"};
        for (String game : listOfGames) {
            System.out.println(game);
        }

        System.out.print("Your choice: ");
        String userChoice = scanner.next();

        switch (userChoice) {
            case "1":
                Cli.greeting();
                break;
            case "0":
                break;
            default:
                System.out.println("Choice is outside of the presented");
        }

        scanner.close();
    }
}

package hexlet.code.interfaces;

import java.util.Scanner;

public class Engine {
    private static final int POINTS_TO_WIN = 3;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static String username;

    public static void checkResponseCorrectness(String gameTitle, String[][] gameData) {
        gamesPresentation();
        userNameRequest();
        outputGameRules(gameTitle);

        String answer;
        String correctAnswer;
        int userWinsCount = 0;
        for (String[] gameDatum : gameData) {
            String question = gameDatum[0];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            answer = SCANNER.nextLine();
            correctAnswer = gameDatum[1];

            if (!answer.equals(correctAnswer)) {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + correctAnswer + "'.\n" + "Let's try again, " + username);
                break;
            } else {
                userWinsCount++;
                System.out.println("Correct!");
            }

            if (userWinsCount == POINTS_TO_WIN) {
                System.out.println("Congratulations, " + username + "!");
            }

        }
    }

    private static void gamesPresentation() {
        System.out.println("\n" + "Welcome to the Brain Games!");

    }

    private static void userNameRequest() {
        System.out.print("May I have your name? ");
        username = SCANNER.nextLine();
        System.out.println("Hello, " + username + "!");

    }

    private static void outputGameRules(String gameTitle) {
        System.out.println(gameTitle);
    }
}

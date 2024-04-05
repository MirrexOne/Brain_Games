package hexlet.code.interfaces;

import java.util.Scanner;

public class Engine {
    private static final int POINTS_TO_WIN = 3;
    private static final Scanner SCANNER = new Scanner(System.in);


    public static void checkResponseCorrectness(String gameRules, String[][] gameData) {
        System.out.println("\n" + "Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String username = SCANNER.nextLine();
        System.out.println("Hello, " + username + "!");
        System.out.println(gameRules);

        String correctAnswer;
        String answer;
        int userWinsCount = 0;
        for (String[] gameDatum : gameData) {
            String question = gameDatum[0];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            answer = SCANNER.nextLine();
            correctAnswer = gameDatum[1];

            if (!answer.equals(correctAnswer)) {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + correctAnswer + "'.\n" + "Let's try again, " + username + "!");
                return;
            } else {
                userWinsCount++;
                System.out.println("Correct!");
            }

            if (userWinsCount == POINTS_TO_WIN) {
                System.out.println("Congratulations, " + username + "!");
            }
        }
    }
}

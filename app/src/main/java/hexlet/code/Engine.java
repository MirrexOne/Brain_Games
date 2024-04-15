package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int POINTS_TO_WIN = 3;

    public static void checkResponseCorrectness(String gameRules, String[][] gameData) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + "Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String username = scanner.nextLine();
        System.out.println("Hello, " + username + "!");
        System.out.println(gameRules);

        String correctAnswer;
        String answer;
        for (String[] gameDatum : gameData) {
            String question = gameDatum[0];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            answer = scanner.nextLine();
            correctAnswer = gameDatum[1];

            if (!answer.equals(correctAnswer)) {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + correctAnswer + "'.\n" + "Let's try again, " + username + "!");
                return;
            } else {
                System.out.println("Correct!");
            }
        }

        System.out.println("Congratulations, " + username + "!");
    }
}

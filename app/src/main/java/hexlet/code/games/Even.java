package hexlet.code.games;


import hexlet.code.interfaces.Engine;
import hexlet.code.interfaces.Utils;

public class Even {

    private static final String GAME_RULES_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int QUANTITY_OF_QUESTIONS = 3;
    private static final int PAIRS_QUESTION_ANSWER = 2;
    public static void launchEvenGame() {
        String[][] gameData = generateGameData();
        Engine.launchEngine(GAME_RULES_DESCRIPTION, gameData);
    }

    private static String[][] generateGameData() {
        String[][] gameData = new String[QUANTITY_OF_QUESTIONS][PAIRS_QUESTION_ANSWER];

        for (int i = 0; i < gameData.length; i++) {
            String question = String.valueOf(Utils.generateRandomNumber());
            String correctAnswer = providesCorrectAnswer(question) ? "yes" : "no";
            gameData[i][0] = question;
            gameData[i][1] = correctAnswer;

        }
        return gameData;
    }

    static boolean providesCorrectAnswer(String question) {
        return Integer.parseInt(question) % 2 == 0;
    }

}

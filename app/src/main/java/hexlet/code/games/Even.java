package hexlet.code.games;


import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {

    private static final String GAME_RULES_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int QUANTITY_OF_QUESTIONS = Engine.POINTS_TO_WIN;
    private static final int PAIRS_QUESTION_ANSWER = 2;

    public static void launchEvenGame() {
        String[][] gameData = generateGameData();
        Engine.checkResponseCorrectness(GAME_RULES_DESCRIPTION, gameData);
    }

    private static String[][] generateGameData() {
        String[][] gameData = new String[QUANTITY_OF_QUESTIONS][PAIRS_QUESTION_ANSWER];

        for (int i = 0; i < gameData.length; i++) {
            int question = Utils.generateRandomNumber();
            String correctAnswer = isEven(question) ? "yes" : "no";
            gameData[i][0] = String.valueOf(question);
            gameData[i][1] = correctAnswer;

        }
        return gameData;
    }

    static boolean isEven(int number) {
        return number % 2 == 0;
    }

}

package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GreatestCommonDivider {
    private static final String GAME_RULES_DESCRIPTION = "Find the greatest common divisor of given numbers.";

    private static final int QUANTITY_OF_QUESTIONS = Engine.POINTS_TO_WIN;
    private static final int PAIRS_QUESTION_ANSWER = 2;

    public static void launchGCDGame() {
        String[][] gameData = generateGameData();
        Engine.checkResponseCorrectness(GAME_RULES_DESCRIPTION, gameData);
    }

    private static String[][] generateGameData() {
        String[][] gameData = new String[QUANTITY_OF_QUESTIONS][PAIRS_QUESTION_ANSWER];

        for (int i = 0; i < gameData.length; i++) {
            int[] randomNumbers = new int[]{Utils.generateRandomNumber(), Utils.generateRandomNumber()};
            String randomOperands = randomNumbers[0] + " " + randomNumbers[1];
            String correctAnswer = String.valueOf(searchCommonDivisor(randomNumbers[0], randomNumbers[1]));
            gameData[i][0] = randomOperands;
            gameData[i][1] = correctAnswer;

        }
        return gameData;
    }

    private static int searchCommonDivisor(int dividend, int divisor) {
        return divisor == 0 ? dividend : searchCommonDivisor(divisor, dividend % divisor);
    }

}

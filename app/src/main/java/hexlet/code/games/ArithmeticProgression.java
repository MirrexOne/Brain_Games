package hexlet.code.games;

import hexlet.code.interfaces.Engine;
import hexlet.code.interfaces.Utils;

import java.lang.reflect.Array;

public class ArithmeticProgression {

    private static final String GAME_RULES_DESCRIPTION = "What number is missing in the progression?";
    private static final int QUANTITY_OF_QUESTIONS = 3;
    private static final int PAIRS_QUESTION_ANSWER = 2;
    private static final int LOWER_BOUND_SIZE = 5;
    private static final int UPPER_BOUND_SIZE = 10;
    private static final int GENERATION_CAP_DIFFERENCE = 5;

    public static void launchExpressionGame() {
        String[][] gameData = generateGameData();
        Engine.checkResponseCorrectness(GAME_RULES_DESCRIPTION, gameData);
    }

    private static String[][] generateGameData() {
        String[][] gameData = new String[QUANTITY_OF_QUESTIONS][PAIRS_QUESTION_ANSWER];

        for (int i = 0; i < gameData.length; i++) {
            int sequenceStep = Utils.generateRandomNumber(GENERATION_CAP_DIFFERENCE);
            int progressionSize = Utils.generateRandomNumber(LOWER_BOUND_SIZE, UPPER_BOUND_SIZE);
            String[] progression = generateProgression(Utils.generateRandomNumber(), sequenceStep, progressionSize);
            int randomIndex = Utils.generateRandomNumber(progression.length);
            String correctHiddenNumber = (String) Array.get(progression, randomIndex);
            String question = convertToString(progression).replace(correctHiddenNumber, "..");
            gameData[i][0] = question;
            gameData[i][1] = correctHiddenNumber;

        }
        return gameData;
    }

    private static String[] generateProgression(int initialValue, int difference, int progressionLength) {


        StringBuilder progression = new StringBuilder();
        int nextValue;
        progression.append(initialValue);
        nextValue = initialValue;
        while (progressionLength != 0) {
            nextValue += difference;
            progression.append(" ").append(nextValue);
            progressionLength--;
        }
        return progression.toString().split(" ");
    }

    private static String convertToString(String[] progressionArray) {
        StringBuilder builder = new StringBuilder();
        for (String value : progressionArray) {
            builder.append(value).append(" ");
        }
        return builder.toString();
    }

}

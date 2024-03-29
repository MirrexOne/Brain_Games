package hexlet.code.games;

import hexlet.code.interfaces.Engine;
import hexlet.code.interfaces.Utils;

import java.lang.reflect.Array;

public class ArithmeticProgression {

    private static final String GAME_RULES_DESCRIPTION = "What number is missing in the progression?";

    public static void launchExpressionGame() {
        String[][] gameData = generateGameData();
        Engine.launchEngine(GAME_RULES_DESCRIPTION, gameData);
    }

    private static String[][] generateGameData() {
        String[][] gameData = new String[3][2];

        for (int i = 0; i < gameData.length; i++) {
            String[] progression = generateProgression();
            int randomIndex = Utils.generateRandomNumber(progression.length);
            String correctHiddenNumber = (String) Array.get(progression, randomIndex);
            String question = convertToString(progression).replace(correctHiddenNumber, "..");
            gameData[i][0] = question;
            gameData[i][1] = correctHiddenNumber;

        }
        return gameData;
    }

    private static String[] generateProgression() {
        int randomSequenceSize = Utils.generateRandomNumber(5, 10);
        int randomCommonDifference = Utils.generateRandomNumber(5);

        StringBuilder progression = new StringBuilder();
        int nextValue;
        int numberSequence = Utils.generateRandomNumber();
        progression.append(numberSequence);
        nextValue = numberSequence;
        while (randomSequenceSize != 0) {
            nextValue += randomCommonDifference;
            progression.append(" ").append(nextValue);
            randomSequenceSize--;
        }
        return progression.toString().split(" ");
    }

    private static String convertToString(String[] progressionArray) {
        StringBuilder builder = new StringBuilder();
        for (String value : progressionArray) {
            builder.append(" ").append(value);
        }
        return builder.toString();
    }

}

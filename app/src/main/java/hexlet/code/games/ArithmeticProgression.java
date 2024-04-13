package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class ArithmeticProgression {

    private static final String GAME_RULES_DESCRIPTION = "What number is missing in the progression?";
    private static final int QUANTITY_OF_QUESTIONS = Engine.POINTS_TO_WIN;
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
            String correctHiddenElement = progression[randomIndex];
            progression[randomIndex] = "..";
            gameData[i][0] = String.join(" ", progression);
            gameData[i][1] = correctHiddenElement;

        }
        return gameData;
    }

    public static String[] generateProgression(int initialValue, int difference, int progressionLength) {
        String[] progression = new String[progressionLength];

        for (int i = 0; i < progressionLength; i += 1) {
            progression[i] = Integer.toString(initialValue + i * difference);
        }

        return progression;
    }

}

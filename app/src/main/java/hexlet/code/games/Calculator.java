package hexlet.code.games;

import hexlet.code.interfaces.Engine;
import hexlet.code.interfaces.Utils;

public class Calculator {
    private static final String GAME_RULES_DESCRIPTION = "What is the result of the expression?";
    private static final int QUANTITY_OF_QUESTIONS = 3;
    private static final int PAIRS_QUESTION_ANSWER = 2;

    public static void launchExpressionGame() {
        String[][] gameData = generateGameData();
        Engine.launchEngine(GAME_RULES_DESCRIPTION, gameData);
    }

    private static String[][] generateGameData() {
        String[][] gameData = new String[QUANTITY_OF_QUESTIONS][PAIRS_QUESTION_ANSWER];

        for (int i = 0; i < gameData.length; i++) {
            int numberOne = Utils.generateRandomNumber();
            int numberTwo = Utils.generateRandomNumber();
            String randomAction = generateRandomAction();
            String correctAnswer = String.valueOf(providesCorrectAnswer(randomAction, numberOne, numberTwo));
            gameData[i][0] = numberOne + randomAction + numberTwo;
            gameData[i][1] = correctAnswer;

        }
        return gameData;
    }

    private static String generateRandomAction() {
        String[] setOfActions = new String[]{" + ", " - ", " * "};
        int index = Utils.generateRandomNumber(setOfActions.length);
        return setOfActions[index];
    }

    private static int providesCorrectAnswer(String action, int numberOne, int numberTwo) {
        return switch (action) {
            case " + " -> numberOne + numberTwo;
            case " - " -> numberOne - numberTwo;
            case " * " -> numberOne * numberTwo;
            default -> throw new RuntimeException("Undefined operation");
        };
    }
}

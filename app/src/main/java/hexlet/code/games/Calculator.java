package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calculator {
    private static final String GAME_RULES_DESCRIPTION = "What is the result of the expression?";
    private static final int QUANTITY_OF_QUESTIONS = Engine.POINTS_TO_WIN;
    private static final int PAIRS_QUESTION_ANSWER = 2;
    private static final String[] SET_OF_ACTIONS = {" + ", " - ", " * "};

    public static void launchExpressionGame() {
        String[][] gameData = generateGameData();
        Engine.checkResponseCorrectness(GAME_RULES_DESCRIPTION, gameData);
    }

    private static String[][] generateGameData() {
        String[][] gameData = new String[QUANTITY_OF_QUESTIONS][PAIRS_QUESTION_ANSWER];

        for (int i = 0; i < gameData.length; i++) {
            int numberOne = Utils.generateRandomNumber();
            int numberTwo = Utils.generateRandomNumber();
            String randomAction = SET_OF_ACTIONS[Utils.generateRandomNumber(SET_OF_ACTIONS.length)];
            String correctAnswer = String.valueOf(providesCorrectAnswer(randomAction, numberOne, numberTwo));
            gameData[i][0] = numberOne + randomAction + numberTwo;
            gameData[i][1] = correctAnswer;

        }
        return gameData;
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

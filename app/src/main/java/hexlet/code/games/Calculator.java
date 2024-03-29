package hexlet.code.games;

import hexlet.code.interfaces.Engine;
import hexlet.code.interfaces.Utils;

public class Calculator {
    private static final String GAME_RULES_DESCRIPTION = "What is the result of the expression?";


    public static void launchExpressionGame() {
        String[][] gameData = generateGameData();
        Engine.launchEngine(GAME_RULES_DESCRIPTION, gameData);
    }

    private static String[][] generateGameData() {
        int quantityOfQuestions = 3;
        int pairsQuestionAnswer = 2;
        String[][] gameData = new String[quantityOfQuestions][pairsQuestionAnswer];

        for (int i = 0; i < gameData.length; i++) {
            int[] randomNumbers = new int[]{Utils.generateRandomNumber(), Utils.generateRandomNumber()};
            String randomAction = generateRandomAction();
            String correctAnswer = String.valueOf(providesCorrectAnswer(randomAction, randomNumbers));
            gameData[i][0] = randomNumbers[0] + randomAction + randomNumbers[1];
            gameData[i][1] = correctAnswer;

        }
        return gameData;
    }

    private static String generateRandomAction() {
        String[] setOfActions = new String[]{" + ", " - ", " * "};
        int index = Utils.generateRandomNumber(setOfActions.length);
        return setOfActions[index];
    }

    private static int providesCorrectAnswer(String action, int[] randomNumbers) {
        int correctResult = 0;
        if (action.equals(" + ")) {
            correctResult = randomNumbers[0] + randomNumbers[1];
        } else if (action.equals(" - ")) {
            correctResult = randomNumbers[0] - randomNumbers[1];
        } else if (action.equals(" * ")) {
            correctResult = randomNumbers[0] * randomNumbers[1];
        }
        return correctResult;
    }
}

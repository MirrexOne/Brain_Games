package hexlet.code.games;

import hexlet.code.interfaces.Engine;
import hexlet.code.interfaces.Utils;

public class GreatestCommonDivider {
    private static final String GAME_RULES_DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void launchGCDGame() {
        String[][] gameData = generateGameData();
        Engine.launchEngine(GAME_RULES_DESCRIPTION, gameData);
    }

    private static String[][] generateGameData() {
        String[][] gameData = new String[3][2];

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
        int[] randomOperands = new int[]{dividend, divisor};

        if (isDividendLess(dividend, divisor)) {
            randomOperands = swapNumbers(dividend, divisor);
        }
        boolean hasRemainder = true;

        int reminder = 0;
        int greatestCommonDivisor = 0;
        while (hasRemainder) {
            reminder = randomOperands[0] % randomOperands[1];
            if (reminder == 0) {
                hasRemainder = false;
                greatestCommonDivisor = randomOperands[1];
            } else {
                randomOperands[0] = randomOperands[1];
                randomOperands[1] = reminder;
            }
        }
        return greatestCommonDivisor;
    }

    private static int[] swapNumbers(int dividend, int divisor) {
        int[] dividendAndDivisor = new int[]{dividend, divisor};

        int temporaryStorage = 0;
        if (isDividendLess(dividend, divisor)) {
            temporaryStorage = dividendAndDivisor[0];
            dividendAndDivisor[0] = divisor;
            dividendAndDivisor[1] = temporaryStorage;
        }
        return dividendAndDivisor;
    }

    private static boolean isDividendLess(int dividend, int divisor) {
        return dividend < divisor;
    }
}

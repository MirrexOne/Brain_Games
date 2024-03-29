package hexlet.code.interfaces;

import java.util.Random;

public class Utils {
    private static final Random RANDOM = new Random();
    private static final int GENERATION_CAP_BY_DEFAULT = 101;

    public static int generateRandomNumber() {
        return RANDOM.nextInt(1, GENERATION_CAP_BY_DEFAULT);
    }

    public static int generateRandomNumber(int upperBound) {
        return RANDOM.nextInt(1, upperBound);
    }

    public static int generateRandomNumber(int lowerBound, int upperBound) {
        return RANDOM.nextInt(lowerBound, upperBound);
    }
}

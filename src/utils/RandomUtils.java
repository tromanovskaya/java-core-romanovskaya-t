package utils;

import java.util.Random;

public class RandomUtils {

    public static final Random RANDOM = new Random();

    private RandomUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Random getRANDOM() {
        return RANDOM;
    }

    /**
     * Returns an array of random double fields of a given size with rounding.
     *
     * @param size       - size of array
     * @param maxValue   - maximum value of elements
     * @param scaleRound - scale of round
     * @return - array of random double fields
     */
    public static double[] createRandomArrayDouble(int size, int maxValue,
                                                   int scaleRound) {
        double[] array = new double[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = RANDOM.nextInt(maxValue * (int) Math.pow(10,
                    scaleRound)) / Math.pow(10, scaleRound);
        }
        return array;
    }

    /**
     * Returns an array of random int fields of a given size.
     *
     * @param size     - size of array
     * @param maxValue - maximum value of elements
     * @return - array of random int fields
     */
    public static int[] createRandomArrayInt(int size, int maxValue) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = RANDOM.nextInt(maxValue);
        }
        return array;
    }

}

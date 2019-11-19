package utils;

public class ArrayUtils {

    private ArrayUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void printArray(double[] array) {
        Object[] objects = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            objects[i] = array[i];
        }
        printArray(objects);
    }

    public static void printArray(String[] array) {
        Object[] objects = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            objects[i] = array[i];
        }
        printArray(objects);
    }

    public static void printArray(int[] array) {
        Object[] objects = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            objects[i] = array[i];
        }
        printArray(objects);
    }

    public static void printArray(Object[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static int[] sortBubbleArray(int[] array) {
        int[] result = array.clone();
        int temp = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = (result.length - 1); j >= (i + 1); j--) {
                if (result[j] < result[j - 1]) {
                    temp = result[j];
                    result[j] = result[j - 1];
                    result[j - 1] = temp;
                }
            }
        }
        return result;
    }

    public static String[] sortBubbleArray(String[] array) {
        String[] result = array.clone();
        String temp;
        for (int i = 0; i < result.length; i++) {
            for (int j = (result.length - 1); j >= (i + 1); j--) {
                if (result[j - 1].compareTo(result[j]) > 0) {
                    temp = result[j];
                    result[j] = result[j - 1];
                    result[j - 1] = temp;
                }
            }
        }
        return result;
    }

}

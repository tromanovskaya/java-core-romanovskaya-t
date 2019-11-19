package lesson2Array;

import utils.ArrayUtils;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.ArrayUtils.sortBubbleArray;

public class Demo {

    public static void main(String[] args) {
        System.out.println("lesson2Array\n");
        int length = 20;
        int bound = 100;
        int[] array = RandomUtils.createRandomArrayInt(length, bound);
        runTask1(array);
        runTask2(array);
        runTask3();
        runTask4(array);
        runTask5();
        runTask6();
        runTask7();
        runTask8(array);
        runTask9(array);
        runTask10(array);
        runTask11(array);
        runTask12();
        runTask13();
        runTask14();
        runTask15();
        runTask16();
        runTask17(array);
        runTask18(array);
        runTask19();
        runTask20(array);
    }

    private static void runTask1(int[] array) {
        System.out.println("Task 1. Write a Java program to sort a numeric array and a string array.");
        ArrayUtils.printArray(array);
        int[] arrayIntSort = sortBubbleArray(array);
        ArrayUtils.printArray(arrayIntSort);

        String[] arrayStr = {"Io", "Sven", "Tiny", "Void", "Naga", "Riki", "CM", "Lina"};
        ArrayUtils.printArray(arrayStr);
        String[] arrayStrSort = sortBubbleArray(arrayStr);
        ArrayUtils.printArray(arrayStrSort);
    }


    private static void runTask2(int[] array) {
        System.out.println("\nTask 2. Write a Java program to sum values of an array.");
        int sum = 0;
        ArrayUtils.printArray(array);
        for (int i : array) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }

    private static void runTask3() {
        System.out.println("\nTask 3. Write a Java program to print the following grid");
    }

    private static void runTask4(int[] array) {
        System.out.println("\nTask 4.  Write a Java program to calculate the average value of array elements.");
        double averageValue = 0;
        ArrayUtils.printArray(array);
        for (int i : array) {
            averageValue += i;
        }
        System.out.println("averageValue = " + averageValue / array.length);
    }

    private static void runTask5() {
        System.out.println("\nTask 5.  Write a Java program to test if an array contains a specific value.");
        int length = 8;
        int bound = 10;
        int[] array = RandomUtils.createRandomArrayInt(length, bound);
        int value = 5;
        boolean containsSpecificValue = false;
        ArrayUtils.printArray(array);
        for (int i : array) {
            if (i == value) {
                containsSpecificValue = true;
            }
        }
        if (containsSpecificValue) {
            System.out.println("Array contains a specific value = " + value);
        } else {
            System.out.println("Array not contains a specific value = " + value);
        }
    }

    private static void runTask6() {
        System.out.println("\nTask 6.  Write a Java program to find the index of an array element.");
        int[] array = {5, 0, 5, 5, 6, 7, 6, 4, 5};
        ArrayUtils.printArray(array);
        int value = 6;
        boolean isFindValue = false;
        System.out.println("Find value = " + value);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                if (!isFindValue) {
                    System.out.print("Index: ");
                }
                System.out.print(i + "  ");
                isFindValue = true;
            }
        }
        if (!isFindValue) {
            System.out.print("This value not found.");
        }
        System.out.println("");
    }

    private static void runTask7() {
        System.out.println("\nTask 7.  Write a Java program to remove a specific element from an array.");
        int[] array = {5, 0, 5, 5, 6, 7, 8, 4, 5};
        int value = 5;
        System.out.println("remove value = " + value);
        System.out.print("   array = ");
        ArrayUtils.printArray(array);
        int j = 0;
        int countWithoutValue = 0;
        for (int i : array) {
            if (i != value) {
                countWithoutValue++;
            }
        }
        int[] newArray = new int[countWithoutValue];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != value) {
                newArray[j] = array[i];
                j++;
            }
        }
        System.out.print("newArray = ");
        ArrayUtils.printArray(newArray);
    }

    private static void runTask8(int[] array) {
        System.out.println("\nTask 8.  Write a Java program to copy an array by iterating the array.");
        System.out.print("   array = ");
        ArrayUtils.printArray(array);
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        System.out.print("newArray = ");
        ArrayUtils.printArray(newArray);
    }

    private static void runTask9(int[] array) {
        System.out.println("\nTask 9.  Write a Java program to insert an element (specific position) into an array.");
        int index = 5;
        int value = 111;
        int j = 0;
        System.out.println("insert an element index = " + index + " value = " + value);
        System.out.print("   array = ");
        ArrayUtils.printArray(array);
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                newArray[j] = value;
                j++;
                newArray[j] = array[i];
                j++;
            } else {
                newArray[j] = array[i];
                j++;
            }
        }
        System.out.print("newArray = ");
        ArrayUtils.printArray(newArray);
    }

    private static void runTask10(int[] array) {
        System.out.println("\nTask 10. Write a Java program to find the maximum and minimum value of an array.");
        ArrayUtils.printArray(array);
        int maxValue = array[0];
        int minValue = array[0];
        for (int i : array) {
            if (maxValue < i) {
                maxValue = i;
            }
            if (minValue > i) {
                minValue = i;
            }
        }
        System.out.println("minValue = " + minValue);
        System.out.println("maxValue = " + maxValue);
    }

    private static void runTask11(int[] array) {
        System.out.println("\nTask 11. Write a Java program to reverse an array of integer values.");
        System.out.print("   array = ");
        ArrayUtils.printArray(array);
        int[] newArray = new int[array.length];
        int j = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[j] = array[i];
            j++;
        }
        System.out.print("newArray = ");
        ArrayUtils.printArray(newArray);
    }

    private static void runTask12() {
        System.out.println("\nTask 12. Write a Java program to find the duplicate values of an array of integer values.");
        int[] array = {5, 0, 5, 5, 6, 7, 8, 9, 4, 5, 5, 4, 9, 66, 66};
        ArrayUtils.printArray(array);
        array = sortBubbleArray(array);
        String result = "";
        String distinctResult = "";
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if ((array[i] == array[j]) && (i != j)) {
                    result = "Duplicate value : " + array[i];
                    if (!distinctResult.equals(result)) {
                        distinctResult = result;
                        System.out.println(distinctResult);
                    }
                }
            }
        }
    }

    private static void runTask13() {
        System.out.println("\nTask 13. Write a Java program to find the duplicate values of an array of string values.");
        String[] array = {"BYN", "USD", "EUR", "USD", "USD", "RUB", "RUB"};
        ArrayUtils.printArray(array);
        array = sortBubbleArray(array);
        String result = "";
        String distinctResult = "";
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if ((array[i].equals(array[j])) && (i != j)) {
                    result = "Duplicate value : " + array[i];
                    if (!distinctResult.equals(result)) {
                        distinctResult = result;
                        System.out.println(distinctResult);
                    }
                }
            }
        }
    }

    private static void runTask14() {
        System.out.println("\nTask 14. Write a Java program to find the common elements between two arrays (string values).");
        String[] arrayFirst = {"Io", "Sven", "Tiny", "Void", "Void", "Mirana", "Riki", "CM", "Lina"};
        String[] arraySecond = {"Enigma", "Oracle", "Sven", "Lion", "Void", "Mirana", "Rubick", "Puck", "Zeus"};
        arrayFirst = sortBubbleArray(arrayFirst);
        arraySecond = sortBubbleArray(arraySecond);
        ArrayUtils.printArray(arrayFirst);
        ArrayUtils.printArray(arraySecond);
        String result = "";
        String distinctResult = "";
        for (String elementArrayFirst : arrayFirst) {
            for (String elementArraySecond : arraySecond) {
                if (elementArrayFirst.equals(elementArraySecond)) {
                    result = "Find : " + elementArrayFirst;
                    if (!distinctResult.equals(result)) {
                        distinctResult = result;
                        System.out.println(distinctResult);
                    }
                }
            }
        }
    }

    private static void runTask15() {
        System.out.println("\nTask 15. Write a Java program to find the common elements between two arrays of integers.");
        int[] arrayFirst = {2, 4, 6, 7, 8, 3, 2, 4, 66, 8};
        int[] arraySecond = {1, 2, 67, 55, 8, 0, 5, 5, 4};
        arrayFirst = sortBubbleArray(arrayFirst);
        arraySecond = sortBubbleArray(arraySecond);
        ArrayUtils.printArray(arrayFirst);
        ArrayUtils.printArray(arraySecond);
        String result = "";
        String distinctResult = "";
        for (int elementArrayFirst : arrayFirst) {
            for (int elementArraySecond : arraySecond) {
                if (elementArrayFirst == elementArraySecond) {
                    result = "Find : " + elementArrayFirst;
                    if (!distinctResult.equals(result)) {
                        distinctResult = result;
                        System.out.println(distinctResult);
                    }
                }
            }
        }
    }

    private static void runTask16() {
        System.out.println("\nTask 16. Write a Java program to remove duplicate elements from an array.");
        int[] array = {1, 5, 0, 5, 5, 6, 7, 8, 9, 4, 5, 5, 4, 9, 9};
        ArrayUtils.printArray(array);
        int[] newArray = new int[array.length];
        int distinctIntegers = 0;
        for (int i = 0; i < array.length; i++) {
            boolean seenThisIntBefore = false;
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    seenThisIntBefore = true;
                }
            }
            if (!seenThisIntBefore) {
                newArray[distinctIntegers++] = array[i];
            }
        }
        ArrayUtils.printArray(newArray);
    }

    private static void runTask17(int[] array) {
        System.out.println("\nTask 17. Write a Java program to find the second largest element in an array.");
        int minValue = array[0];
        int maxValue = array[0];
        int secondMaxValue = 0;
        ArrayUtils.printArray(array);
        for (int anArray : array) {
            if (anArray < minValue) {
                minValue = anArray;
            }
        }
        for (int anArray : array) {
            if (anArray > maxValue) {
                maxValue = anArray;
            }
        }
        System.out.println("minValue = " + minValue);
        System.out.println("maxValue = " + maxValue);
        secondMaxValue = minValue;
        for (int anArray : array) {
            if ((anArray != maxValue) && (anArray > minValue) && (anArray > secondMaxValue)) {
                secondMaxValue = anArray;
            }
        }
        System.out.println("secondMinValue = " + secondMaxValue);
    }

    private static void runTask18(int[] array) {
        System.out.println("\nTask 18. Write a Java program to find the second smallest element in an array.");
        int minValue = array[0];
        int maxValue = array[0];
        int secondMinValue = 0;
        ArrayUtils.printArray(array);
        for (int anArray : array) {
            if (anArray < minValue) {
                minValue = anArray;
            }
        }
        for (int anArray : array) {
            if (anArray > maxValue) {
                maxValue = anArray;
            }
        }
        System.out.println("minValue = " + minValue);
        System.out.println("maxValue = " + maxValue);
        secondMinValue = maxValue;
        for (int anArray : array) {
            if ((anArray != minValue) && (anArray < maxValue) && (anArray < secondMinValue)) {
                secondMinValue = anArray;
            }
        }
        System.out.println("secondMinValue = " + secondMinValue);
    }

    private static void runTask19() {
        System.out.println("\nTask 19. Write a Java program to add two matrices of the same size.");
        int size = 4;
        int[][] matrixFirst = new int[size][size];
        int[][] matrixSecond = new int[size][size];
        int[][] matrixSum = new int[size][size];
        int value = 1120;
        System.out.println("matrixFirst");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixFirst[i][j] = value++;
                System.out.print(matrixFirst[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("matrixSecond");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixSecond[i][j] = value++;
                System.out.print(matrixSecond[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("matrixSum");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixSum[i][j] = matrixFirst[i][j] + matrixSecond[i][j];
                System.out.print(matrixSum[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static void runTask20(int[] array) {
        System.out.println("\nTask 20. Write a Java program to convert an array to ArrayList.");
        ArrayUtils.printArray(array);
        List<Integer> arrayList = new ArrayList<>();
        for (int i : array) {
            arrayList.add(i);
        }
        System.out.print(arrayList.toString());

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i : array) {
            arrayList1.add(i);
        }
        System.out.print(arrayList1.toString()); // = arrayList.toString()

    }
}

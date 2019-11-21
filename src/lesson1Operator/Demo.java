package lesson1Operator;

import org.apache.commons.math3.util.Precision;
import utils.ArrayUtils;
import utils.RandomUtils;

import static utils.ArrayUtils.findMaxElement;

public class Demo {
    private static final int DEFAULT_HOURS_VALUE = 24;
    private static final int DEFAULT_MINUTES_VALUE = 60;
    private static final int DEFAULT_SECONDS_VALUE = 60;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        stringBuilder.append("lesson1Operator\n");
        runTask1();
        runTask2();
        runTask3();
        runTask4();
        runTask5();
        runTask6();
        runTask7();
        runTask8();
        runTask9();
        runTask10();
        runTask11();
        runTask12();
        runTask13();
        runTask14();
        runTask15();
        runTask16();
        runTask17();
        runTask18();
        runTaskAdvancedLevel2();
    }

    private static void runTask1() {
        stringBuilder.append("\n1. Напишите программу, которая вычисляет ваш вес на Луне с учетом того, что сила тяжести " +
                "равна 16% от силы тяжести на Земле.");
        double weight = 42;
        double weightMoon;
        double coefficient = 1 - 0.16;
        weightMoon = weight * coefficient;
        stringBuilder.append("\nmass = ");
        stringBuilder.append(weight);
        stringBuilder.append("\nmass on the moon = ");
        stringBuilder.append(weightMoon);
        System.out.println(stringBuilder.toString());
    }

    private static void runTask2() {
        System.out.println("\n2. Напишите метод, который будет увеличивать каждый элемент массива на 10%.");
        int length = 4;
        int bound = 100;
        int scaleRound = 2;
        double[] array = RandomUtils.createRandomArrayDouble(length, bound, scaleRound);
        System.out.print("Initial array of random numbers = ");
        ArrayUtils.printArray(array);
        increaseBy10(array);
        System.out.print("Each element of the array is increased by 10% = ");
        ArrayUtils.printArray(array);
    }

    private static void increaseBy10(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Precision.round(array[i] * 1.1, 2);
        }
    }

    private static void runTask3() {
        System.out.println("\n3. Напишите метод, который будет проверять является ли число палиндромом (одинаково " +
                "читающееся в обоих направлениях).");
        int number = 12521;
        isPalindrome(number);
    }

    private static void isPalindrome(int number) {
        int namber1 = number;
        int reverse = 0;
        while (namber1 != 0) {
            reverse = reverse * 10 + namber1 % 10; // new reverse number
            namber1 = namber1 / 10;
        }
        if (reverse == number) {
            System.out.println(number + " - is a Palindrome");
        } else {
            System.out.println(number + " - is not a Palindrome");
        }
    }

    private static void runTask4() {
        System.out.println("\n4. Вывести на экран все четные цифры от 1 до 100 (используйте остаток от деления)");
        int valueStart = 1;
        int valueEnd = 100;
        for (int i = valueStart; i <= valueEnd; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }

    private static void runTask5() {
        System.out.println("\n5. Вывести на  экран все нечетные цифры от 1 до 15 (используйте остаток от деления)");
        int valueStart = 1;
        int valueEnd = 15;
        for (int i = valueStart; i <= valueEnd; i++) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }

        }
        System.out.println("");
    }

    private static void runTask6() {
        System.out.println("\n6. Вывести на  экран все четные цифры от 1 до 100 не используя остаток от деления " +
                "(используя только цикл for)");
        int valueStart = 1;
        int valueEnd = 100;
        for (int i = valueStart; i <= valueEnd; i += 2) {
            System.out.print(i + 1 + " ");
        }
        System.out.println("");
    }

    private static void runTask7() {
        System.out.println("\n7. Посчитать сумму цифр от 20 до 200 и результат вывести на экран (используя цикл for)");
        int valueStart = 20;
        int valueEnd = 200;
        int sum = 0;
        for (int i = valueStart; i <= valueEnd; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    private static void runTask8() {
        System.out.println("\n8. Пройти циклом по числам от 1 до 12 и вывести название месяца, соответствующее каждому " +
                "числу (используя цикл и оператор if else)");
        String month;
        int valueStart = 1;
        int valueEnd = 12;
        for (int i = valueStart; i <= valueEnd; i++) {
            if (i == 1) {
                month = "январь";
            } else if (i == 2) {
                month = "февраль";
            } else if (i == 3) {
                month = "март";
            } else if (i == 4) {
                month = "апрель";
            } else if (i == 5) {
                month = "май";
            } else if (i == 6) {
                month = "июнь";
            } else if (i == 7) {
                month = "июль";
            } else if (i == 8) {
                month = "август";
            } else if (i == 9) {
                month = "сентябрь";
            } else if (i == 10) {
                month = "октябрь";
            } else if (i == 11) {
                month = "ноябрь";
            } else {
                month = "декабрь";
            }
            System.out.println(i + " " + month);
        }
    }

    private static void runTask9() {
        System.out.println("\n9. Объявить 2 переменных целого типа. Необходимо поменять значения переменных так, чтобы " +
                "значение первой оказалось во второй, а второй - в первой.");
        int firstInteger = 10;
        int secondInteger = 20;
        System.out.println("firstInteger = " + firstInteger + " secondInteger = " + secondInteger);
        System.out.println("change the values of variables");
        firstInteger = firstInteger + secondInteger;
        secondInteger = firstInteger - secondInteger;
        firstInteger = firstInteger - secondInteger;
        System.out.println("firstInteger = " + firstInteger + " secondInteger = " + secondInteger);
    }

    private static void runTask10() {
        System.out.println("\n10. Напишите программу с тремя переменными целого типа, первым двум присвойте значения, " +
                "а третьей переменной присвойте их сумму. Выведете значение третей переменной на экран.");
        int bound = 100;
        int firstInteger = RandomUtils.getRANDOM().nextInt(bound);
        int secondInteger = RandomUtils.getRANDOM().nextInt(bound);
        int sum;
        sum = firstInteger + secondInteger;
        System.out.println(firstInteger + " + " + secondInteger + " = " + sum);
    }

    private static void runTask11() {
        System.out.println("\n11. Напишите программу с тремя переменными целого типа. Определить какое из них наибольшее.");
        int number1 = 50;
        int number2 = 30;
        int number3 = 50;
        System.out.println("Initial data: number1 = " + number1 + ", number2 = " + number2 + ", number3 = " + number3);
        determineGreatest(number1, number2, number3);
    }

    private static void determineGreatest(int number1, int number2, int number3) {
        int maxNamber;
        String result;
        if (number1 > number2) {
            maxNamber = number1;
            result = "number1";
        } else {
            if (number1 == number2) {
                maxNamber = number2;
                result = "number1 = number2";
            } else {
                maxNamber = number2;
                result = "number2";
            }
        }
        if (number3 > maxNamber) {
            maxNamber = number3;
            result = "number3";
        } else if (number3 == maxNamber) {
            result = result + " = number3";
        }
        System.out.println("Largest number = " + result + " = " + maxNamber);
    }

    private static void runTask12() {
        System.out.println("\n12. Напишите программу, в которой используются две переменные логического типа (boolean), " +
                "присвойте им значения и выведете для каждой переменной на экран строку \"истина\", если переменная " +
                "имеет значение true и \"ложь\", если переменная имеет значение false.");
        boolean variable1 = true;
        boolean variable2 = false;
        System.out.println("variable1 = " + variable1);
        isTrue(variable1);
        System.out.println("variable2 = " + variable2);
        isTrue(variable2);
    }

    private static void isTrue(boolean variable) {
        if (variable) {
            System.out.println("истина");
        } else {
            System.out.println("ложь");
        }
    }

    private static void runTask13() {
        System.out.println("\n13. Напишите программу, где двум строковым переменным присваиваются значения, третей же " +
                "строковой переменных присвойте объединение (конкатенацию) двух предыдущих строк. Затем напечатайте " +
                "значение третьей строковой переменной.");
        String str1 = "Storm ";
        String str2 = "Area 51!";
        String str3;
        System.out.println("Initial data: str1 = " + str1 + ", str2 = " + str2);
        str3 = str1 + str2;
        System.out.println(str3);
    }

    private static void runTask14() {
        System.out.println("\n14. Создайте программу с двумя переменными целого типа, присвойте им значения, если " +
                "первая переменная больше второй, то увеличьте её значение на 3, иначе увеличьте значение второй " +
                "переменной на 8. В конце программы выведите значения обоих чисел на экран.");
        int bound = 100;
        int value1 = RandomUtils.getRANDOM().nextInt(bound);
        int value2 = RandomUtils.getRANDOM().nextInt(bound);
        System.out.println("Initial data: value1 = " + value1 + " value2 = " + value2);
        if (value1 > value2) {
            value1 += 3;
        } else {
            value2 += 8;
        }
        System.out.println("value1 = " + value1 + " value2 = " + value2);
    }

    private static void runTask15() {
        System.out.println("\n15. Выведете на экран все числа от 1 до 100 с помощью цикла (можно все три варианта в " +
                "одной программе): for, while, do while");
        int valueStart = 1;
        int valueEnd = 100;
        System.out.println("Numbers from 1 to 100 with for:");
        for (int i = valueStart; i <= valueEnd; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");
        int i = 1;
        System.out.println("Numbers from 1 to 100 with while:");
        while (i <= valueEnd) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println("");
        System.out.println("Numbers from 1 to 100 with do while:");
        i = 1;
        do {
            System.out.print(i + " ");
            i++;
        } while (i <= valueEnd);
        System.out.println("");
    }

    private static void runTask16() {
        System.out.println("\n16. Вывести на экран ряд натуральных чисел от минимума до максимума с шагом. Например," +
                " если минимум 10, максимум 35, шаг 5, то вывод должен быть таким: 10 15 20 25 30 35. Минимум, " +
                "максимум и шаг указываются пользователем (можно захардкодить).");
        int minNamber = 10;
        int maxNamber = 100;
        int step = 25;
        for (int i = minNamber; i <= maxNamber; i += step) {
            if (i > 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }

    private static void runTask17() {
        System.out.println("\n17. Все элементы массива поделить на значение наибольшего элемента этого массива.");
        int length = 6;
        int bound = 100;
        int scaleRound = 2;
        double[] array = RandomUtils.createRandomArrayDouble(length, bound, scaleRound);
        System.out.print("Initial array of random numbers = ");
        ArrayUtils.printArray(array);
        double maxElement = findMaxElement(array);
        System.out.println("Maximum element value array = " + maxElement);
        System.out.print("Array elements are divided by the maximum value = ");
        divisionByMaxElement(array, maxElement);
        ArrayUtils.printArray(array);
    }

    private static void divisionByMaxElement(double[] array, double maxElement) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Precision.round(array[i] / maxElement, 5);
        }
    }

    private static void runTask18() {
        System.out.println("\n18. Напишите метод переводящий рубли в доллары по заданному курсу. В качестве аргументов " +
                "укажите кол-во рублей и курс.");
        double usdRate = 2.034;
        double byn = 1000d;
        double usd;
        System.out.println("usdRate = " + usdRate + " byn = " + byn);
        usd = Precision.round(byn / usdRate, 2);
        System.out.println("usd = " + usd);
    }

    private static void runTaskAdvancedLevel2() {
        System.out.println("\nAdvancedLevel 2. Напишите программу, которая будет считать количество часов, минут и " +
                "секунд в n-ном количестве суток.");
        int days = 10;
        int hours = days * DEFAULT_HOURS_VALUE;
        int minutes = hours * DEFAULT_MINUTES_VALUE;
        int seconds = minutes * DEFAULT_SECONDS_VALUE;
        System.out.println(days + " days include: hours - " + hours + ", minutes - " + minutes + ", seconds - " + seconds);
    }

}

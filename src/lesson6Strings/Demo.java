package lesson6Strings;

import utils.StringUtils;

import static utils.ArrayUtils.printArray;
import static utils.ArrayUtils.sortBubbleArray;
import static utils.StringUtils.getWordsUniqueByLenght;

public class Demo {
    public static void main(String[] args) {
        String s = "Более 30 тысяч пользователей «Авто барахолки» ждали 11 октября. " +
                "Ведь именно сегодня состоится розыгрыш автомобиля *Hyundai Accent*? " +
                "В конкурсе приняли участие 32096 объявлений, которые соответствовали правилам. " +
                "Сегодня, примерно в 12:30, мы узнаем победителя? " +
                "«трансляция» розыгрыша будет вестись прямо в данной заметке, поэтому не *спешите* ее закрывать узнаем ее.";
        System.out.println(s + "\n");
        runTask1(s);
        runTask2(s);
        runTask3(s);
        runTask4(s);
        runTask5(s);
        runTask6(s);
        runTask7(s);
        runTask8(s);
    }

    private static void runTask1(String s) {
        System.out.println("1. Преобразовать текст так, чтобы каждое слово начиналось с заглавной буквы.");
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(StringUtils.toStartUpperCase(word));
            result.append(" ");
        }
        System.out.println("result = " + result.toString().trim());
    }

    private static void runTask2(String s) {
        System.out.println("\n2. Подсчитать количество содержащихся в данном тексте знаков препинания");
        String stringWithoutPunct;
        stringWithoutPunct = s.replaceAll("\\p{Punct}", "");
        System.out.println("Namber of punctuation marks = " + (s.length() - stringWithoutPunct.length()));
    }

    private static void runTask3(String s) {
        System.out.println("\n3.  Определить сумму всех целых чисел, встречающихся в заданном тексте");
        String[] words = s.split(" ");
        int sumValues = 0;
        StringBuilder valuesInt = new StringBuilder();
        //printArray(words);
        for (String word : words) {
            if (word.equals(word.replaceAll("[^0-9]", ""))) {
                sumValues += Integer.parseInt(word);
                valuesInt.append(Integer.parseInt(word));
                valuesInt.append(" ");
            }
        }
        System.out.println("valuesInt = " + valuesInt.toString());
        System.out.println("sumValues = " + sumValues);
    }

    private static void runTask4(String s) {
        System.out.println("\n4. В каждом слове текста k-ю букву заменить заданным символом. Если  k больше длины слова, корректировку не выполнять.");
        char symbol = '#';
        int k = 5;
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(StringUtils.replaceStringBySymbolPosition(word, k, symbol));
            result.append(" ");
        }
        System.out.println(result.toString().trim());
    }

    private static void runTask5(String s) {
        System.out.println("\n5. Удалить из текста его часть, заключенную между двумя символами, которые вводятся (например, между скобками ‘(’ и ‘)’ или между звездочками ‘*’ и т.п.).");

        String symbolStart = "«";
        String symbolEnd = "»";
        System.out.println("deleteIncludeSymbols '" + symbolStart + "' and '" + symbolEnd + "'");
        System.out.println(StringUtils.deleteIncludeSymbols(s, symbolStart, symbolEnd));

        String symbol = "*";
        System.out.println("deleteIncludeSymbols '" + symbol + "'");
        System.out.println(StringUtils.deleteIncludeSymbols(s, symbol));
        System.out.println(StringUtils.deleteIncludeSymbols(s, symbol, symbol));
    }

    private static void runTask6(String s) {
        System.out.println("\n6. Найти и напечатать, сколько раз повторяется в тексте каждое слово, которое встречается в нем.");
        String[] wordsSorted = sortBubbleArray(s.toLowerCase().replaceAll("[^а-яa-z ]", "").split(" "));
        printArray(wordsSorted);
        int count = 0;
        for (int i = 0; i < wordsSorted.length; i++) {
            if (i < wordsSorted.length - 1) {
                if (wordsSorted[i].equals(wordsSorted[i + 1])) {
                    count++;
                } else {
                    count++;
                    if (!wordsSorted[i].equals("")) {
                        System.out.println(count + " : " + wordsSorted[i]);
                    }
                    count = 0;
                }
            }
        }
    }

    private static void runTask7(String s) {
        System.out.println("\n7. Найти, каких букв, гласных или согласных, больше в каждом предложении текста");
        String[] sentences = s.split("[.!?]");
        for (int i = 0; i < sentences.length; i++) {
            int volwelsRU = StringUtils.countVolwelsRU(sentences[i]);
            int consonantsRU = StringUtils.countConsonantRU(sentences[i]);
            String moreLetters;
            if (volwelsRU > consonantsRU) {
                moreLetters = "more vowels in the sentence";
            } else if (volwelsRU < consonantsRU) {
                moreLetters = "more consonants in the sentence";
            } else {
                moreLetters = "in the sentence of equally vowels and consonants";
            }
            System.out.println("sentence " + (i + 1) + ": " + moreLetters + " (volwelsRU = " + volwelsRU + " consonantsRU = " + consonantsRU + ")");
        }
    }

    private static void runTask8(String s) {
        System.out.println("\n8. Во всех вопросительных предложениях текста найти и напечатать без повторений слова заданной длины");
        int lenght = 2;
        System.out.println("word lenght = " + lenght);
        String[] interrogativeSentences = StringUtils.getInterrogativeSentences(s);
        for (String interrogativeSentence : interrogativeSentences) {
            System.out.println(interrogativeSentence);
            String[] words = getWordsUniqueByLenght(interrogativeSentence, lenght);
            printArray(words);
        }
    }


}

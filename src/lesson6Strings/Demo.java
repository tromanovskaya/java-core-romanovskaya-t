package lesson6Strings;

import utils.StringUtils;

import java.util.*;

import static utils.ArrayUtils.printArray;
import static utils.ArrayUtils.sortBubbleArray;
import static utils.MapUtils.print;
import static utils.StringUtils.getWordsUniqueByLength;

public class Demo {
    public static void main(String[] args) {
        String s = "Более 30 тысяч пользователей «Авто барахолки» ждали 11 октября. " +
                "Ведь именно сегодня состоится розыгрыш автомобиля *Hyundai Accent*? " +
                "В конкурсе приняли участие 32096 объявлений, которые соответствовали правилам. " +
                "Сегодня, примерно в 12:30, мы узнаем победителя? " +
                "«Трансляция» розыгрыша будет вестись прямо в данной заметке, поэтому не *спешите* ее закрывать узнаем ее.";
        System.out.println(s + "\n");
        // Task1
        System.out.println("1. Преобразовать текст так, чтобы каждое слово начиналось с заглавной буквы.");
        System.out.println(toStartUpperCaseEveryWords(s));
        //Task2
        System.out.println("\n2. Подсчитать количество содержащихся в данном тексте знаков препинания");
        System.out.println("Number of punctuation marks = " + countPunctuationMarks(s));
        //Task3
        System.out.println("\n3.  Определить сумму всех целых чисел, встречающихся в заданном тексте");
        System.out.println("The sum of all integers in a string = " + sumIntegers(s));
        //Task4
        System.out.println("\n4. В каждом слове текста k-ю букву заменить заданным символом. Если k больше длины слова, корректировку не выполнять.");
        char symbol = '#';
        int k = 5;
        System.out.println(replaceCharWithPositionToSymbolEveryWords(s, k, symbol));
        //Task5
        System.out.println("\n5. Удалить из текста его часть, заключенную между двумя символами, которые вводятся (например, между скобками ‘(’ и ‘)’ или между звездочками ‘*’ и т.п.).");
        String symbolStart = "«";
        String symbolEnd = "»";
        System.out.println("Delete include symbols '" + symbolStart + "' and '" + symbolEnd + "'");
        System.out.println(StringUtils.deleteIncludeSymbols(s, symbolStart, symbolEnd));
        String symbolAlone = "*";
        System.out.println("Delete include symbols '" + symbol + "'");
        System.out.println(StringUtils.deleteIncludeSymbols(s, symbolAlone));
        System.out.println(StringUtils.deleteIncludeSymbols(s, symbolAlone, symbolAlone));
        //Task6
        System.out.println("\n6. Найти и напечатать, сколько раз повторяется в тексте каждое слово, которое встречается в нем.");
        Map<String, Integer> treeMap = countEveryWords(s);
        print(treeMap);
        //Task7
        System.out.println("\n7. Найти, каких букв, гласных или согласных, больше в каждом предложении текста");
        List<String> list = findVowelsConsonantsInSentence(s);
        for (String element : list) {
            System.out.println(element);
        }
        //Task8
        System.out.println("\n8. Во всех вопросительных предложениях текста найти и напечатать без повторений слова заданной длины");
        int wordLength = 8;
        list = runTask8(s, wordLength);
        for (String element : list) {
            System.out.println(element);
        }
    }

    private static String toStartUpperCaseEveryWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(StringUtils.toStartUpperCase(word));
            result.append(" ");
        }
        return result.toString().trim();
    }

    private static int countPunctuationMarks(String s) {
        String stringWithoutPunctuation;
        stringWithoutPunctuation = s.replaceAll("\\p{Punct}", "");
        return s.length() - stringWithoutPunctuation.length();
    }

    private static int sumIntegers(String s) {
        String[] words = s.split(" ");
        int sumValues = 0;
        StringBuilder valuesInt = new StringBuilder();
        for (String word : words) {
            if (word.equals(word.replaceAll("[^0-9]", ""))) {
                sumValues += Integer.parseInt(word);
                valuesInt.append(Integer.parseInt(word));
                valuesInt.append(" ");
            }
        }
        System.out.println("valuesInt = " + valuesInt.toString());
        return sumValues;
    }

    private static String replaceCharWithPositionToSymbolEveryWords(String s, int k, char symbol) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(StringUtils.replaceStringBySymbolPosition(word, k, symbol));
            result.append(" ");
        }
        return result.toString().trim();
    }

    private static Map<String, Integer> countEveryWords(String s) {
        String[] wordsSorted = sortBubbleArray(s.toLowerCase().replaceAll("[^а-яa-z ]", "").split(" "));
        printArray(wordsSorted);
        Map<String, Integer> treeMap = new TreeMap<>();
        for (String word : wordsSorted) {
            if (!word.equals("")) {
                if (treeMap.containsKey(word)) {
                    treeMap.replace(word, treeMap.get(word) + 1);
                } else {
                    treeMap.put(word, 1);
                }
            }
        }
        return treeMap;
    }

    private static List<String> findVowelsConsonantsInSentence(String s) {
        List<String> list = new ArrayList<>();
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

            list.add("sentence " + (i + 1) + ": " + moreLetters + " (volwelsRU = " + volwelsRU + " consonantsRU = " + consonantsRU + ")");
        }
        return list;
    }

    private static List<String> runTask8(String s, int wordLength) {
        List<String> list = new ArrayList<>();
        System.out.println("word length = " + wordLength);
        List<String> interrogativeSentences = StringUtils.getInterrogativeSentences(s);
        int i = 1;
        for (String interrogativeSentence : interrogativeSentences) {
            System.out.print("interrogative sentence " + i++ + ": ");
            System.out.println(interrogativeSentence);
            Set<String> words = getWordsUniqueByLength(interrogativeSentence, wordLength);
            System.out.println("result list : " + words);
        }
        return list;
    }


}

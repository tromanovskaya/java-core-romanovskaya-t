package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static utils.ArrayUtils.printArray;
import static utils.ArrayUtils.sortBubbleArray;

public class StringUtils {

    private StringUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Returns replaced string from the text of which the parts enclosed
     * between two characters are removed.
     *
     * @param stringIn    - input string
     * @param symbolStart - first character
     * @param symbolEnd   - second character
     * @return - replaced string
     */
    public static String deleteIncludeSymbols(String stringIn, String symbolStart, String symbolEnd) {
        if (symbolStart.equals(symbolEnd)) {
            return deleteIncludeSymbols(stringIn, symbolStart);
        }
        String stringOut = stringIn;
        String[] sArray = stringIn.split("");
        String stringDel;
        int start = 0; // symbol position in string
        int end = 0; // symbol position in ending
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i].equals(symbolStart)) {
                start = i;
            } else if (sArray[i].equals(symbolEnd)) {
                end = i;
            }
            if (end > start) {
                stringDel = symbolStart + stringIn.substring(start + 1, end) + symbolEnd;
                stringOut = stringOut.replace(stringDel, (symbolStart + symbolEnd));
                start = 0;
                end = 0;
            }
        }
        return stringOut;
    }

    /**
     * Returns replaced string from the text of which the parts enclosed
     * between two identical characters are removed.
     *
     * @param stringIn - input string
     * @param symbol   - character
     * @return - replaced string
     */
    public static String deleteIncludeSymbols(String stringIn, String symbol) {
        String[] sArray = stringIn.split("");
        String stringDel;
        String stringOut = stringIn;
        int start = 0; // symbol position in string
        int end = 0; // symbol position in ending
        int position = 0; // symbol position
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i].equals(symbol)) {
                position++;
                if (position % 2 == 1) {
                    start = i;
                } else {
                    end = i;
                    stringDel = symbol + stringIn.substring(start + 1, end) + symbol;
                    stringOut = stringOut.replace(stringDel, (symbol + symbol));
                    start = 0;
                    end = 0;
                }
            }
        }
        return stringOut;
    }

    public static int countVolwelsRU(String s) {
        if (s == null) {
            return 0;
        }
        return s.toLowerCase().replaceAll("[^аяуюиыэеоё]", "").length();
    }

    public static int countConsonantRU(String s) {
        if (s == null) {
            return 0;
        }
        return s.toLowerCase().replaceAll("[^а-я]", "").replaceAll("[аяуюиыэеоё]", "").length();
    }

    public static boolean isVowelRU(char symbol) {
        char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};
        symbol = Character.toLowerCase(symbol);
        for (char vowel : vowels) {
            if (symbol == vowel)
                return true;
        }
        return false;
    }

    /**
     * Returns an list of interrogative sentences from the input string.
     *
     * @param text - input string
     * @return - list of interrogative sentences
     */
    public static List<String> getInterrogativeSentences(String text) {
        List<String> list  = new ArrayList<>();
        String tempString =  text.replaceAll("[?]", "<question>?");
        String[] stringEndsQuestion = tempString.split("[?.!]");
        for (String s : stringEndsQuestion) {
            if (s.endsWith("<question>")){
                list.add(s.replace("<question>","")+"?");
            }
        }
        return list;
    }

    /**
     * Returns list of unique values of the original string with length.
     *
     * @param s      - input string
     * @param length - length of words
     * @return - list of unique values
     */
    public static Set<String> getWordsUniqueByLength(String s, int length) {
        String tempString = s.toLowerCase().replaceAll("[^а-я ]", "").trim();
        String[] words = sortBubbleArray(tempString.split(" "));
        System.out.print("array words = ");
        printArray(words);
        Set<String> setWordsWithInitSize = new TreeSet<>();
        for (String word : words) {
            if (word.length() == length) {
                setWordsWithInitSize.add(word);
            }
        }
        return setWordsWithInitSize;
    }

    /**
     * Return replaced string where symbol with position replaced.
     *
     * @param s        - input string
     * @param position - position for replaced
     * @param symbol   - new symbol for position
     * @return - replaced string
     */
    public static String replaceStringBySymbolPosition(String s, int position, char symbol) {
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        int countLetter = 0;
        for (char c : chars) {
            if (Character.isLetter(c)) {
                countLetter++;
                if (countLetter == position) {
                    result.append(symbol);
                } else {
                    result.append(c);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String toStartUpperCase(String s) {
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        int countLetter = 0;
        for (char c : chars) {
            if (Character.isLetter(c)) {
                countLetter++;
                if (countLetter == 1) {
                    result.append(Character.toString(c).toUpperCase());
                } else {
                    result.append(c);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String swapFirstLastWord(String s) {
        String[] sArray = s.split(" ");
        String result = "";
        String first = ""; // symbol position in string
        String last = ""; // symbol position in ending

        for (int i = 0; i < sArray.length; i++) {
            if (sArray.length == 1) {
                result += sArray[i] + " ";
            } else if (i == 0) {
                first = sArray[i] + " ";
            } else if (i == sArray.length - 1) {
                last = sArray[sArray.length - 1] + " ";
            } else {
                result += sArray[i] + " ";
            }
        }

        result = last + result + first;

        return result.trim();
    }

    public static int countParagraphs(String s) {
        String[] sArray = s.split("\n");
        return sArray.length;
    }

    public static int countSentences(String s) {
        String[] sArray = s.split("[.!?]");
        return sArray.length;
    }

    public static int countWords(String s) {
        String[] sArray = s.split(" ");
        return sArray.length;
    }
}

package utils;

import org.apache.commons.io.IOUtils;

import static utils.RandomUtils.RANDOM;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    private FileUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void writeFileIntFromList(List<Integer> list, String fileName) {
        try (FileWriter fw = new FileWriter(fileName);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            for (Integer integer : list) {
                pw.println(integer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileWithRandomInt(String fileName, int countElement, int boundRandomInt) {
        try (FileWriter fw = new FileWriter(fileName);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            for (int i = 0; i < countElement; i++) {
                pw.println(RANDOM.nextInt(boundRandomInt));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> getSortListIntFromFile(String fileName) {
        List<Integer> list = new ArrayList<>();
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr);) {

            int ch;
            String str;
            while ((str = br.readLine()) != null) {
                ch = Integer.parseInt(str);
                list.add(ch);
            }

            list.sort(Integer::compareTo);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void writeFile(String fileName, String text, String encoding) {
        try (OutputStream os = new FileOutputStream(fileName)) {
            IOUtils.write(text, os, encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileSwapFirstLastWordAtLine(String fileInName, String fileOutName) {
        try (FileReader fr = new FileReader(fileInName);
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(fileOutName);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            String str;
            while ((str = br.readLine()) != null) {
                pw.println(utils.StringUtils.swapFirstLastWord(str));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String file2String(String fileInName) {
        StringBuilder sb = new StringBuilder();

        try (FileReader fr = new FileReader(fileInName);
             BufferedReader br = new BufferedReader(fr);) {

            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
                sb.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sb.toString().trim());

        return sb.toString().trim();
    }
}

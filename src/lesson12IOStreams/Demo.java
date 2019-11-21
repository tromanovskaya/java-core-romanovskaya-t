package lesson12IOStreams;

import java.io.IOException;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws IOException {
        System.out.println("1. Создать и заполнить файл случайными целыми числами.\n" +
                "Отсортировать содержимое файла по возрастанию.\n" +
                "По итогу получить файл с отсортированным массивом чисел");
        runTask1();
        System.out.println("2. Прочитать строки из файла и поменять местами " +
                "первое и последнее слова в каждой строк.");
        runTask2();
        System.out.println("2. Прочитать строки из файла и поменять местами " +
                "первое и последнее слова в каждой строк.");
        runTask3();
    }

    private static void runTask1() {
        String fileName = "textWriterTask1.txt";
        int countElement = 30;
        int boundRandomInt = 1000;

        utils.FileUtils.writeFileWithRandomInt(fileName, countElement, boundRandomInt);
        System.out.println("created file: textWriterTask1.txt");

        List<Integer> list = utils.FileUtils.getSortListIntFromFile(fileName);

        fileName = "textWriterTask1SortInt.txt";
        utils.FileUtils.writeFileIntFromList(list, fileName);

        System.out.println("created file: textWriterTask1SortInt.txt\n");
    }

    private static void runTask2() {
        String fileInName = "fileForTask2.txt";
        String text = "один два три\n" +
                "один два три\n" +
                "один два три\n" +
                "один два три\n" +
                "один два три";
        String encoding = "UTF-8";

        utils.FileUtils.writeFile(fileInName, text, encoding);
        System.out.println("created file: fileForTask2.txt");

        String fileOutName = "textWriterTask2Swap.txt";

        utils.FileUtils.copyFileSwapFirstLastWordAtLine(fileInName, fileOutName);
        System.out.println("created file: textWriterTask2Swap.txt\n");

    }

    private static void runTask3() {
        String fileInName = "fileForTask3.txt";
        String text = "Таиландское издание The Phuket News сообщило, что белорус Максим Щарцов приехал со своей женой в отпуск на Пхукет. 30 октября он купался в море и пропал без вести — девушка забила тревогу. Утром 2 ноября тело белоруса нашли у скалы. Супруга погибшего Ирина Рослик рассказала Onliner, как все случилось.\n" +
                "«Той же ночью был начат поиск, но спасатели не смогли найти туриста в темноте. Поисковые работы продолжались каждый день с участием множества местных спасательных агентств, добровольцев и офицеров. Королевский флот Таиланда выделил вертолет, чтобы прочесывать море с воздуха», — написали в The Phuket News. Около 7:45 утра 2 ноября поисковая группа обнаружила тело туриста, которое отвезли в больницу.\n" +
                "«Хотя официального подтверждения еще нет, это тело мужчины примерно того же возраста, что и Максим Щарцов. На нем такие же плавки, в каких в последний раз видели господина Щарцова, когда он плавал», — говорится в сообщении.\n" +
                "По словам местной полиции, 29-летняя Ирина оставалась на острове, пока шли поиски.\n" +
                "«Офицеры из Центра помощи туристам и Туристической полиции Пхукета поддерживают ее, помогая поддерживать связь с ее семьей и консульскими должностными лицами», — говорил ранее майор из Пхукетской туристической полиции.";
        String encoding = "UTF-8";

        utils.FileUtils.writeFile(fileInName, text, encoding);
        System.out.println("created file: fileForTask3.txt");

        String str = utils.FileUtils.file2String(fileInName);

        Middleware middleware = new ParagraphMiddleware();
        middleware.linkWith(new SentenceMiddleware()).linkWith(new WordMiddleware());

        middleware.countChain(str);

    }


}
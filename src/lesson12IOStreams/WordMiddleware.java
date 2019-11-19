package lesson12IOStreams;

public class WordMiddleware extends Middleware {

    @Override
    public void count(String s) {
        int result = utils.StringUtils.countWords(s);
        System.out.println("Word = " + result);
    }
}

package lesson12IOStreams;

public class SentenceMiddleware extends Middleware {

    @Override
    public void count(String s) {
        int result = utils.StringUtils.countSentences(s);
        System.out.println("Sentence = " + result);
    }

}

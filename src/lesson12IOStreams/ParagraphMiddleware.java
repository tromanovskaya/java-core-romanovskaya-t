package lesson12IOStreams;

public class ParagraphMiddleware extends Middleware {

    @Override
    public void count(String s) {
        int result = utils.StringUtils.countParagraphs(s);
        System.out.println("Paragraph = " + result);
    }
}

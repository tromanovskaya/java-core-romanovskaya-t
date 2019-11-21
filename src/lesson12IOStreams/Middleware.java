package lesson12IOStreams;

public abstract class Middleware {
    private Middleware next;

    /**
     * Helps build a chain of test objects.
     */
    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    /**
     * Subclasses implement specific checks in this method.
     */
    public abstract void count(String s);

    /**
     * Starts a check in the next object
     * or ends a check
     * if we're in the last element of the chain.
     */
    protected void countChain(String s) {
        count(s);
        if (next != null) {
            next.countChain(s);
        }
    }

}

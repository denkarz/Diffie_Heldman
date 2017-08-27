import java.util.concurrent.Exchanger;

/**
 * Start utility class with initialization all threads such as Alice, Bob and Eva.
 *
 * @author Karzykin Denis
 */
public final class Eva {
    /**
     * Public (prime) base, known to Alice, Bob, and Eve.
     */
    private static final int GENERATOR = 17;
    /**
     * Public (prime) modulus, known to Alice, Bob, and Eve.
     */
    private static final int P_NUM = 3;

    /**
     * @param args program arguments.
     */
    public static void main(final String[] args) {
        Exchanger ex;
        ex = new Exchanger();
        new Thread(new Bob(ex, P_NUM, GENERATOR)).start();
        new Thread(new Alice(ex, P_NUM, GENERATOR)).start();
    }
}

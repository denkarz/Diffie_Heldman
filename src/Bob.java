import java.util.concurrent.Exchanger;

import static java.lang.Math.pow;

/**
 * Class that implements one of threads which want to exchange data.
 *
 * @author Karzykin Denis
 */
public final class Bob implements Runnable {
    /**
     * Random number.
     */
    private static final int RANDOM = 42;
    /**
     * Time delay in milliseconds.
     */
    private static final int TIMEOUT = 5;
    /**
     * Synchronize lock object.
     */
    private static final Object LOCK = new Object();
    /**
     * Exchanger object.
     */
    private Exchanger<Double> exchanger;
    /**
     * Shared key.
     */
    private double message;
    /**
     * Public (prime) base.
     */
    private double generator;

    /**
     * @param ex        exchanger
     * @param p         public (prime) modulus
     * @param generator public (prime) base
     */
    Bob(final Exchanger ex, final long p, final long generator) {
        this.generator = generator;
        this.exchanger = ex;
        message = pow(p, RANDOM) % generator;
    }

    /**
     * Run thread.
     */
    public void run() {
        double privateKey;
        try {
            synchronized (LOCK) {
                System.out.println("Bob send " + message);
                message = exchanger.exchange(message);
                System.out.println("Bob receive " + message);
                LOCK.wait(TIMEOUT);
            }
            privateKey = check(RANDOM, message);
            System.out.println("Bob private key is " + privateKey);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param privateKey secret number.
     * @param message    received public number
     * @return password
     */
    private double check(final double privateKey, final double message) {
        return pow(message, privateKey) % generator;
    }
}

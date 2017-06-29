import java.util.concurrent.Exchanger;

/**
 * Created by User on 029 29.06.17.
 */
public class Heldman {
    static Exchanger<Double> ex;
    static long p = 3;
    static long generator =17;
    public static void main(String[] args) {
        ex = new Exchanger();
        new Thread(new Bob(ex,p,generator)).start();
        new Thread(new Alice(ex,p,generator)).start();
    }
}

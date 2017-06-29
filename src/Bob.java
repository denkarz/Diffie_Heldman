import java.util.concurrent.Exchanger;

import static java.lang.Math.pow;

/**
 * Created by User on 029 29.06.17.
 */
public class Bob implements Runnable {
    private final static Object lock = new Object();
    Exchanger<Double> exchanger;
    double message;
    double p;
    double generator;
    double random = 42;
    double privateKey;
    Bob(Exchanger ex, long p, long generator){
        this.generator = generator;
        this.p = p;
        this.exchanger=ex;
        message = pow(p, random)%generator;
    }
    public void run(){
        try{
            synchronized (lock){
                System.out.println("Bob send "+ message);
                message=exchanger.exchange(message);
                System.out.println("Bob receive "+ message);
                lock.wait(5);
            }
            privateKey = check(random,message);
            System.out.println("Bob private key is " + privateKey);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
    double check (double password, double message) {
        return pow(message,password)%generator;
    }
}

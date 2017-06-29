import java.util.concurrent.Exchanger;

import static java.lang.Math.pow;

/**
 * Created by User on 029 29.06.17.
 */
public class Alice implements Runnable {
    private final static Object lock = new Object();
    Exchanger<Double> exchanger;
    double message;
    double p;
    double generator;
    double random = 54;
    double privateKey;
    int answer;
    Alice(Exchanger ex, long p, long generator){
        this.p = p;
        this.generator = generator;
        this.exchanger=ex;
        message = pow(p, random)%generator;
    }
    public void run(){
        try{
            synchronized (lock){
                System.out.println("Alice send "+ message);
                message=exchanger.exchange(message);
                System.out.println("Alice receive "+ message);
                lock.wait(6);
            }
            privateKey = check(random,message);
            System.out.println("Alice private key is " + privateKey);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
    double check (double password, double message){
        return pow(message,password)%generator;
    }
}

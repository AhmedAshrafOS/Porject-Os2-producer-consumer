
import java.util.LinkedList;

public class main {

    public static void main(String[] args)
            throws InterruptedException {
        // Object of a class that has both produce()
        // and consume() methods
        Buffer buffer = new Buffer();
        
        Thread t1 = new Thread(new Producer(buffer), "producer 1");
        Thread t2 = new Thread(new Producer(buffer), "producer 2");
        Thread t3 = new Thread(new Consumer(buffer), "consumer 1");
        Thread t4 = new Thread(new Consumer(buffer), "consumer 2");
        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        // joining threads
        /*t1.join();
        t2.join();
        t3.join();
        t4.join();*/
    }

}

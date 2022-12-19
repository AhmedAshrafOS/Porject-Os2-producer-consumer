import java.util.LinkedList;

public class Store {

    public static void main(String[] args)
            throws InterruptedException {
        // Object of a class that has both produce()
        // and consume() methods
        Stock stock = new Stock();
        
        Thread t1 = new Thread(new Factory(stock), "factory 1");
        Thread t2 = new Thread(new Factory(stock), "factory 2");
        Thread t3 = new Thread(new Customer(stock), "Customer 1");
        Thread t4 = new Thread(new Customer(stock), "Customer 2");
        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        // joining threads
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }

}


import java.util.LinkedList;

public class Stock {

        // Create a list shared by producer and consumer
        // assume Size of buffer is 5.
        LinkedList<Integer> buffer = new LinkedList<>();
        int capacity = 5;
        int value = 0;
        // Function called by Producer thread
        public void deliverProducts() throws InterruptedException {
            
            while (true) {
                synchronized (this) {
                    // Factory thread waits while buffer
                    // is full
                    while (buffer.size() == capacity) {
                        wait();
                    }
                    System.out.println(Thread.currentThread().getName()+" delivered product: "+ value);
                     // to insert the data unit in the stock
                    buffer.add(value++);
                    // notifies the consumer thread that
                    // now it can start producing data units
                    notify();
                    // makes the working of program easier
                    // to understand
                    Thread.sleep(1000);
                }
            }
        }

        // Function called by Consumer thread
        public void buyProduct() throws InterruptedException {
            //assuming cosnumer will consume 10 data units only.
            for(int i=0;i<10;i++) { //or while(true)
                synchronized (this) {
                    // Producer thread waits while buffer
                    // is empty
                    while (buffer.size() == 0) {
                        wait();
                    }
                    // Consumer retrieve the first delivered existed data unit in the buffer
                    int val = buffer.removeFirst();
                    System.out.println(Thread.currentThread().getName()+" buy product: "+ val);
                    // Wake up Producer thread
                    notify();
                    // and sleep
                    Thread.sleep(1000);
                }
            }
        }
    }
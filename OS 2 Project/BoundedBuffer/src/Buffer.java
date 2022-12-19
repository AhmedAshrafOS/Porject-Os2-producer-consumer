

import java.util.LinkedList;

public class Buffer {

        // Create a list shared by prducer and consumer
        // assume Size of buffer is 5.
        LinkedList<Integer> buffer = new LinkedList<>();
        int capacity = 5;
        int value = 0;
        // Function called by Factory thread
        public void produceData() throws InterruptedException {
            
            while (true) {
                synchronized (this) {
                    // prducer thread waits while buffer
                    // is full
                    while (buffer.size() == capacity) {
                        wait();
                    }
                    System.out.println(Thread.currentThread().getName()+" produce data unit:"+ value);
                     // to insert the data unit in the buffer
                    buffer.add(value++);
                    // notifies the consumer thread that
                    // now it can start consume data unit
                    notify();
                    // makes the working of program easier
                    // to understand
                    Thread.sleep(1000);
                }
            }
        }

        // Function called by Customer thread
        public void consumeData() throws InterruptedException {
            //assuming consumer will consume 10 data units only.
            for(int i=0;i<10;i++) { //or while(true)
                synchronized (this) {
                    // producer thread waits while buffer
                    // is empty
                    while (buffer.size() == 0) {
                        wait();
                    }
                    // consumer retrieve the first delivered existed data unit in the buffer
                    int val = buffer.removeFirst();
                    System.out.println(Thread.currentThread().getName()+" consume data unit:"+ val);
                    // Wake up producer thread
                    notify();
                    // and sleep
                    Thread.sleep(1000);
                }
            }
        }
    }
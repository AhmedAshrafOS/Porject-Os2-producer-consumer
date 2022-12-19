
public class Producer implements Runnable {

    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    // Create producer thread
    @Override
    public void run() {
        try {
            buffer.produceData();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

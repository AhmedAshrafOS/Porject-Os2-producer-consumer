
public class Factory implements Runnable {

    private Stock stock;

    public Factory(Stock stock) {
        this.stock = stock;
    }

    // Create producer thread
    @Override
    public void run() {
        try {
            stock.deliverProducts();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

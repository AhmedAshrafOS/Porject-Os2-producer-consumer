
public class Customer implements Runnable {

    private Stock stock;

    public Customer(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        try {
            stock.buyProduct();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

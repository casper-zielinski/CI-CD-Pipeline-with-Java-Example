package at.fhj.msd;

public class OrderService {

    private Calculator calc;

    public OrderService(Calculator calc) {
        this.calc = calc;
    }

    public int calculateTotalOrder(int price, int quantity) {
        return calc.multiply(price, quantity);
    }
}
package at.fhj.msd;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceIT {

    private Calculator calc;
    private OrderService orderService;

    @BeforeEach
    public void setup() {
        calc = new CalculatorImpl();
        orderService = new OrderService(calc);
    }

    @Test
    public void testCalculateTotalOrder() {
        int price = 20;
        int quantity = 3;
        int expectedTotal = 60;

        int actualTotal = orderService.calculateTotalOrder(price, quantity);

        assertEquals(expectedTotal, actualTotal);
    }
}

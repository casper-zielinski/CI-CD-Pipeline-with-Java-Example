package at.fhj.msd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {

    private OrderService orderService;
    private Calculator calculatorMock;

    @BeforeEach
    public void setUp() {
        calculatorMock = mock(Calculator.class);
        orderService = new OrderService(calculatorMock);
    }

    @Test
    public void testOrder() {
        when(calculatorMock.multiply(1, 2)).thenReturn(2);

        assertEquals(2, orderService.calculateTotalOrder(1, 2));

        verify(calculatorMock).multiply(1, 2);
    }
}
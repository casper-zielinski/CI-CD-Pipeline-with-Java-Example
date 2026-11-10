package at.fhj.msd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorParameterizedTest {
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({"2,3,6", "0,7,0", "-2,3,-6", "-2,-3,6", "1,7,7"})
    void multipliesIntegers(int left, int right, int expected) {
        assertEquals(expected, new CalculatorImpl().multiply(left, right));
    }
}

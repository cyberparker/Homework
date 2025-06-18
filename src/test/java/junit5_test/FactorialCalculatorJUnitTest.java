package junit5_test;

import lesson2_7.FactorialCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorJUnitTest {
    @Test
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
    }
    @Test
    void testFactorialOfPositiveNumber() {
        assertEquals(120, FactorialCalculator.calculateFactorial(5)); // 5! = 120
    }
    @Test
    void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.calculateFactorial(1));
    }
    @Test
    void testNegativeInput() {
        assertThrows(IllegalArgumentException.class, () ->
                FactorialCalculator.calculateFactorial(-1)
        );
    }
}
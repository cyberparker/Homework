package junit5_test;

import lesson2_7.ArithmeticOperations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsJUnitTest {
    @Test
    void testAddition() {
        assertEquals(8, ArithmeticOperations.add(5, 3));
    }
    @Test
    void testSubtraction() {
        assertEquals(2, ArithmeticOperations.subtract(5, 3));
    }
    @Test
    void testMultiplication() {
        assertEquals(15, ArithmeticOperations.multiply(5, 3));
    }
    @Test
    void testDivision() {
        assertEquals(2.5, ArithmeticOperations.divide(5, 2));
    }
    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () ->
                ArithmeticOperations.divide(5, 0)
        );
    }
}
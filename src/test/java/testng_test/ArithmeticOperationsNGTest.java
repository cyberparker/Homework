package testng_test;

import lesson2_7.ArithmeticOperations;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ArithmeticOperationsNGTest {
    @Test
    public void testAddition() {
        assertEquals(ArithmeticOperations.add(5, 3), 8);
    }
    @Test
    public void testSubtraction() {
        assertEquals(ArithmeticOperations.subtract(5, 3), 2);
    }
    @Test
    public void testMultiplication() {
        assertEquals(ArithmeticOperations.multiply(5, 3), 15);
    }
    @Test
    public void testDivision() {
        assertEquals(ArithmeticOperations.divide(5, 2), 2.5);
    }
    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        ArithmeticOperations.divide(5, 0);  // TestNG проверит исключение автоматически
    }
}
package testng_test;

import lesson2_7.FactorialCalculator;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FactorialCalculatorNGTest {
    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(FactorialCalculator.calculateFactorial(5), 120L, "5! должно быть 120");
    }
    @Test
    public void testFactorialOfOne() {
        assertEquals(FactorialCalculator.calculateFactorial(1), 1L, "1! должно быть 1");
    }
    @Test
    public void testFactorialOfZero() {
        assertEquals(FactorialCalculator.calculateFactorial(0), 1L, "0! должно быть 1");
    }
    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Факториал отрицательного числа не определен")
    public void testFactorialOfNegativeNumber() {
        // // здесь результат не используется, это норм, мне нужно только исключение
        FactorialCalculator.calculateFactorial(-5);
    }
    @Test
    public void testFactorialOfLargeNumber() {
        assertEquals(FactorialCalculator.calculateFactorial(10), 3628800L, "10! должно быть 3628800");
    }
}
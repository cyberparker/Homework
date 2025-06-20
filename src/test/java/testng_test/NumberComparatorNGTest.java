package testng_test;

import lesson2_7.NumberComparator;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class NumberComparatorNGTest {
    @Test
    public void testFirstGreaterThanSecond() {
        String result = NumberComparator.compare(5, 3);
        assertEquals(result, "5 > 3");
    }
    @Test
    public void testFirstLessThanSecond() {
        String result = NumberComparator.compare(3, 5);
        assertEquals(result, "3 < 5");
    }
    @Test
    public void testNumbersEqual() {
        String result = NumberComparator.compare(4, 4);
        assertEquals(result, "4 == 4");
    }
    @Test
    public void testNegativeNumbers() {
        String result = NumberComparator.compare(-1, -2);
        assertEquals(result, "-1 > -2");
    }
}
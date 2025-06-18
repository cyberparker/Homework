package junit5_test;

import lesson2_7.NumberComparator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorJUnitTest {
    @Test
    void testFirstGreaterThanSecond() {
        assertEquals("5 > 3", NumberComparator.compare(5, 3));
    }
    @Test
    void testFirstLessThanSecond() {
        assertEquals("3 < 5", NumberComparator.compare(3, 5));
    }
    @Test
    void testNumbersEqual() {
        assertEquals("4 == 4", NumberComparator.compare(4, 4));
    }
    @Test
    void testNegativeNumbers() {
        assertEquals("-1 > -2", NumberComparator.compare(-1, -2));
    }
}
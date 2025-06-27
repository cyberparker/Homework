package junit5_test;

import lesson2_7.TriangleAreaCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaCalculatorJUnitTest {
    @Test
    void testValidTriangle() {
        assertEquals(6.0, TriangleAreaCalculator.calculateArea(3, 4, 5)); // Прямоугольный треугольник
    }
    @Test
    void testEquilateralTriangle() {
        double expected = Math.sqrt(3) / 4 * 2 * 2; // Формула для равностороннего треугольника
        assertEquals(expected, TriangleAreaCalculator.calculateArea(2, 2, 2), 0.001);
    }
    @Test
    void testInvalidTriangle() {
        assertThrows(IllegalArgumentException.class, () ->
                TriangleAreaCalculator.calculateArea(1, 1, 3) // Несуществующий треугольник
        );
    }
    @Test
    void testNegativeSides() {
        assertThrows(IllegalArgumentException.class, () ->
                TriangleAreaCalculator.calculateArea(-1, 2, 2)
        );
    }
}
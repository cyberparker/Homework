package testng_test;

import lesson2_7.TriangleAreaCalculator;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TriangleAreaCalculatorNGTest {
    @Test
    public void testValidTriangle() {
        double result = TriangleAreaCalculator.calculateArea(3, 4, 5);
        assertEquals(result, 6.0, "Площадь прямоугольного треугольника 3-4-5 должна быть 6.0");
    }
    @Test
    public void testEquilateralTriangle() {
        double expected = Math.sqrt(3) / 4 * 2 * 2;
        double result = TriangleAreaCalculator.calculateArea(2, 2, 2);
        assertEquals(result, expected, 0.001, "Площадь равностороннего треугольника со стороной 2");
    }
    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Треугольника с такими сторонами не существует")
    public void testInvalidTriangle() {
        TriangleAreaCalculator.calculateArea(1, 1, 3);
    }
    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Стороны треугольника должны быть положительными")
    public void testNegativeSides() {
        TriangleAreaCalculator.calculateArea(-1, 2, 2);
    }
}
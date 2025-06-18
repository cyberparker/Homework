package lesson2_7;

public class TriangleAreaCalculator {
    public static double calculateArea(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны быть положительными");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Треугольника с такими сторонами не существует");
        }
        double p = (a + b + c) / 2; // Полупериметр
        return Math.sqrt(p * (p - a) * (p - b) * (p - c)); // Формула Герона
    }
}
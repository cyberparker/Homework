/*
 Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
 и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,если обе сложно).
 Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
 */

package lesson2_2;

public class Task13 {
    public static void main(String[] args) {
        int size = 5;
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
            matrix[i][size - 1 - i] = 1;
        }
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

package lesson2_5;

public class ArrayProcessor {
    public static class MyArraySizeException extends Exception {
        public MyArraySizeException() {
            super("Массив должен быть размером 4х4");
        }
    }
    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(int row, int col, String value) {
            // для проверки ячеек массива на формат
            super(String.format("Ошибка в ячейке [%d][%d]: '%s' - не число", row, col, value)); // %d - спецификатор формата целых чисел, а %s для строки.
        }
    }
    public static int sum4x4Matrix(String[][] matrix) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (matrix.length != 4 || matrix[0].length != 4) {
            throw new MyArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, matrix[i][j]);
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        //  Корректный массив
        String[][] correctMatrix = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        //  Массив с ошибкой данных
        String[][] invalidDataMatrix = {
                {"1", "2", "3", "4"},
                {"5", "6", "X", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        //  Массив неправильного размера
        String[][] wrongSizeMatrix = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };
        // Проверка работы с корректным массивом
        try {
            System.out.println("Сумма корректного массива: " + sum4x4Matrix(correctMatrix));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        // Проверка работы с массивом, содержащим нечисловые данные
        try {
            System.out.println("Сумма массива с ошибкой: " + sum4x4Matrix(invalidDataMatrix));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        // Проверка работы с массивом неправильного размера
        try {
            System.out.println("Сумма массива неправильного размера: " + sum4x4Matrix(wrongSizeMatrix));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        // Генерация и обработка ArrayIndexOutOfBoundsException
        try {
            String[][] smallArray = new String[2][2];
            System.out.println(smallArray[4][4]); // Выход за границы массива
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
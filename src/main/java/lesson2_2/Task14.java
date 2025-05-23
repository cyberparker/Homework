/*
Написать метод, принимающий на вход два аргумента:
len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.
 */

package lesson2_2;

public class Task14 {
    public static int[] createArray(int len, int initialValue) {

        int[] array = new int[len];


        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }

        return array;
    }

    public static void main(String[] args) {

        int[] result = createArray(5, 10);


        System.out.println(java.util.Arrays.toString(result));

    }
}

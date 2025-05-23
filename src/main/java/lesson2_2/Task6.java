package lesson2_2;

/*
6. Напишите метод, которому в качестве параметра передается целое число,
 метод должен напечатать в консоль, положительное ли число передали или отрицательное.
  Замечание: ноль считаем положительным числом.
 */
public class Task6 {
    public static void isItPositive(int val) {
        if (val >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    public static void main(String[] args) {
        isItPositive(-10);
    }


}

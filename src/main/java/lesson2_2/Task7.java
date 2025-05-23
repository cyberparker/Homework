package lesson2_2;

/*
7. Напишите метод, которому в качестве параметра передается целое число.
 Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
Замечание: ноль считаем положительным числом.
 */
public class Task7 {
    public static boolean posNeg(int num) {
        boolean val;
        if (num >= 0) {
            System.out.println(val = false);
        } else {
            System.out.println(val = true);
        }
        return (val);
    }

    public static void main(String[] args) {
        posNeg(150);

    }


}

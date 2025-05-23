package lesson2_2;

/*
9. Напишите метод, который определяет, является ли год високосным, и возвращает boolean
 (високосный - true, не високосный - false).
  Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
 */
public class Task9 {
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return year % 4 == 0;
        }

    }
    public static void main(String[] args) {
        System.out.println(isLeapYear(2004)); // каждый 4-й високосный
        System.out.println(isLeapYear(1900)); // каждый 100-й не високосный
        System.out.println(isLeapYear(2000)); // каждый 400-й високосный
        System.out.println(isLeapYear(2025)); // просто по приколу
    }


}

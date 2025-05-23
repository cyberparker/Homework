package lesson2_2;
/*
8. Напишите метод, которому в качестве аргументов передается строка и число,
метод должен отпечатать в консоль указанную строку, указанное количество раз;
 */
public class Task8 {
    public static void printString(String text, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }
public static void main(String[] args){
        printString("hello", 10);
}


    }

package lesson2_6_2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
    private final Map<String, List<String>> directory;
    public PhoneDirectory() {
        directory = new HashMap<>();
    }
    // добавление записи в справочник
    public void add(String lastName, String phoneNumber) {
        // если фамилия уже есть в справочнике, добавить номер к существующему списку
        directory.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
    }
    // поиск номеров по фамилии
    public List<String> get(String lastName) {
        // возвращаем список номеров или пустой список, если фамилии нет
        return directory.getOrDefault(lastName, new ArrayList<>());
    }
    // доп. метод для вывода всего справочника (для удобства тестирования)
    public void printAll() {
        directory.forEach((lastName, phones) -> {
            System.out.println(lastName + ": " + phones);
        });
    }
    // пример использования
    public static void main(String[] args) {
        PhoneDirectory phoneBook = new PhoneDirectory();
        // добавление записи
        phoneBook.add("Иванов", "123-456");
        phoneBook.add("Петров", "789-012");
        phoneBook.add("Иванов", "345-678"); // у Иванова теперь 2 номера
        // поиск номера
        System.out.println("Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Петров: " + phoneBook.get("Петров"));
        System.out.println("Сидоров: " + phoneBook.get("Сидоров")); // нет в справочнике
        System.out.println("\nВесь справочник:");
        phoneBook.printAll();
    }
}

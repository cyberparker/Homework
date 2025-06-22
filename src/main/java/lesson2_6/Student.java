package lesson2_6;
import java.util.*;

class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    public Student(String name, String group, int course, Map<String, Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }
    public String getName() {
        return name;
    }
    public String getGroup() {
        return group;
    }
    public int getCourse() {
        return course;
    }
    public void setCourse(int course) {
        this.course = course;
    }
    public Map<String, Integer> getGrades() {
        return grades;
    }
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", grades=" + grades +
                '}';
    }
}
class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        // создание студентов и добавление их в коллекцию
        Map<String, Integer> grades1 = new HashMap<>();
        grades1.put("Math", 4);
        grades1.put("Physics", 5);
        grades1.put("Chemistry", 3);
        students.add(new Student("Balbes", "Group A", 1, grades1));
        Map<String, Integer> grades2 = new HashMap<>();
        grades2.put("Math", 2);
        grades2.put("Physics", 3);
        grades2.put("Chemistry", 2);
        students.add(new Student("Trus", "Group B", 2, grades2));
        Map<String, Integer> grades3 = new HashMap<>();
        grades3.put("Math", 5);
        grades3.put("Physics", 5);
        grades3.put("Chemistry", 5);
        students.add(new Student("Bivaliy", "Group A", 1, grades3));
        System.out.println("All students:");
        students.forEach(System.out::println);
        // удаление студентов со средним баллом <3
        removeUnderperformingStudents(students);
        System.out.println("\nStudents after removing underperformers:");
        students.forEach(System.out::println);
        // перевод студентов на следующий курс
        promoteStudents(students);
        System.out.println("\nStudents after promotion:");
        students.forEach(System.out::println);
        // вывод студентов определенного курса
        System.out.println("\nStudents on course 1:");
        printStudents(students, 1);
    }
    public static void removeUnderperformingStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3.0);
    }
    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }
    public static void printStudents(Set<Student> students, int course) {
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(student -> System.out.println(student.getName()));
    }
}
package B7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@FunctionalInterface
interface Operation<T> {
    T execute(T a, T b);
}

class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        setGpa(gpa);
    }

    public String getId() {return id;}
    public String getName() {return name;}
    public double getGpa() {return gpa; }

    public void setId(String id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setGpa(double gpa) {this.gpa = gpa;}
}

public class main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String id = scanner.next();
            String name = scanner.next();
            double gpa = scanner.nextDouble();
            students.add(new Student(id, name, gpa));
        }
        students.removeIf(student -> student.getGpa() < 5.0);
        System.out.println("After removing GPA < 5.0:");
        for (Student student : students) {
            System.out.println(student.getId() + " " + student.getName() + " " + student.getGpa());
        }
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("\nAfter sorting by name:");
        for (Student student : students) {
            System.out.println(student.getId() + " " + student.getName() + " " + student.getGpa());
        }
        Operation<Double> add = (a, b) -> a + b;
        Operation<Double> subtract = (a, b) -> a - b;
        Operation<Double> multiply = (a, b) -> a * b;
        Operation<Double> divide = (a, b) -> b != 0 ? a / b : 0.0;

        scanner.close();
    }
}

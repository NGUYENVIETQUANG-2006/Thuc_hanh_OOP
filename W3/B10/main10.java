package B10;

import java.util.ArrayList;
import java.util.Scanner;

class Employee10 {
    protected String name;
    protected double baseSalary;

    public Employee10(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateBonus() {
        return baseSalary * 0.10;
    }

    public String getName() {
        return name;
    }
}

class Developer extends Employee10 {
    private int overtimeHours;

    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateBonus() {
        return super.calculateBonus() + (overtimeHours * 200000.0);
    }
}

class Tester extends Employee10 {
    private int bugsFound;

    public Tester(String name, double baseSalary, int bugsFound) {
        super(name, baseSalary);
        this.bugsFound = bugsFound;
    }

    @Override
    public double calculateBonus() {
        return super.calculateBonus() + (bugsFound * 50000.0);
    }
}

public class main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        ArrayList<Employee10> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("E")) {
                list.add(new Employee10(name, salary));
            } else if (type.equals("D")) {
                int overtime = sc.nextInt();
                list.add(new Developer(name, salary, overtime));
            } else if (type.equals("T")) {
                int bugs = sc.nextInt();
                list.add(new Tester(name, salary, bugs));
            }
        }

        for (Employee10 emp : list) {
            System.out.println(emp.getName() + " - Bonus: " + emp.calculateBonus());
            
            if (emp instanceof Developer) {
                System.out.println("Tặng khóa học AWS");
            } else if (emp instanceof Tester) {
                System.out.println("Tặng tool Test");
            }
            System.out.println();
        }
    }
}

package B5;

import java.util.Scanner;

abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();
    public abstract String getType();

    public String getName() {
        return name;
    }
}

class FullTimeEmployee extends Employee {
    private double baseSalary;
    private double bonus;
    private double penalty;

    public FullTimeEmployee(String name, double baseSalary, double bonus, double penalty) {
        super(name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.penalty = penalty;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (bonus - penalty);
    }

    @Override
    public String getType() {
        return "Full-time";
    }
}

class PartTimeEmployee extends Employee {
    private int workingHours;
    private double hourlyRate;

    public PartTimeEmployee(String name, int workingHours, double hourlyRate) {
        super(name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return workingHours * hourlyRate;
    }

    @Override
    public String getType() {
        return "Part-time";
    }
}

public class main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.findInLine("\"([^\"]*)\"");
            if (name != null) {
                name = name.replace("\"", "");
            } else {
                name = sc.next();
            }
            if (type.equals("F")) {
                double baseSalary = sc.nextDouble();
                double bonus = sc.nextDouble();
                double penalty = sc.nextDouble();
                employees[i] = new FullTimeEmployee(name, baseSalary, bonus, penalty);
            } else if (type.equals("P")) {
                int hours = sc.nextInt();
                double rate = sc.nextDouble();
                employees[i] = new PartTimeEmployee(name, hours, rate);
            }
        }

        for (Employee emp : employees) {
            System.out.println(emp.getName() + " - " + emp.getType() + " - " + emp.calculateSalary());
        }
    }
}
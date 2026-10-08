package B1;

class Person {
    private String name;
    private String dob;

    // Constructor mặc định ban đầu
    public Person() {
        System.out.println("1. Person is created");
    }

    // Constructor nâng cao
    /*public Person(String name) {
        this.name = name;
        System.out.println("1. Person is created with name: " + name);
    }*/
}

class Employee extends Person {
    private double salary;

    public Employee() {
        //super("Default Name");
        System.out.println("2. Employee is created");
    }
}

class Manager extends Employee {
    private String department;

    public Manager() {
        //super(); // Gọi constructor của Employee
        System.out.println("3. Manager is created");
    }
}

public class main1 {
    public static void main(String[] args) {
        Manager m = new Manager();
    }
}
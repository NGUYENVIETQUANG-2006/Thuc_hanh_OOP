import java.util.Scanner;

interface IWorker {void work();}

abstract class Worker implements IWorker {
    private String id, name;
    private double baseSalary;

    public String getId() {return id;}
    public String getName() {return name;}
    public double getBaseSalary() {return baseSalary;}

    public void setId(String id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setBaseSalary(double baseSalary) {this.baseSalary = baseSalary;}

    public Worker(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract double calculateSalary();
}

class OfficeWorker extends Worker {
    public OfficeWorker(String id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    @Override
    double calculateSalary() {
        return this.getBaseSalary();
    }

    @Override
    public void work() {
        System.out.println("Soạn thảo văn bản.\n");
    }
}

class Technician extends Worker {
    private double overtimeHours;

    public double getOvertimeHours() {return overtimeHours;}
    public void setOvertimeHours(double overtimeHours) {this.overtimeHours = overtimeHours;}

    public Technician(String id, String name, double baseSalary, double overtimeHours) {
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    double calculateSalary() {
        return this.getBaseSalary() + this.getOvertimeHours() * 20000;
    }

    @Override
    public void work() {
        System.out.println("Lắp đặt thiết bị.\n");
    }
}

public class main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String id = scanner.next();
            String name = scanner.next();
            double baseSalary = scanner.nextDouble();
            if (type.equals("O")) {
                workers[i] = new OfficeWorker(id, name, baseSalary);
            } else if (type.equals("T")) {
                double overtimeHours = scanner.nextDouble();
                workers[i] = new Technician(id, name, baseSalary, overtimeHours);
            }
        }
        double totalSalary = 0;
        for (Worker worker : workers) {
            totalSalary += worker.calculateSalary();
            System.out.println(worker.getName() + " - Pay: " + worker.calculateSalary());
            worker.work();
        }
        System.out.printf("Total Pay: %.1f\n", totalSalary);
        scanner.close();
    }
}

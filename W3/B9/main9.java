package B9;

import java.util.Scanner;

interface IPayable {
    double getPaymentAmount();
}

abstract class Staff implements IPayable {
    private String id;
    private String name;

    public Staff(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class PartTimeStaff extends Staff {
    private int workingHours;
    private double hourlyRate;

    public PartTimeStaff(String id, String name, int workingHours, double hourlyRate) {
        super(id, name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getPaymentAmount() {
        return workingHours * hourlyRate;
    }
}

class Invoice implements IPayable {
    private String itemName;
    private int quantity;
    private double pricePerItem;

    public Invoice(String itemName, int quantity, double pricePerItem) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }

    public String getItemName() {
        return itemName;
    }
}

public class main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        IPayable[] payableList = new IPayable[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            if (type.equals("S")) {
                String id = sc.next();
                String name = sc.next();
                int hours = sc.nextInt();
                double rate = sc.nextDouble();
                payableList[i] = new PartTimeStaff(id, name, hours, rate);
            } else if (type.equals("I")) {
                String item = sc.next();
                int qty = sc.nextInt();
                double price = sc.nextDouble();
                payableList[i] = new Invoice(item, qty, price);
            }
        }

        double totalPayment = 0;
        for (IPayable item : payableList) {
            double payment = item.getPaymentAmount();
            totalPayment += payment;

            if (item instanceof PartTimeStaff) {
                PartTimeStaff staff = (PartTimeStaff) item;
                System.out.println("PartTimeStaff " + staff.getName() + " - Payment: " + payment);
            } else if (item instanceof Invoice) {
                Invoice inv = (Invoice) item;
                System.out.println("Invoice " + inv.getItemName() + " - Payment: " + payment);
            }
        }

        System.out.println("Total Payment = " + totalPayment);
    }
}

package B6;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Product {
    protected String name;
    protected double basePrice;

    public Product(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public double getFinalPrice() {
        return basePrice;
    }

    public String getType() {
        return "Product";
    }

    public String getName() {
        return name;
    }
}

class Electronics extends Product {
    private double warrantyFee;

    public Electronics(String name, double basePrice, double warrantyFee) {
        super(name, basePrice);
        this.warrantyFee = warrantyFee;
    }

    @Override
    public double getFinalPrice() {
        return basePrice * 1.10 + warrantyFee;
    }

    @Override
    public String getType() {
        return "Electronics";
    }
}

class Food extends Product {
    private LocalDate expiryDate;

    public Food(String name, double basePrice, LocalDate expiryDate) {
        super(name, basePrice);
        this.expiryDate = expiryDate;
    }

    @Override
    public double getFinalPrice() {
        LocalDate today = LocalDate.of(2025, 3, 1);
        long daysUntilExpiry = ChronoUnit.DAYS.between(today, expiryDate);

        if (daysUntilExpiry < 7) {
            return basePrice * 0.8;
        }
        return basePrice;
    }

    @Override
    public String getType() {
        return "Food";
    }
}

public class main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        Product[] products = new Product[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();

            if (type.equals("E")) {
                double warranty = sc.nextDouble();
                products[i] = new Electronics(name, price, warranty);
            } else if (type.equals("F")) {
                String dateStr = sc.next();
                LocalDate expiryDate = LocalDate.parse(dateStr);
                products[i] = new Food(name, price, expiryDate);
            }
        }

        for (Product p : products) {
            double finalPrice = p.getFinalPrice();
            total += finalPrice;
            System.out.println(p.getName() + " - " + p.getType() + " - " + finalPrice);
        }
        System.out.println("Total = " + total);
    }
}
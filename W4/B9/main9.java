package B9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Product {
    private String id, name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {return this.id;}
    public String getName() {return this.name;}

    public abstract String getInfo();
}

class Food extends Product {
    private String expiryDate;

    public Food(String id, String name, String expiryDate) {
        super(id, name);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {return this.expiryDate;}

    @Override
    public String getInfo() {
        return this.getName() + " - " + this.getExpiryDate();
    }
}

class Electronic extends Product {
    private int warrantyMonths;

    public Electronic(String id, String name, int warrantyMonths) {
        super(id, name);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {return this.warrantyMonths;}

    @Override
    public String getInfo() {
        return this.getName() + " - " + this.getWarrantyMonths() + " tháng bảo hành";
    }
}

class Warehouse<T extends Product> {
    private List<T> items;

    public Warehouse() {
        this.items = new ArrayList<>();
    }

    public void addProduct(T item) {
        items.add(item);
    }

    public void removeProduct(T item) {
        items.remove(item);
    }

    public void inventoryCheck() {
        for (T item : items) {
            System.out.println(item.getInfo());
        }
    }
}

public class main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Warehouse<Food> foodWarehouse = new Warehouse<>();
        Warehouse<Electronic> electronicWarehouse = new Warehouse<>();

        for(int i = 0; i < n; i++) {
            String type = scanner.next();
            String id = scanner.next();
            String name = scanner.next();
            if (type.equalsIgnoreCase("F")) {
                String expiryDate = scanner.next();
                foodWarehouse.addProduct(new Food(id, name, expiryDate));
            }
            if (type.equalsIgnoreCase("E")) {
                int warrantyMonths = scanner.nextInt();
                electronicWarehouse.addProduct(new Electronic(id, name, warrantyMonths));
            }
        }

        System.out.println("Kho Thực phẩm:");
        foodWarehouse.inventoryCheck();
        System.out.println();
        System.out.println("Kho Điện tử:");
        electronicWarehouse.inventoryCheck();

        scanner.close();
    }
}

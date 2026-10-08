package B7;

import java.util.Scanner;

abstract class Room {
    protected int nights;

    public Room(int nights) {
        this.nights = nights;
    }

    public abstract double calculateTotal();
}

class StandardRoom extends Room {
    public StandardRoom(int nights) {
        super(nights);
    }

    @Override
    public double calculateTotal() {
        double total = nights * 500000.0;
        if (nights > 3) {
            total *= 0.95;
        }
        return total;
    }
}

class VIPRoom extends Room {
    public VIPRoom(int nights) {
        super(nights);
    }

    @Override
    public double calculateTotal() {
        return nights * 2000000.0;
    }
}

public class main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            String type = sc.next();
            int nights = sc.nextInt();

            Room room;
            if (type.equalsIgnoreCase("S")) {
                room = new StandardRoom(nights);
            } else {
                room = new VIPRoom(nights);
            }

            System.out.println((long) room.calculateTotal());
        }
    }
}

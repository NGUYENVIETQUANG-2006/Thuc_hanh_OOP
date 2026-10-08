package B8;

import java.util.Scanner;

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

interface GPS {
    void getCoordinates();
}

abstract class Robot {
    private int id;
    private String modelName;
    private int batteryLevel;

    public Robot(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
        this.batteryLevel = 100;
    }

    public void chargeBattery() {
        this.batteryLevel = 100;
    }

    public final void showIdentity() {
        System.out.println("ID: " + id + ", Model: " + modelName);
    }

    public String getModelName() {
        return modelName;
    }

    public abstract void performMainTask();
}

class DroneRobot extends Robot implements Flyable, GPS {
    public DroneRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    public void performMainTask() {
        System.out.println(getModelName() + " performing main task");
    }

    @Override
    public void fly() {
        System.out.println(getModelName() + " flying");
    }

    @Override
    public void getCoordinates() {
        System.out.println(getModelName() + " getting coordinates");
    }
}

class FishRobot extends Robot implements Swimmable {
    public FishRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    public void performMainTask() {
        System.out.println(getModelName() + " performing main task");
    }

    @Override
    public void swim() {
        System.out.println(getModelName() + " swimming");
    }
}

class AmphibiousRobot extends Robot implements Flyable, Swimmable, GPS {
    public AmphibiousRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    public void performMainTask() {
        System.out.println(getModelName() + " performing main task");
    }

    @Override
    public void fly() {
        System.out.println(getModelName() + " flying");
    }

    @Override
    public void swim() {
        System.out.println(getModelName() + " swimming");
    }

    @Override
    public void getCoordinates() {
        System.out.println(getModelName() + " getting coordinates");
    }
}

public class main8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        Robot[] robots = new Robot[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int id = sc.nextInt();
            String model = sc.next();

            if (type.equals("DR")) {
                robots[i] = new DroneRobot(id, model);
            } else if (type.equals("FR")) {
                robots[i] = new FishRobot(id, model);
            } else if (type.equals("AR")) {
                robots[i] = new AmphibiousRobot(id, model);
            }
        }

        for (Robot r : robots) {
            r.performMainTask();

            if (r instanceof Flyable) {
                ((Flyable) r).fly();
            }
            if (r instanceof Swimmable) {
                ((Swimmable) r).swim();
            }
            if (r instanceof GPS) {
                ((GPS) r).getCoordinates();
            }
            System.out.println();
        }
    }
}

package B8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface IAdjustable {void adjust();}
interface IWifiConnectable {void connectWifi();}

abstract class Device {
    private int id;
    private String name;
    private boolean isOn;

    public Device(int id, String name) {
        this.id = id;
        this.name = name;
        this.isOn = true;
    }

    public int getId() {return id;}
    public String getName() {return name;}

    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}

    abstract void turnOn();
    abstract void turnOff();
}

class Light extends Device implements IAdjustable {
    public Light(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(this.getName() + " turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println(this.getName() + " turned off.");
    }

    public void adjust() {
        System.out.println(this.getName() + " brightness adjusted.");
    }
}

class AC extends Device implements IWifiConnectable {
    public AC(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(this.getName() + " turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println(this.getName() + " turned off.");
    }

    public void connectWifi() {
        System.out.println(this.getName() + " connected to WiFi.");
    }
}

class Speaker extends Device implements IAdjustable, IWifiConnectable {
    public Speaker(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(this.getName() + " turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println(this.getName() + " turned off.");
    }

    public void adjust() {
        System.out.println(this.getName() + " volume adjusted.");
    }

    public void connectWifi() {
        System.out.println(this.getName() + " connected to WiFi.");
    }
}

class Curtain extends Device {
    public Curtain(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(this.getName() + " turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println(this.getName() + " turned off.");
    }
}

class Hub {
    private List<Device> devices;

    public Hub() {
        devices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void turnOffAllDevices() {
        System.out.println("Turn Off All Devices:");
        for (Device device : devices) {
            device.turnOff();
        }
    }

    public void setupWifi() {
        System.out.println("Setup Wifi:");
        for (Device device : devices) {
            if (device instanceof IWifiConnectable) {
                ((IWifiConnectable) device).connectWifi();
            }
        }
    }
}

public class main8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Hub hub = new Hub();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int id = scanner.nextInt();
            String name = scanner.next();
            switch (type) {
                case "L":
                    hub.addDevice(new Light(id, name));
                    break;
                case "AC":
                    hub.addDevice(new AC(id, name));
                    break;
                case "S":
                    hub.addDevice(new Speaker(id, name));
                    break;
                case "C":
                    hub.addDevice(new Curtain(id, name));
                    break;
            }
        }
        hub.turnOffAllDevices();
        System.out.println();
        hub.setupWifi();
        scanner.close();
    }
}

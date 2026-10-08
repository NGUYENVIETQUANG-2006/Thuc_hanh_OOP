package B4;

class Animal {
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof woof");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meows meows");
    }
}

class Duck extends Animal {
}

public class main4 {
    public static void main(String[] args) {
        Animal a = new Dog(); // Upcasting (An toan)

        // Sau khi sua (An toan voi instanceof):
        if (a instanceof Cat) {
            Cat c = (Cat) a;
            c.makeSound();
        } else {
            System.out.println("Day khong phai la Meo!");
        }
    }
}
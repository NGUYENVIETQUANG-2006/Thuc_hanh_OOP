abstract class Shape {
    protected int x, y;
    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract void draw();
    public abstract void erase();
    public void moveTo(int newX, int newY) {
        this.erase();
        x = newX;
        y = newY;
        this.draw();
    }
}

class Circle extends Shape {
    public Circle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle at (" + x + ", " + y + ")");
    }

    @Override
    public void erase() {
        System.out.println("Erasing a circle at (" + x + ", " + y + ")");
    }
}

class Square extends Shape {
    public Square(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a square at (" + x + ", " + y + ")");
    }

    @Override
    public void erase() {
        System.out.println("Erasing a square at (" + x + ", " + y + ")");
    }
}

public class main1 {
    public static void main(String[] args) {
        Circle circle = new Circle(10, 10);
        circle.moveTo(20, 20);
    }
}

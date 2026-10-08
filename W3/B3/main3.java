package B3;

class MathUtils {
    public int sum(int a, int b) {
        return a + b;
    }
}

class AdvancedMath extends MathUtils {
    @Override
    public int sum(int a, int b) {
        return a + b + 10;
    }

    // Overload
    public double sum(double a, double b) {
        return a + b;
    }
}

public class main3 {
    public static void main(String[] args) {
        MathUtils m = new AdvancedMath();
        System.out.println(m.sum(5, 5)); // (A) -> In ra 20

        //System.out.println(m.sum(5.5, 5.5)); // (B) -> Lỗi biên dịch
    }
}
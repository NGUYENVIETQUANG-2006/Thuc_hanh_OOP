import java.util.Scanner;

public class Solution6 {
    public long sumOfDigits(long n) {
        long sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Solution6 sol = new Solution6();
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(sol.sumOfDigits(n));
    }
}

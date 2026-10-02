import java.util.Scanner;

public class Solution {
    public long sumOfDigits(long n) {
        long sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(sol.sumOfDigits(n));
    }
}

public class Solution {
    public int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 820174281;
        System.out.println(sol.sumOfDigits(n));
    }
}

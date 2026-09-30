public class Solution {
    public int reverse(int n) {
        if (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE) {
            return 0;
        }
        int rev = 0;
        while (n != 0) {
            int pop = n % 10;
            n /= 10;
            rev = rev * 10 + pop;
        }
        return rev;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 1234500;
        System.out.println(sol.reverse(n));
    }
}

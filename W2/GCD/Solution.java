public class Solution {
    public int gcd (int a, int b) {
        return (a % b == 0) ? b : gcd(b, a % b);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int a = 48;
        int b = 18;
        System.out.println(sol.gcd(a, b));
    }
}

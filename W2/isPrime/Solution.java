public class Solution {
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int num = 20;
        System.out.println(num + " is prime : " + sol.isPrime(num));
    }
}

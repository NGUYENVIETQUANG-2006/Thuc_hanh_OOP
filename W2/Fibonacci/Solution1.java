public class Solution1 {
    public long fibonacci(long n) {
        if (n <= 1) {
            return n;
        } else {
            Long fib[] = new Long[(int) n + 1];
            fib[0] = 0L;
            fib[1] = 1L;
            for(int i = 2; i<= n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            return fib[(int) n];
        }
    }
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        long n = 100;
        Long res = sol.fibonacci(n); 
        if (res > Long.MAX_VALUE)  {
            res = Long.MAX_VALUE;
        }
        System.out.println(res);    
    }
}

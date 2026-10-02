public class Solution5 {
    public boolean isPalidrome(int n) {
        String str = String.valueOf(n);
        int len = str.length();
        for(int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution5 sol = new Solution5();
        int n = 123454321;
        System.out.println(sol.isPalidrome(n));
    }
}

public class Solution {
    public int secondLargest(int[] arr) {
        int len = arr.length;
        int max = arr[0];
        int secondMax = -1;
        for(int i = 1; i < len; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] < max && arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {5, 21, 43, 2, 9, 32, 45};
        System.out.println(sol.secondLargest(arr));
    }
}

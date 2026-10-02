import java.util.Scanner;

public class Solution7 {
    public int secondLargest(int[] arr) {
        int len = arr.length;
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;
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
        Solution7 sol = new Solution7();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(sol.secondLargest(arr));
    }
}

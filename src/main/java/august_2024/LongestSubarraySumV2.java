package august_2024;

public class LongestSubarraySumV2 {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 3, 3, 1, 2, 1, 2};
//        int target = 10;
        int[] arr = {0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        int target = 12;

        longestSubarray(arr, target);
    }

    // O(n) time | O(1) space
    public static int[] longestSubarray(int[] arr, int target) {
        int[] result = new int[] {-1, -1};
        int left = 0;
        int right = 0;
        int sum = 0;

        while (right < arr.length) {
            sum += arr[right];
            while (sum > target && left < right) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                if (right - left + 1 > result[1] - result[0]) {
                    result[1] = right;
                    result[0] = left;
                }
            }

            right++;
        }

        return result;
    }

}

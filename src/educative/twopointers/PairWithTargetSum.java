package educative.twopointers;

import java.util.HashMap;

public class PairWithTargetSum {

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search2(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }

    // O(n) time | O(1) space
    public static int[] search(int[] arr, int targetSum) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) {
                return new int[] {left, right};
            }

            if (targetSum > currentSum) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }

    public static int[] search2(int[] arr, int targetSum) {
        HashMap<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (nums.containsKey(targetSum - arr[i])) {
                return new int[] { nums.get(targetSum - arr[i]), i};
            } else {
                nums.put(arr[i], i);
            }
        }
        return new int[] { -1, -1};
    }
}

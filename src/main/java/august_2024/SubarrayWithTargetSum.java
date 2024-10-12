package august_2024;

import java.util.ArrayList;
import java.util.List;

public class SubarrayWithTargetSum {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 7, 2};
        List<Integer> numsArr = new ArrayList<>();
        for (int n : nums) {
            numsArr.add(n);
        }
        int k = 14;

        List<Integer> subarray = subarray(numsArr, k);
        System.out.println(subarray);
    }

    // O(n) time | O(1) space
    public static List<Integer> subarray(List<Integer> nums, int k) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int[] indexes = {-1, -1};
        while (end < nums.size()) {
            sum += nums.get(end);
            while (start < end && sum > k) {
                sum -= nums.get(start);
                start++;
            }
            if (sum == k) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    indexes[0] = start;
                    indexes[1] = end + 1;
                }
//                return nums.subList(start, end + 1);
            }

            end++;
        }

        if (indexes[0] == -1) {
            return null;
        }

        return nums.subList(indexes[0], indexes[1]);
    }

}

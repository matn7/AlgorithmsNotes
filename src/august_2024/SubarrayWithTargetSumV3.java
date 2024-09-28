package august_2024;

import java.util.ArrayList;
import java.util.List;

public class SubarrayWithTargetSumV3 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 2};
        List<Integer> nums = new ArrayList<>();
        for (int a : arr) {
            nums.add(a);
        }
        int k = 16;

        List<Integer> integers = subarrayWithTargetSum(nums, k);
        System.out.println(integers);
    }

    // O(n) time | O(1) space
    public static List<Integer> subarrayWithTargetSum(List<Integer> nums, int target) {
        if (nums.isEmpty()) {
            return nums;
        }

        int start = 0;
        int end = 0;
        int sum = 0;

        while (end < nums.size()) {
            sum += nums.get(end);
            while (start < end && sum > target) {
                sum -= nums.get(start);
                start++;
            }
            if (sum == target) {
                return nums.subList(start, end + 1);
            }

            end++;
        }
        return null;
    }

}

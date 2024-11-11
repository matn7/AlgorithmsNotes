package october_2024;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {1};

        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int result = firstMissingPositive.firstMissingPositive(nums);
        System.out.println(result);
    }

    // leetcode 49

    // O(n) time | O(1) space
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (val >= 1 && val <= nums.length) {
                if (nums[val - 1] > 0) {
                    nums[val - 1] *= -1;
                } else if (nums[val - 1] == 0) {
                    nums[val - 1] = -1 * (nums.length + 1);
                }
            }
        }

        for (int i = 1; i < nums.length + 1; i++) {
            if (nums[i - 1] >= 0) {
                return i;
            }
        }
        return nums.length + 1;
    }


    public int firstMissingPositive2(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num <= 0) {
                continue;
            }
            seen.add(num);
            max = Math.max(max, num);
        }
        for (int i = 1; i <= max; i++) {
            if (!seen.contains(i)) {
                return i;
            }
        }
        return max + 1;
    }

}

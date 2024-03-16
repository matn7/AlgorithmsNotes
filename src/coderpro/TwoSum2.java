package coderpro;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        TwoSum2 twoSum2 = new TwoSum2();
        int[] result = twoSum2.twoSum(nums, 18);
        System.out.println();
    }

    // O(n) time | O(n) space
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visited = new HashMap<>();
        int[] result = {-1, -1};

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int sum = target - num; // 18 - 11 = 7
            if (visited.containsKey(sum)) {
                return new int[] {visited.get(sum), i}; // {7, 11}
            } else {
                visited.put(num, i);
            }
        }

        // [2: 0, 7: 1, ]
        return result;
    }

}

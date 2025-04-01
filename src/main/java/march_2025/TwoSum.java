package march_2025;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, target);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> elems = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int key = target - num;
            if (elems.containsKey(key)) {
                return new int[] {elems.get(key), i};
            }
            elems.put(num, i);
        }
        return new int[] {-1, -1};
    }

}

package october_2023;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;

        int[] result = twoSums(nums, target);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int[] twoSums(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int key = target - num;
            if (seen.containsKey(key)) {
                result[0] = seen.get(key);
                result[1] = i;
                return result;
            } else {
                seen.put(num, i);
            }
        }

        return result;
    }

}

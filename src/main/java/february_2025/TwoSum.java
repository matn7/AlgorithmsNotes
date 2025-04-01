package february_2025;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, target);
        System.out.println(result);
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int sum = target - num;
            if (idxMap.containsKey(sum)) {
                return new int[] {idxMap.get(sum), i};
            } else {
                idxMap.put(num, i);
            }
        }

        return new int[] {};
    }

}

package december_2025;

import java.util.HashMap;
import java.util.Map;

public class NumSubarraysWithSum {

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;

        NumSubarraysWithSum numSubarraysWithSum = new NumSubarraysWithSum();
        int result = numSubarraysWithSum.numSubarraysWithSum(nums, goal);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int prefix = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);

        for (int num : nums) {
            prefix += num;
            if (prefixMap.containsKey(prefix - goal)) {
                count += prefixMap.get(prefix - goal);
            }
            prefixMap.put(prefix, prefixMap.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }

}

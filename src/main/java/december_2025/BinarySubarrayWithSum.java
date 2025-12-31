package december_2025;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarrayWithSum {

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;

        BinarySubarrayWithSum binarySubarrayWithSum = new BinarySubarrayWithSum();
        int result = binarySubarrayWithSum.numSubarraysWithSum(nums, goal);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        int prefix = 0;
        int count = 0;

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

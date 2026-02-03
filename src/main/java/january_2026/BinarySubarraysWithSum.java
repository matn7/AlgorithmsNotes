package january_2026;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;

        BinarySubarraysWithSum binarySubarraysWithSum = new BinarySubarraysWithSum();
        int result = binarySubarraysWithSum.numSubarraysWithSum(nums, goal);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        Map<Integer, Integer> countsMap = new HashMap<>();
        countsMap.put(0, 1);
        int prefix = 0;

        for (int num : nums) {
            prefix += num;
            if (countsMap.containsKey(prefix - goal)) {
                count += countsMap.get(prefix - goal);
            }
            countsMap.put(prefix, countsMap.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

}

package october_2025;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;

        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int result = subarraySumEqualsK.subarraySum(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            if (prefixCount.containsKey(currentSum - k)) {
                count += prefixCount.get(currentSum - k);
            }
            prefixCount.put(currentSum, prefixCount.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

}

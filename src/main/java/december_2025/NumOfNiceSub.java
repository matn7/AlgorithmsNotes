package december_2025;

import java.util.HashMap;
import java.util.Map;

public class NumOfNiceSub {

    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;

        NumOfNiceSub numOfNiceSub = new NumOfNiceSub();
        int result = numOfNiceSub.numberOfSubarrays(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int prefix = 0;
        Map<Integer, Integer> countsMap = new HashMap<>();
        countsMap.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i] % 2;

            if (countsMap.containsKey(prefix - k)) {
                count += countsMap.get(prefix - k);
            }
            countsMap.put(prefix, countsMap.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

}

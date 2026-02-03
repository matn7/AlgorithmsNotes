package january_2026;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;

        CountNumberOfNiceSubarrays countNumberOfNiceSubarrays = new CountNumberOfNiceSubarrays();
        int result = countNumberOfNiceSubarrays.numberOfSubarrays(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> countsMap = new HashMap<>();
        int prefix = 0;
        int count = 0;

        countsMap.put(0, 1);

        for (int num : nums) {
            prefix += num % 2;
            if (countsMap.containsKey(prefix - k)) {
                count += countsMap.get(prefix - k);
            }
            countsMap.put(prefix, countsMap.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

}

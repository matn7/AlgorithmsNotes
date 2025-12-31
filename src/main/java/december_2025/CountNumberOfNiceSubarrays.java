package december_2025;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {

    public static void main(String[] args) {
//        int[] nums = {1,1,2,1,1};
//        int k = 3;

        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;

        CountNumberOfNiceSubarrays countNumberOfNiceSubarrays = new CountNumberOfNiceSubarrays();
        int result = countNumberOfNiceSubarrays.numberOfSubarrays(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        int prefix = 0;
        int result = 0;

        for (int num : nums) {
            prefix += num % 2;

            if (count.containsKey(prefix - k)) {
                result += count.get(prefix - k);
            }

            count.put(prefix, count.getOrDefault(prefix, 0) + 1);
        }
        return result;
    }

}

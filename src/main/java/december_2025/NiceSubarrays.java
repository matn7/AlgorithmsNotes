package december_2025;

import java.util.HashMap;
import java.util.Map;

public class NiceSubarrays {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2, 1, 1};
//        int k = 3;

//        int[] nums = {2,4,6};
//        int k = 1;

        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;

        NiceSubarrays niceSubarrays = new NiceSubarrays();
        int result = niceSubarrays.numberOfSubarrays(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int prefix = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i] % 2;
            if (prefixMap.containsKey(prefix - k)) {
                count += prefixMap.get(prefix - k);
            }
            prefixMap.put(prefix, prefixMap.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }

}

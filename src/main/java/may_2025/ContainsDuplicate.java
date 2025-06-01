package may_2025;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
//        int k = 3;
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        boolean result = containsDuplicate.containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int L = 0;

        for (int R = 0; R < nums.length; R++) {
            if (R - L > k) {
                window.remove(nums[L]);
                L++;
            }
            if (window.contains(nums[R])) {
                return true;
            }
            window.add(nums[R]);
        }

        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> elems = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (elems.containsKey(nums[i])) {
                int j = elems.get(nums[i]);
                if (Math.abs(i - j) <= k) {
                    return true;
                }
            }
            elems.put(nums[i], i);
        }
        return false;
    }

}

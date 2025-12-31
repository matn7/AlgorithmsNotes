package december_2025;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII2 {

    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
//        int k = 3;

        int[] nums = {1,2,3,1,2,3};
        int k = 2;

        ContainsDuplicateII2 containsDuplicateII = new ContainsDuplicateII2();
        boolean result = containsDuplicateII.containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(k) space
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> numsSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (right - left > k) {
                numsSet.remove(nums[left]);
                left++;
            }
            int num = nums[right];
            if (numsSet.contains(num)) {
                return true;
            }
            numsSet.add(num);
        }
        return false;
    }


}

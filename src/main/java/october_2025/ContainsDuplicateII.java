package october_2025;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1, 2, 3};
//        int k = 2;

        int[] nums = {1,0,1,1};
        int k = 1;

        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        boolean result = containsDuplicateII.containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int L = 0;
        int R = 0;
        Set<Integer> window = new HashSet<>();

        while (R < nums.length) {
            if (R - L > k) {
                window.remove(nums[L]);
                L++;
            }
            if (window.contains(nums[R])) {
                return true;
            }
            window.add(nums[R]);
            R++;
        }
        return false;
    }


}

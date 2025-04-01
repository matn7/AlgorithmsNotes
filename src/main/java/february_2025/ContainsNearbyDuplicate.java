package february_2025;

import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;

        ContainsNearbyDuplicate containsNearbyDuplicate = new ContainsNearbyDuplicate();
        boolean result = containsNearbyDuplicate.containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int L = 0;
        int R = 1;
        Set<Integer> seen = new HashSet<>();
        seen.add(nums[L]); // {1, 2, }

        while (R < nums.length) {
            int num = nums[R];
            if (seen.contains(num)) {
                return true;
            }
            if (R - L + 1 > k) {
                seen.remove(nums[L]);
                L++;
            }
            seen.add(num);
            R++;
        }
        return false;
    }

}

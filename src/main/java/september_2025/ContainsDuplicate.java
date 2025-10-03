package september_2025;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    // O(n) time | O(n) space
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

}

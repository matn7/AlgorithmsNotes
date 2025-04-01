package february_2025;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        boolean result = containsDuplicate.containsDuplicate(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean containsDuplicate(int[] nums) {
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

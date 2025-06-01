package may_2025;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        ContainsDuplicate2 containsDuplicate2 = new ContainsDuplicate2();
        boolean result = containsDuplicate2.containsDuplicate(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

}

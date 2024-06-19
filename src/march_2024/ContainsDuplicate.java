package march_2024;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 1};

        boolean result = containsDuplicates(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static boolean containsDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Set<Integer> frequencyMap = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (frequencyMap.contains(num)) {
                return true;
            } else {
                frequencyMap.add(num);
            }
        }

        return false;
    }

}

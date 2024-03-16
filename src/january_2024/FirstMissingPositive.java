package january_2024;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};

        int result = firstMissing(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int firstMissing(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (num < 0) {
                continue;
            }
            min = Math.min(min, num);
            max = Math.max(max, num);
            seen.add(num);
        }
        if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
            return -1;
        }

        for (int i = min; i < max; i++) {
            if (!seen.contains(i)) {
                return i;
            }
        }
        return -1;

    }

}

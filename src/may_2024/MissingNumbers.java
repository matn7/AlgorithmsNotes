package may_2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingNumbers {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<Integer> result = missingNumber(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static List<Integer> missingNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        int missing = 2;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            seen.add(num);
        }

        for (int i = min; i <= max; i++) {
            if (!seen.contains(i)) {
                result.add(i);
                missing--;
            }
        }

        int counter = max + 1;
        while (missing != 0) {
            result.add(counter);
            missing--;
            counter++;
        }
        return result;
    }

}

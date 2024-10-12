package november_2023;

import java.util.HashSet;
import java.util.Set;

public class MissingNumbers {

    public static void main(String[] args) {
        int[] nums = {1, 4, 3};

        int[] result = missingNumbers(nums);
        System.out.println(result);
    }

    public static int[] missingNumbers(int[] nums) {
        int n = nums.length + 2;
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        int[] result = new int[2];
        int idx = 0;

        for (int i = 1; i <= n; i++) {
            if (!seen.contains(i)) {
                result[idx] = i;
                idx++;
            }
        }

        return result;
    }


}

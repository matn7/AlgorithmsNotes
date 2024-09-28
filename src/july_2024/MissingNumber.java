package july_2024;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    public static void main(String[] args) {

        int[] nums = {3, 2, 0};
        int result1 = missingNumber(nums);
        int result2 = missingNumber2(nums);

        System.out.println(result1);
        System.out.println(result2);
    }

    // O(n) time | O(1) space
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int intendedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return intendedSum - actualSum;
    }

    public static int missingNumber2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            numsSet.add(num);
        }
        for (int i = min; i < max; i++) {
            if (!numsSet.contains(i)) {
                return i;
            }
        }
        return -1;
    }

}

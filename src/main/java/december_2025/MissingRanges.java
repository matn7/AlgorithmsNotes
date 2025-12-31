package december_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {

    public static void main(String[] args) {
        MissingRanges missingRanges = new MissingRanges();
//        int[] nums = {0, 1, 3, 50, 75};
//        int lower = 0;
//        int upper = 100;

        int[] nums = {-1};
        int lower = -1;
        int upper = -1;

        List<List<Integer>> result = missingRanges.findMissingRanges(nums, lower, upper);
        System.out.println(result);
    }

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        long prev = (long) lower - 1; // -1
        long curr;

        for (int i = 0; i <= nums.length; i++) {
            if (i < nums.length) { // 3 <= 5
                curr = nums[i]; // 50
            } else {
                curr = (long) upper + 1;
            }

            if (curr - prev >= 2) { // 3 - (1) = 2 >= 2
                long start = prev + 1; // 2
                long end = curr - 1; // 2
                result.add(Arrays.asList((int) start, (int) end)); // [(2, 2), ]
            }
            prev = curr; // 3
         }
        return result;
    }

}

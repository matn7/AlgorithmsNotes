package december_2025;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges2 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;

        MissingRanges2 missingRanges2 = new MissingRanges2();
        List<List<Integer>> result = missingRanges2.findMissingRanges(nums, lower, upper);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int prev = lower - 1;
        int curr;

        for (int i = 0; i <= nums.length; i++) {
            if (i < nums.length) {
                curr = nums[i];
            } else {
                curr = upper + 1;
            }

            if (curr - prev >= 2) {
                int start = prev + 1;
                int end = curr - 1;
                result.add(List.of(start, end));
            }
            prev = curr;
        }
        return result;
    }

}

package january_2026;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public static void main(String[] args) {
//        int[] nums = {0, 1, 3, 50, 75};
//        int lower = 0;
//        int upper = 99;

        int[] nums = {-1};
        int lower = -1;
        int upper = -1;

        MissingRanges missingRanges = new MissingRanges();
        List<List<Integer>> result = missingRanges.findMissingRanges(nums, lower, upper);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int l = lower - 1;
        int r = lower;

        for (int i = 0; i <= nums.length; i++) {
            if (i == nums.length) {
                r = upper + 1;
            } else {
                r = nums[i];
            }

            if (r - l >= 2) {
                result.add(List.of(l + 1, r - 1));
            }
            l = r;
        }

        return result;
    }

}

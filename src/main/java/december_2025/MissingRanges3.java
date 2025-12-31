package december_2025;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges3 {

    public static void main(String[] args) {
//        int[] nums = {0,1,3,50,75};
//        int lower = 0;
//        int upper = 99;
        int[] nums = {-1};
        int lower = -1;
        int upper = -1;
        MissingRanges3 missingRanges3 = new MissingRanges3();
        List<List<Integer>> result = missingRanges3.findMissingRanges(nums, lower, upper);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int prev = lower - 1;
        int curr;
        List<List<Integer>> ranges = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            if (i < nums.length) {
                curr = nums[i];
            } else {
                curr = upper + 1;
            }

            if (curr - prev >= 2) {
                ranges.add(List.of(prev + 1, curr - 1));
            }

            prev = curr;
        }
        return ranges;
    }

}

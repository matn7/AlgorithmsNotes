package coderpro;

import java.util.ArrayList;
import java.util.List;

public class MergeListOfNumberIntoRanges {

    public static void main(String[] args) {
        // sorted numbers
        //            0  1  2  3  4  5  6  7  8   9   10
        int[] nums = {0, 1, 2, 5, 7, 8, 9, 9, 10, 11, 15};
        MergeListOfNumberIntoRanges mergeListOfNumberIntoRanges = new MergeListOfNumberIntoRanges();
        mergeListOfNumberIntoRanges.findRanges(nums);
    }

    // O(n) time | O(1) space
    public List<String> findRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        int low = nums[0];
        int high = nums[1];

        for (int n : nums) {
            if (high + 1 < n) {
                ranges.add(low + "-" + high);
                low = n;
                high = n;
            } else {
                high = n;
            }
        }
        ranges.add(low + "-" + high);
        return ranges;
    }

}

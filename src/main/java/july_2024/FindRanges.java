package july_2024;

import java.util.ArrayList;
import java.util.List;

public class FindRanges {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 5, 7, 8, 9, 9, 10, 11, 15};

        List<String> ranges = findRanges(nums);
        System.out.println(ranges);
    }

    // O(n) time | O(1) space
    public static List<String> findRanges(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
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

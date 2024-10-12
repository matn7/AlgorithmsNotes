package january_2024;

import java.util.ArrayList;
import java.util.List;

public class MergeListOfNumberIntoRanges {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 5, 7, 8, 9, 9, 10, 11, 15};

        findRanges(nums);
    }

    // O(n) time | O(1) space
    public static List<String> findRanges(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        List<String> ranges = new ArrayList<>();

        int low = nums[0];    // 7
        int high = nums[0];   // 9

        // [0, 1, 2, 5, 7, 8, 9, 9, 10, 11, 15]
        //           *
        //  l     h

        for (int i = 1; i < nums.length; i++) {
            int next = nums[i]; // 15
            if (high + 1 >= next) { // 13 >= 15
                high = next;
            } else {
                ranges.add(low + "-" + high);
                low = next;
                high = next;
            }
        }

        ranges.add(low + "-" + high);

        return ranges; // ["0-2", "5-5", ]
    }

}

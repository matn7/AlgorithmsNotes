package october_2023;

import java.util.ArrayList;
import java.util.List;

public class MergeListIntoRanges {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 5, 7, 8, 9, 9, 10, 11, 15};
        mergeList(nums);
    }

    public static List<String> mergeList(int[] nums) {
        List<String> result = new ArrayList<>();

        int low = nums[0];
        int high = nums[1];

        for (int n : nums) {
            if (high + 1 < n) {
                result.add(low + "-" + high);
                low = n;
                high = n;
            } else {
                high = n;
            }
        }
        result.add(low + "-" + high);

        return result;
    }

}

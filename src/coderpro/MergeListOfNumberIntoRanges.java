package coderpro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // O(n) time | O(n) space
    public List<List<Integer>> findRanges2(int[] nums) {
        Map<Integer, Integer> elemsMap = new HashMap<>();
        for (Integer num : nums) {
            if (elemsMap.containsKey(num)) {
                elemsMap.put(num, elemsMap.get(num) + 1);
            } else {
                elemsMap.put(num, 1);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        while (start < nums.length) {
            List<Integer> oneRes = new ArrayList<>();
            int num = nums[start];
            while (elemsMap.containsKey(num)) {
                Integer numOccur = elemsMap.get(num);
                for (int i = 0; i < numOccur; i++) {
                    oneRes.add(num);
                    start++;
                }
                num++;
            }
            result.add(oneRes);
        }
        return result;
    }

}

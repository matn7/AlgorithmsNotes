package july_2025;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConSeq {

    public static void main(String[] args) {
//        int[] nums = {100,4,200,1,3,2};
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        LongestConSeq longestConSeq = new LongestConSeq();
        int result = longestConSeq.longestConsecutive(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> elements = new HashMap<>();
        for (int num : nums) {
            elements.put(num, false);
        }
        int max = 0;
        for (int num : nums) {
            if (elements.get(num)) {
                continue;
            }
            int curr = 1;
            int toLeft = num - 1;
            while (elements.containsKey(toLeft)) {
                curr++;
                elements.put(toLeft, true);
                toLeft--;
            }
            int toRight = num + 1;
            while (elements.containsKey(toRight)) {
                curr++;
                elements.put(toRight, true);
                toRight++;
            }
            max = Math.max(max, curr);
        }
        return max;
    }

}

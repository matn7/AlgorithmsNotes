package may_2025;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int result = longestConsecutive.longestConsecutive(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> elems = new HashSet<>();
        for (int num : nums) {
            elems.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (!elems.contains(num)) {
                continue;
            }
            int curr = 1;
            elems.remove(num);
            int toLeft = num - 1;
            while (elems.contains(toLeft)) {
                elems.remove(toLeft);
                curr++;
                toLeft--;
            }
            int toRight = num + 1;
            while (elems.contains(toRight)) {
                elems.remove(toRight);
                curr++;
                toRight++;
            }
            max = Math.max(max, curr);
        }
        return max;
    }

}

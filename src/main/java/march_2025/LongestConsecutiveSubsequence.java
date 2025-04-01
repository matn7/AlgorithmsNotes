package march_2025;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};

        LongestConsecutiveSubsequence longestConsecutiveSubsequence = new LongestConsecutiveSubsequence();
        int result = longestConsecutiveSubsequence.longestConsecutive(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int longestConsecutive(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int num : nums) {
            elements.add(num);
        }

        Set<Integer> seen = new HashSet<>();
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (seen.contains(num)) {
                continue;
            }
            seen.add(num);
            int curr = 1;
            int toLeft = num - 1;
            while (elements.contains(toLeft)) {
                seen.add(toLeft);
                curr++;
                toLeft--;
            }

            int toRight = num + 1;
            while (elements.contains(toRight)) {
                seen.add(toRight);
                curr++;
                toRight++;
            }
            max = Math.max(max, curr);
        }

        return max;
    }

}

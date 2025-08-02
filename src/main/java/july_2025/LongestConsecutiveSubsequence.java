package july_2025;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
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
        int maxLen = 0;
        for (int num : nums) {
            if (seen.contains(num)) {
                continue;
            }
            seen.add(num);
            int currLen = 1;
            int toLeft = num - 1;
            while (elements.contains(toLeft)) {
                currLen++;
                seen.add(toLeft);
                toLeft--;
            }
            int toRight = num + 1;
            while (elements.contains(toRight)) {
                currLen++;
                seen.add(toRight);
                toRight++;
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }

}

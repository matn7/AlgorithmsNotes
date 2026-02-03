package january_2026;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};

        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int result = longestConsecutiveSequence.longestConsecutive(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int longestConsecutive(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int num : nums) {
            elements.add(num);
        }
        int maxLen = 0;
        for (int num : elements) {
            int prev = num - 1;
            if (!elements.contains(prev)) {
                int curLen = 1;
                int next = num + 1;
                while (elements.contains(next)) {
                    curLen++;
                    next++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }

    // O(n) time | O(n) space
    public int longestConsecutive2(int[] nums) {
        Map<Integer, Boolean> visitedNumbers = new HashMap<>();

        for (int num : nums) {
            visitedNumbers.put(num, false);
        }

        int maxLen = 0;

        for (int num : nums) {
            if (visitedNumbers.get(num)) {
                continue;
            }
            int curLen = 1;
            visitedNumbers.put(num, true);
            int toLeft = num - 1;
            while (visitedNumbers.containsKey(toLeft)) {
                curLen++;
                visitedNumbers.put(toLeft, true);
                toLeft--;
            }
            int toRight = num + 1;
            while (visitedNumbers.containsKey(toRight)) {
                curLen++;
                visitedNumbers.put(toRight, true);
                toRight++;
            }
            maxLen = Math.max(maxLen, curLen);
        }

        return maxLen;
    }

}

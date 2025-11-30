package november_2025;

import java.util.HashSet;
import java.util.Set;

public class LongestChainOfConsecutiveNumbers {

    public static void main(String[] args) {
        int[] nums = {1, 6, 2, 5, 8, 7, 10, 3};
        LongestChainOfConsecutiveNumbers longestChainOfConsecutiveNumbers = new LongestChainOfConsecutiveNumbers();
        int result = longestChainOfConsecutiveNumbers.longestConsecutive(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int longestConsecutive(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int num : nums) {
            elements.add(num);
        }
        int maxLen = 0;
        for (int num : elements) {
            if (!elements.contains(num - 1)) {
                int curLen = 1;
                while (elements.contains(num + curLen)) {
                    curLen++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }

        return maxLen;
    }


    // O(n) time | O(n) space
    public int longestConsecutive2(int[] nums) {
        int maxLen = 0;
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            numbers.add(num);
        }
        Set<Integer> seen = new HashSet<>();
        for (int num : numbers) {
            if (seen.contains(num)) {
                continue;
            }
            int currLen = 1;
            int toLeft = num - 1;
            while (numbers.contains(toLeft)) {
                currLen++;
                seen.add(toLeft);
                toLeft--;
            }
            int toRight = num + 1;
            while (numbers.contains(toRight)) {
                currLen++;
                seen.add(toRight);
                toRight++;
            }
            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }

}

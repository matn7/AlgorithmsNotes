package september_2024;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int result = longestConsecutiveSequence.longestConsecutive(nums);
        System.out.println(result);

        int result2 = longestConsecutiveSequence.longestConsecutiveV2(nums);
        System.out.println(result2);
    }

    // O(n) time | O(n) space
    public int longestConsecutiveV2(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int num : nums) {
            elements.add(num);
        }
        int longest = 0;
        for (int num : nums) {
            if (!elements.contains(num - 1)) {
                int currLength = 0;
                while (elements.contains(num + currLength)) {
                    currLength++;
                }
                longest = Math.max(longest, currLength);
            }
        }

        return longest;
    }


    // O(n) time | O(n) space
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> elements = new HashSet<>();
        for (int num : nums) {
            elements.add(num);
        }
        Set<Integer> seen = new HashSet<>();
        int longest = 0;
        for (int num : nums) {
            if (seen.contains(num)) {
                continue;
            }
            seen.add(num);
            int currLength = 1;
            int left = num - 1;
            while (elements.contains(left)) {
                currLength++;
                seen.add(left);
                left--;
            }
            int right = num + 1;
            while (elements.contains(right)) {
                currLength++;
                seen.add(right);
                right++;
            }
            longest = Math.max(longest, currLength);
        }

        return longest;
    }



}

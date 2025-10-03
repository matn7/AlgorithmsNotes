package september_2025;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {1,0,1,2};
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int result = longestConsecutiveSequence.longestConsecutive(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int longestConsecutive(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        int max = 1;

        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            if (counts.containsKey(num)) {
                continue;
            }
            int curr = 1 + counts.getOrDefault(num - 1, 0) + counts.getOrDefault(num + 1, 0);
            counts.put(num, curr);
            counts.put(num - counts.getOrDefault(num - 1, 0), curr);
            counts.put(num + counts.getOrDefault(num + 1, 0), curr);
            max = Math.max(max, curr);
        }
        return max;
    }

    // O(n) time | O(n) space
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        Set<Integer> elements = new HashSet<>();
        for (int num : nums) {
            elements.add(num);
        }

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                continue;
            }
            seen.add(num);
            int curr = 1;
            int left = num - 1;
            int right = num + 1;
            while (elements.contains(left)) {
                seen.add(left);
                curr++;
                left--;
            }
            while (elements.contains(right)) {
                seen.add(right);
                curr++;
                right++;
            }
            max = Math.max(max, curr);
        }
        return max;
    }


}

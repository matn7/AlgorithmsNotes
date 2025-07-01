package june_2025;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int result = longestConsecutive.longestConsecutive(nums);
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
        for (int num : nums) {
            if (seen.contains(num)) {
                continue;
            }
            int curr = 1;
            seen.add(num);
            int toLeft = num - 1;
            while (elements.contains(toLeft)) {
                seen.add(toLeft);
                toLeft--;
                curr++;
            }
            int toRight = num + 1;
            while (elements.contains(toRight)) {
                seen.add(toRight);
                toRight++;
                curr++;
            }
            max = Math.max(max, curr);
        }
        return max;
    }

}

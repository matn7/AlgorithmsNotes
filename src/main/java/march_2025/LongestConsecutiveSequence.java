package march_2025;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int result = longestConsecutiveSequence.longestConsecutive(nums);
        System.out.println(result);
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;

        for (int n : nums) {
            if (!numSet.contains(n - 1)) {
                int length = 0;
                while (numSet.contains(n + length)) {
                    length++;
                }
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }






    public int longestConsecutive2(int[] nums) {
        Map<Integer, Boolean> seen = new HashMap<>();
        for (int num : nums) {
            seen.put(num, false);
        }
        int max = 0;
        for (int num : nums) {
            if (seen.get(num)) {
                continue;
            }
            int currSeq = 1;
            seen.put(num, true);
            int prevNum = num - 1;
            while (seen.containsKey(prevNum)) {
                currSeq++;
                seen.put(prevNum, true);
                prevNum--;
            }
            int nextNum = num + 1;
            while (seen.containsKey(nextNum)) {
                currSeq++;
                seen.put(nextNum, true);
                nextNum++;
            }
            max = Math.max(max, currSeq);
        }
        return max;
    }

}

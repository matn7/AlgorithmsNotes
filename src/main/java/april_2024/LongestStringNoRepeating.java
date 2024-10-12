package april_2024;

import java.util.HashMap;
import java.util.Map;

public class LongestStringNoRepeating {

    public static void main(String[] args) {
        String str = "abccabdb";

        System.out.println(longestSubstring("abccabb"));
        System.out.println(longestSubstring("ccccccc"));
        System.out.println(longestSubstring(""));
        System.out.println(longestSubstring("abcbda"));
        System.out.println();

        System.out.println(lengthOfLongestSubstring("abccabb"));
        System.out.println(lengthOfLongestSubstring("ccccccc"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("abcbda"));
    }

    // O(n) time | O(n) -> O(26) -> O(k) -> O(1) space
    public static int longestSubstring(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        int startIdx = 0;
        int[] longest = new int[] {0, 0};
        Map<Character, Integer> idxMap = new HashMap<>();

        for (int idx = 0; idx < str.length(); idx++) {
            char curr = str.charAt(idx);
            if (idxMap.containsKey(curr)) {
                startIdx = Math.max(startIdx, idxMap.get(curr) + 1);
            }
            idxMap.put(curr, idx);
            if (idx - startIdx > longest[1] - longest[0]) {
                longest[0] = startIdx;
                longest[1] = idx;
            }
        }
        return longest[1] - longest[0] + 1;
    }

    // O(n) time | O(n) space
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> seenChars = new HashMap<>();
        int left = 0;
        int longest = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (seenChars.containsKey(currentChar)) {
                Integer prevSeenChar = seenChars.get(currentChar);
                if (prevSeenChar >= left) {
                    left = prevSeenChar + 1;
                }
            }
            seenChars.put(currentChar, right);
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }

}

























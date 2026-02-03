package january_2026;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrWithoutRepeatChars {

    public static void main(String[] args) {
        String s = "abcabcbb";

        LongestSubstrWithoutRepeatChars longestSubstrWithoutRepeatChars = new LongestSubstrWithoutRepeatChars();
        int result = longestSubstrWithoutRepeatChars.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> positionMap = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (positionMap.containsKey(c)) {
                start = Math.max(start, positionMap.get(c) + 1);
            }
            positionMap.put(c, i);
            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }

}

package december_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";

        LongestSubstringWithoutRepeatingCharacters len =
                new LongestSubstringWithoutRepeatingCharacters();
        int result = len.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charPos = new HashMap<>();
        int maxLen = 0;
        int l = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charPos.containsKey(c)) {
                l = Math.max(l, charPos.get(c) + 1);
            }
            charPos.put(c, i);
            maxLen = Math.max(maxLen, i - l + 1);
        }

        return maxLen;
    }

}

package september_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "clementisacap";
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters
                = new LongestSubstringWithoutRepeatingCharacters();
        int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> charsMap = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (charsMap.containsKey(c)) {
                left = Math.max(left, charsMap.get(c) + 1);
            }
            charsMap.put(c, r);
            maxLen = Math.max(maxLen, r - left + 1);
        }
        return maxLen;
    }

}

package november_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithUniqueCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        s = "pwwkew";

        LongestSubstringWithUniqueCharacters longestSubstringWithUniqueCharacters = new LongestSubstringWithUniqueCharacters();
        int result = longestSubstringWithUniqueCharacters.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (indexMap.containsKey(c)) {
                left = Math.max(left, indexMap.get(c) + 1);
            }
            indexMap.put(c, i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

}

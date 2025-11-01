package october_2025;

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
        int L = 0;
        Map<Character, Integer> posMap = new HashMap<>();
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (posMap.containsKey(curr)) {
                L = Math.max(L, posMap.get(curr) + 1);
            }
            posMap.put(curr, i);
            maxLen = Math.max(maxLen, i - L + 1);
        }
        return maxLen;
    }

}

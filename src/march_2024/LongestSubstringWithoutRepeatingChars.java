package march_2024;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        String str = "accde";

    }

    // O(n) time | O(n) space
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> seenCharacters = new HashMap<>();
        int left = 0;
        int right = 0;
        int longest = 0;

        while (left < s.length() && right < s.length()) {
            char currentCharacter = s.charAt(right);
            if (seenCharacters.containsKey(currentCharacter)) {
                int previousCharacter = seenCharacters.get(currentCharacter);
                left = Math.max(left, previousCharacter + 1);
            }
            seenCharacters.put(currentCharacter, right);
            longest = Math.max(longest, right - left + 1);
            right++;
        }

        return longest;
    }


}

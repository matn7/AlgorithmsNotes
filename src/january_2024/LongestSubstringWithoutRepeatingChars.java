package january_2024;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
//        String str = "AABCBBEACC";
        String str = "clementisacap";
        String result = longestSubstring(str);
        System.out.println(result);
    }

    // O(n) time | O(n) space or O(26)
    public static String longestSubstring(String str) {
        Map<Character, Integer> seenMap = new HashMap<>();
        int[] longest = {0, 0};
        int startIdx = 0;
        int max = 0;

        // A A B C B B E A C C

        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);

            if (seenMap.containsKey(character)) {
                startIdx = Math.max(startIdx, seenMap.get(character) + 1);
            }

            seenMap.put(character, i);
            if (i - startIdx > max) {
                max = i - startIdx;
                longest[0] = startIdx;
                longest[1] = i;
            }
        }


        return str.substring(longest[0], longest[1] + 1);
    }

}

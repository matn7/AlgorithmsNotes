package september_2024;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        String s = "abcabcbbxyza";

        LongestSubstringWithoutRepeatingChars longest = new LongestSubstringWithoutRepeatingChars();
        int result = longest.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}

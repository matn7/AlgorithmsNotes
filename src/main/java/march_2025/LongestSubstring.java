package march_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args) {
        String s = "abba";

        LongestSubstring longestSubstring = new LongestSubstring();
        int result = longestSubstring.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int r = 0;

        Map<Character, Integer> charsPos = new HashMap<>();

        int max = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (charsPos.containsKey(c)) {
                start = Math.max(start, charsPos.get(c) + 1);
            }
            max = Math.max(max, r - start + 1);
            charsPos.put(c, r);
            r++;
        }
        return max;
    }

}

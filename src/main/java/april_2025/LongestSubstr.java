package april_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstr {

    public static void main(String[] args) {
        String s = "abcabcxyztobb";

        LongestSubstr longestSubstr = new LongestSubstr();
        int result = longestSubstr.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        Map<Character, Integer> countsMap = new HashMap<>();
        int max = 0;
        for (int R = 0; R < s.length(); R++) {
            char curr = s.charAt(R);
            if (countsMap.containsKey(curr)) {
                start = Math.max(start, countsMap.get(curr) + 1);
            }
            countsMap.put(curr, R);
            max = Math.max(max, R - start + 1);
        }

        return max;
    }

}

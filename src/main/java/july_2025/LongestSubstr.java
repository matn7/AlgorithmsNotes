package july_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstr {

    public static void main(String[] args) {
        String s = "pwwkew";

        LongestSubstr longestSubstr = new LongestSubstr();
        int result = longestSubstr.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> seen = new HashMap<>();
        int start = 0;
        int[] res = {0, 0};

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen.containsKey(c)) {
                start = Math.max(start, seen.get(c) + 1);
            }
            seen.put(c, i);
            if (i - start > res[1] - res[0]) {
                res[0] = start;
                res[1] = i;
            }
        }
        return res[1] - res[0] + 1;
    }


}

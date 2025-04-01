package february_2025;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";

        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> charsMap = new HashMap<>();
        int L = 0;
        int R = 0;

        while (R < s.length()) {
            char c = s.charAt(R);
            if (charsMap.containsKey(c)) {
                L = Math.max(L, charsMap.get(c) + 1);
            }
            charsMap.put(c, R);
            res = Math.max(res, R - L + 1);
            R++;
        }

        return res;
    }

}

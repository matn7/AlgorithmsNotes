package january_2026;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrWithoutRepeat {

    public static void main(String[] args) {
        String s = "clementisacap";

        LongestSubstrWithoutRepeat longestSubstrWithoutRepeat = new LongestSubstrWithoutRepeat();
        int result = longestSubstrWithoutRepeat.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int maxLen = 0;
        Map<Character, Integer> posMap = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (posMap.containsKey(c)) {
                l = Math.max(posMap.get(c) + 1, l);
            }
            posMap.put(c, r);
            maxLen = Math.max(maxLen, r - l + 1);

        }

        return maxLen;
    }

}

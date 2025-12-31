package december_2025;

import java.util.HashMap;
import java.util.Map;

public class LongSubWithoutRepChar {

    public static void main(String[] args) {
        String s = "abcabcbb";

        LongSubWithoutRepChar longSubWithoutRepChar = new LongSubWithoutRepChar();
        int result = longSubWithoutRepChar.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    // O(n) time | O(m) space
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();
        int start = 0;
        int R = 0;
        int maxLen = 0;

        while (R < s.length()) {
            char curr = s.charAt(R);
            if (indexMap.containsKey(curr)) {
                start = Math.max(start, indexMap.get(curr) + 1);
            }
            indexMap.put(curr, R);
            maxLen = Math.max(maxLen, R - start + 1);
            R++;
        }
        return maxLen;
    }

}

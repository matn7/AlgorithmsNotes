package june_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrNoRepeat {

    public static void main(String[] args) {
        String s = "abcbcbbdefghikkk";
        LongestSubstrNoRepeat longestSubstrNoRepeat = new LongestSubstrNoRepeat();
        int result = longestSubstrNoRepeat.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int start = 0;
        Map<Character, Integer> charsMap = new HashMap<>();
        int[] res = new int[]{0, 0};
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charsMap.containsKey(c)) {
                int idx = charsMap.get(c);
                start = Math.max(start, idx + 1);
            }
            charsMap.put(c, i);
            if (i - start > res[1] - res[0]) {
                res[0] = start;
                res[1] = i;
            }
        }
        return res[1] - res[0] + 1;
    }

}

package october_2023;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplicates {

    public static void main(String[] args) {
        String str = "clementisacap";

        String result = longestSubstring(str);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static String longestSubstring(String str) {
        int[] res = {0, 0};
        int startIdx = 0;
        Map<Character, Integer> seen = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (seen.containsKey(c)) {
                startIdx = Math.max(startIdx, seen.get(c) + 1);
            }
            seen.put(c, i);
            if (res[1] - res[0] < i - startIdx) {
                res[0] = startIdx;
                res[1] = i;
            }
        }
        return str.substring(res[0], res[1] + 1);
    }

}

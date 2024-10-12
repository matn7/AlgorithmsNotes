package september_2024;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args) {
        String str = "clementisacap";

        String result = longestSubstring(str);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static String longestSubstring(String str) {
        if (str.length() == 0) {
            return str;
        }
        Map<Character, Integer> seen = new HashMap<>();
        int startIdx = 0;
        int[] result = new int[] {0, 0};
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i); // 'c'
            if (seen.containsKey(current)) {
                startIdx = Math.max(startIdx, seen.get(current) + 1);
            }
            seen.put(current, i);
            if (i - startIdx > result[1] - result[0]) {
                result[0] = startIdx;
                result[1] = i;
            }
        }
        return str.substring(result[0], result[1] + 1);
    }

}

package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplication {

    public static void main(String[] args) {
        String str = "clementisacap";

        longestSubstringWithoutDuplication(str);
    }

    // O(n) time | O(min(n,a)) space - where n is length of the input string and
    // a is the length of the character alphabet
    public static String longestSubstringWithoutDuplication(String str) {
        // Write your code here
        Map<Character, Integer> lastSeen = new HashMap<>();
        int[] range = {0, 0};
        int startIdx = 0;
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (lastSeen.containsKey(curr)) {
                startIdx = Math.max(startIdx, lastSeen.get(curr) + 1);
                lastSeen.put(curr, i);
            } else {
                lastSeen.put(curr, i);
            }

            if (i - startIdx > range[1] - range[0]) {
                range[0] = startIdx;
                range[1] = i;
            }
        }
        return str.substring(range[0], range[1] + 1);
    }

}

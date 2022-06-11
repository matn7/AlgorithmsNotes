package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplicates {

    public static void main(String[] args) {
        String str = "clementisacap";

        longestSubstringWithoutDuplication(str);
    }

    // O(n) time | O(min(n,a)) space - n len of input string, a len of alphabet
    public static String longestSubstringWithoutDuplication(String str) {
        // Write your code here
        Map<Character, Integer> lastSeen = new HashMap<>();
        int[] longest = {0, 1};
        int startIdx = 0;

        for (int i = 0; i < str.length(); i++) {
            if (lastSeen.containsKey(str.charAt(i))) {
                startIdx = Math.max(startIdx, lastSeen.get(str.charAt(i)) + 1);
                lastSeen.remove(str.charAt(i));
            }
            if (longest[1] - longest[0] < i + 1 - startIdx) {
                longest[0] = startIdx;
                longest[1] = i + 1;
            }
            lastSeen.put(str.charAt(i), i);
        }

        return str.substring(longest[0], longest[1]);
    }

}

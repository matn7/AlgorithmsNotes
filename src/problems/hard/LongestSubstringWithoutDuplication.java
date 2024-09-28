package problems.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplication {

    public static void main(String[] args) {
        String result = longestSubstringWithoutDuplication("clementisacap");
        System.out.println(result);
    }

    // O(n) time | O(min(n, a)) space (a alphabet)
    public static String longestSubstringWithoutDuplication(String str) {
        // Write your code here
        Map<Character, Integer> lastSeen = new HashMap<>();
        int[] longest = {0, 1};
        int startIdx = 0;
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            if (lastSeen.containsKey(character)) {
                startIdx = Math.max(startIdx, lastSeen.get(character) + 1);
            }
            if (longest[1] - longest[0] < i + 1 - startIdx) {
                longest[0] = startIdx;
                longest[1] = i + 1;
            }
            lastSeen.put(character, i);
        }
        return str.substring(longest[0], longest[1]);
    }

}

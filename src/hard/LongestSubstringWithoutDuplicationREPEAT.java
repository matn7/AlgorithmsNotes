package hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplicationREPEAT {

    public static void main(String[] args) {
        longestSubstringWithoutDuplication("clementisacap");
    }

    // O(n) time | O(min(n, a)) space (a alphabet)
    // OK - repeated 28/01/2022
    public static String longestSubstringWithoutDuplication(String str) {
        // 0 1 2 3 4 5 6 7 8 9 10 11 12
        // c l e m e n t i s a  c  a  p
        // Write your code here
        // {'c': 10, 'l': 1, 'e': 4, 'm': 3, 'n': 5, 't': 6, 'i': 7, 's': 8, 'a': 11, 'p': 12}
        Map<Character, Integer> lastSeen = new HashMap<>();
        // [3, 11]
        int[] longest = {0, 1};
        // 10
        int startIdx = 0;
        for (int i = 0; i < str.length(); i++) { // i = 12
            char character = str.charAt(i); // p
            if (lastSeen.containsKey(character)) {
                startIdx = Math.max(startIdx, lastSeen.get(character) + 1); // 3
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

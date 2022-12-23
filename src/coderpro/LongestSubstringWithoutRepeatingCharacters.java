package coderpro;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "AABCBBEACC";

        LongestSubstringWithoutRepeatingCharacters longest = new LongestSubstringWithoutRepeatingCharacters();
        int result = longest.lengthOfLongestSubstring(str);
        System.out.println(result);
    }

    // O(n) time | O(26) space
    public int lengthOfLongestSubstring(String str) {
        Map<Character, Integer> letter_pos = new HashMap<>();
        int start = -1;
        int end = 0;
        int max_length = 0;

        while (end < str.length()) {
            char c = str.charAt(end);
            if (letter_pos.containsKey(c)) {
                start = Math.max(start, letter_pos.get(c));
            }
            max_length = Math.max(max_length, end - start);
            letter_pos.put(c, end);
            end++;
        }
        return max_length;
    }

    // O(n) time | O(n) space or O(26)
    public int longestSubstring(String str) {
        Map<Character, Integer> seen = new HashMap<>();
        int[] range = {0, 0}; // [0, 1], [0, 2], [0, 3], [3, 7], [3, 8], [3, 9], [3, 10], [3, 11]
        int startIdx = 0; // 3

        // c : 11,
        // l : 1,
        // e : 4,
        // m : 3,
        // n : 6,
        // t : 7,
        // i : 8,
        // s : 9,
        // a : 10

        //
        // c l e m e n t i s  a  c  a  p
        // 0 1 2 3 4 6 7 8 9 10 11 12 13
        //                             *
        //                       s

        // A A B C B B E A C C
        // 0 1 2 3 4 5 6 7 8 9
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (seen.containsKey(current)) {
                startIdx = Math.max(startIdx, seen.get(current) + 1);
            }
            seen.put(current, i);
            if (i - startIdx > range[1] - range[0]) {
                range[0] = startIdx;
                range[1] = i;
            }
        }

        String result = str.substring(range[0], range[1] + 1);
        return range[1] - range[0] + 1;
    }

}

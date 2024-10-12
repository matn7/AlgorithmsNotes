package udemy.faang;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        lengthOfLongestSubstring.lengthOfLongestSubstringOptimal("clementisacap");
    }

    // O(n) time | O(n) space (or O(26) space -> O(1) depends on question input)
    public int lengthOfLongestSubstringOptimalMy(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int left = 0;
        int[] range = new int[] {0, 0};
        Map<Character, Integer> seen = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            if (seen.containsKey(currChar)) {
                left = Math.max(left, seen.get(currChar) + 1);
                seen.put(currChar, right);
            } else {
                seen.put(currChar, right);
            }
            if (right - left > range[1] - range[0]) {
                range[0] = left;
                range[1] = right;
            }
        }
        String resultStr = s.substring(range[0], range[1] + 1);
        return range[1] - range[0] + 1;
    }

    public int lengthOfLongestSubstringOptimal(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int left = 0;
        int longest = 0;
        Map<Character, Integer> seen = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            if (seen.containsKey(currChar)) {
                left = Math.max(left, seen.get(currChar) + 1);
            }
            seen.put(currChar, right);
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }

    // constraints:
    //  - Is the string contiguous? Yes
    //  - Does case sensitive matters? No all lowercase
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int longest = 0;
        for (int left = 0; left < s.length(); left++) {
            Map<Character, Boolean> seen = new HashMap<>();
            int currLength = 0;
            for (int right = left; right < s.length(); right++) {
                char currChar = s.charAt(right);
                if (seen.containsKey(currChar)) {
                    break;
                } else {
                    seen.put(currChar, Boolean.TRUE);
                    currLength++;
                    longest = Math.max(longest, currLength);
                }
            }
        }
        return longest;
    }

}

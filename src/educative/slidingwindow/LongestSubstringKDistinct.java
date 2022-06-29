package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }

    // O(n) time | O(k) space
    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        }

        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);

            while (charFreqMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
                if (charFreqMap.get(leftChar) == 0) {
                    charFreqMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

}

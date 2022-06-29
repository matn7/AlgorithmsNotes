package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }

    // O(n) time | O(26) -> O(1) space
    public static int findLength(String str, int k) {
        int windowStart = 0;
        int maxLength = 0;
        int maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFreqMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            letterFreqMap.put(rightChar, letterFreqMap.getOrDefault(rightChar, 0) + 1);

            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFreqMap.get(rightChar));

            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = str.charAt(windowStart);
                letterFreqMap.put(leftChar, letterFreqMap.get(leftChar) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

}

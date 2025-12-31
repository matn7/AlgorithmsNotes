package december_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
//        String s = "AABABBA";
//        int k = 1;

        String s = "ABAB";
        int k = 2;

        LongestRepeatingCharacterReplacement characterReplacement = new LongestRepeatingCharacterReplacement();
        int result = characterReplacement.characterReplacement(s, k);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        // Map<Character, Integer> freqMap = new HashMap<>();
        int[] freqMap = new int[26];
        int maxFreq = 0;
        while (r < s.length()) {
            char c1 = s.charAt(r);
            freqMap[c1 - 'A']++;
            maxFreq = Math.max(maxFreq, freqMap[c1 - 'A']);

            if (r - l + 1 - maxFreq > k) {
                char c2 = s.charAt(l);
                freqMap[c2 - 'A']--;
                maxFreq = Math.max(maxFreq, freqMap[c2 - 'A']);
                l++;
            }

            maxLen = Math.max(r - l + 1, maxLen);
            r++;
        }

        return maxLen;
    }

}

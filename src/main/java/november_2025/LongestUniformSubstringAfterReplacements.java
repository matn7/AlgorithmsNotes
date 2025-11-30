package november_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestUniformSubstringAfterReplacements {

    public static void main(String[] args) {
//        String s = "ABAB";
//        int k = 2;

        String s = "AABABBA";
        int k = 1;

        LongestUniformSubstringAfterReplacements longestUniformSubstringAfterReplacements = new LongestUniformSubstringAfterReplacements();
        int result = longestUniformSubstringAfterReplacements.characterReplacement(s, k);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int characterReplacement(String s, int k) {
        int L = 0;
        int R = 0;
//        Map<Character, Integer> freqMap = new HashMap<>();
        int[] freqMap = new int[26];
        int maxFreq = 0;
        int maxLen = 0;

        while (R < s.length()) {
            char c = s.charAt(R);
            // freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            freqMap[c - 'A']++;
            // maxFreq = Math.max(maxFreq, freqMap.get(c));
            maxFreq = Math.max(maxFreq, freqMap[c - 'A']);

            if ((R - L + 1) - maxFreq > k) {
                char c2 = s.charAt(L);
                // freqMap.put(c2, freqMap.get(c2) - 1);
                freqMap[c2 - 'A']--;
                // maxFreq = Math.max(maxFreq, freqMap.get(c2));
                maxFreq = Math.max(maxFreq, freqMap[c2 - 'A']);
                L++;
            }
            maxLen = Math.max(maxLen, R - L + 1);
            R++;
        }
        return maxLen;
    }

}

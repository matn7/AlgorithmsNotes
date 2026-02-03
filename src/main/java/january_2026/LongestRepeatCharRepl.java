package january_2026;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatCharRepl {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        LongestRepeatCharRepl longestRepeatCharRepl = new LongestRepeatCharRepl();
        int result = longestRepeatCharRepl.characterReplacement(s, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int maxLen = 0;
        int L = 0;

        for (int R = 0; R < s.length(); R++) {
            char c1 = s.charAt(R);
            freqMap.put(c1, freqMap.getOrDefault(c1, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(c1));

            while ((R - L + 1) - maxFreq > k) {
                char c2 = s.charAt(L);
                freqMap.put(c2, freqMap.get(c2) - 1);
                maxFreq = Math.max(maxFreq, freqMap.get(c2));
                L++;
            }
            maxLen = Math.max(maxLen, R - L + 1);
        }

        return maxLen;
    }

}

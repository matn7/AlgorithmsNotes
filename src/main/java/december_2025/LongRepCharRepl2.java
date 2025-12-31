package december_2025;

import java.util.HashMap;
import java.util.Map;

public class LongRepCharRepl2 {

    public static void main(String[] args) {
        String s = "AABABBABBBBBBBBBBB";
        int k = 1;

        LongRepCharRepl2 longRepCharRepl2 = new LongRepCharRepl2();
        int result = longRepCharRepl2.characterReplacement(s, k);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int characterReplacement(String s, int k) {
        int R = 0;
        int L = 0;
        // Map<Character, Integer> freqMap = new HashMap<>();
        int[] freqMap = new int[26];
        int maxF = 0;
        int maxLen = 0;

        while (R < s.length()) {
            char curr = s.charAt(R);
            //freqMap.put(curr, freqMap.getOrDefault(curr, 0) + 1);
            freqMap[curr - 'A']++;
            maxF = Math.max(maxF, freqMap[curr - 'A']);

            while (R - L + 1 - maxF > k) {
                char curr2 = s.charAt(L);
                // freqMap.put(curr2, freqMap.getOrDefault(curr2, 0) - 1);
                freqMap[curr2 - 'A']--;
                maxF = Math.max(maxF, freqMap[curr2 - 'A']);
                L++;
            }
            maxLen = Math.max(maxF, R - L + 1);
            R++;
        }
        return maxLen;
    }

}

package december_2025;

import java.util.HashMap;
import java.util.Map;

public class LongRepCharRepl {

    public static void main(String[] args) {
        String s = "AABABBABBBBBBBBBB";
        int k = 1;

        LongRepCharRepl longRepCharRepl = new LongRepCharRepl();
        int result = longRepCharRepl.characterReplacement(s, k);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int characterReplacement(String s, int k) {
        //Map<Character, Integer> freqMap = new HashMap<>();
        int[] freqMap = new int[26];

        int maxLen = 0;
        int L = 0;
        int R = 0;
        int maxFreq = 0;

        while (R < s.length()) {
            char curr = s.charAt(R);
            freqMap[curr - 'A']++;
            //freqMap.put(curr, freqMap.getOrDefault(curr, 0) + 1);
            //maxFreq = Math.max(maxFreq, freqMap.get(curr));
            maxFreq = Math.max(maxFreq, freqMap[curr - 'A']);

            while (R - L + 1 - maxFreq > k) {
                char prev = s.charAt(L);
                //freqMap.put(prev, freqMap.getOrDefault(prev, 0) - 1);
                //maxFreq = Math.max(maxFreq, freqMap.get(prev));
                freqMap[prev - 'A']--;
                maxFreq = Math.max(maxFreq, freqMap[prev - 'A']);
                L++;
            }
            maxLen = Math.max(maxLen, R - L + 1);
            R++;
        }

        return maxLen;
    }

}

package march_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        LongestRepeatingCharReplacement charReplacement = new LongestRepeatingCharReplacement();
        int result = charReplacement.characterReplacement(s, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int L = 0;
        int R = 0;
        int max = 0;

        while (R < s.length()) {
            char rChar = s.charAt(R);
            freqMap.put(rChar, freqMap.getOrDefault(rChar, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(rChar));

            while ((R - L + 1) - maxFreq > k) {
                char lChar = s.charAt(L);
                freqMap.put(lChar, freqMap.getOrDefault(lChar, 0) - 1);
                maxFreq = Math.max(maxFreq, freqMap.get(lChar));
                L++;
            }
            max = Math.max(max, R - L + 1);
            R++;
        }
        return max;
    }

}

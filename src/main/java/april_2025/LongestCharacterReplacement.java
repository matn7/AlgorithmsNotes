package april_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestCharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        LongestCharacterReplacement longestCharacterReplacement = new LongestCharacterReplacement();
        int result = longestCharacterReplacement.characterReplacement(s, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int characterReplacement(String s, int k) {
        int L = 0;
        int R = 0;
        int maxFreq = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int res = 0;

        while (R < s.length()) {
            char c = s.charAt(R);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(c));

            while ((R - L + 1) - maxFreq > k) {
                char lc = s.charAt(L);
                freqMap.put(lc, freqMap.getOrDefault(lc, 0) - 1);
                maxFreq = Math.max(maxFreq, freqMap.get(lc));
                L++;
            }
            res = Math.max(res, R - L + 1);
            R++;
        }
        return res;
    }

}

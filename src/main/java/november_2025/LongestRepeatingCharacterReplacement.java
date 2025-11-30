package november_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
//        String s = "ABAB";
//        int k = 2;

        String s = "AABABBA";
        int k = 1;

        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        int result = longestRepeatingCharacterReplacement.characterReplacement(s, k);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int characterReplacement(String s, int k) {
        int L = 0;
        int R = 0;
//        Map<Character, Integer> freqMap = new HashMap<>();
        int[] freqMap = new int[26];
        int res = 1;
        int maxFreq = 0;

        while (R < s.length()) {
            char currR = s.charAt(R);
            freqMap[currR - 'A']++;
//            freqMap.put(currR, freqMap.getOrDefault(currR, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap[currR - 'A']);
            while (R - L + 1 - maxFreq > k) {
                char currL = s.charAt(L);
//                freqMap.put(currL, freqMap.get(currL) - 1);
                freqMap[currL - 'A']--;
                L++;
            }
            res = Math.max(res, R - L + 1);
            R++;
        }
        return res;
    }

}

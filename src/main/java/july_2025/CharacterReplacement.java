package july_2025;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public static void main(String[] args) {
//        String s = "AABABBA";
//        int k = 1;

        String s = "ABAB";
        int k = 2;

        CharacterReplacement characterReplacement = new CharacterReplacement();
        int result = characterReplacement.characterReplacement(s, k);
        System.out.println(result);
    }

    // O(n) time | O(26) space
    public int characterReplacement(String s, int k) {
        int[] freqMap = new int[26];
        int start = 0;
        int res = 0;
        int maxFreq = 0;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            freqMap[c1 - 'A']++;
            maxFreq = Math.max(maxFreq, freqMap[c1 - 'A']);
            while (i - start - maxFreq >= k) {
                char c2 = s.charAt(start);
                freqMap[c2 - 'A']--;
                maxFreq = Math.max(maxFreq, freqMap[c2 - 'A']);
                start++;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }

}

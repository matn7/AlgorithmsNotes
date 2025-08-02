package july_2025;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement2 {

    public static void main(String[] args) {
//        String s = "ABAB";
//        int k = 2;

        String s = "AABABBA";
        int k = 1;

        CharacterReplacement2 characterReplacement2 = new CharacterReplacement2();
        int result = characterReplacement2.characterReplacement(s, k);
        System.out.println(result);
    }

    // O(n) time | O(26) space
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int L = 0;
        int R = 0;
        int maxFreq = 0;
        int res = 0;
        while (R < s.length()) {
            char c1 = s.charAt(R);
            freq[c1 - 'A']++;
            maxFreq = Math.max(maxFreq, freq[c1 - 'A']);
            if (R - L - maxFreq >= k) {
                char c2 = s.charAt(L);
                freq[c2 - 'A']--;
                maxFreq = Math.max(maxFreq, freq[c2 - 'A']);
                L++;
            }
            R++;
            res = Math.max(res, R - L);
        }
        return res;
    }

}

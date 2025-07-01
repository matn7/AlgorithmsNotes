package june_2025;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBABBBBB";
        int k = 1;

        CharacterReplacement characterReplacement = new CharacterReplacement();
        int result = characterReplacement.characterReplacement(s, k);
        System.out.println(result);

    }

    // O(n) time | O(26) space
    public int characterReplacement(String s, int k) {
        int l = 0;
        int maxFreq = 0;
        int[] counts = new int[26];
        int max = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            counts[c - 'A']++;
            maxFreq = Math.max(maxFreq, counts[c - 'A']);
            while ((r - l + 1) - maxFreq > k) {
                char t = s.charAt(l);
                counts[t - 'A']--;
                l++;
            }
            max = Math.max(max, r - l + 1);
        }

        return max;
    }

}

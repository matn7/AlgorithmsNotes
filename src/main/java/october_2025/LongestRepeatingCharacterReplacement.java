package october_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    // O(n) time | O(n) space
    public int characterReplacement(String s, int k) {
        int l = 0;
        int maxF = 0;
        int res = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, freq.get(s.charAt(r)));

            if (r - l + 1 - maxF > k) {
                freq.put(s.charAt(l), freq.getOrDefault(s.charAt(l), 0) - 1);
                l++;
                maxF = Math.max(maxF, freq.get(s.charAt(l)));
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

}

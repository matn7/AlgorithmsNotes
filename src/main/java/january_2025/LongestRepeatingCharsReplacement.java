package january_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharsReplacement {

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int res = 0;
        int maxf = 0;

        int l = 0;
        int r = 0;
        while (r < s.length()) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, count.get(s.charAt(r)));

            if ((r - l + 1) - maxf > k) {
                count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }

            res = Math.max(res, (r - l + 1) - maxf);
            r++;
        }

        return res;
    }

}

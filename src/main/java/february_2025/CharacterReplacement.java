package february_2025;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> counts = new HashMap<>();
        int L = 0;
        int R = 0;
        int maxf = 0;
        int res = 0;
        while (R < s.length()) {
            char c = s.charAt(R);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
            maxf = Math.max(maxf, counts.get(c));

            while ((R - L + 1) - maxf > k) {
                counts.put(s.charAt(L), counts.get(s.charAt(L)) - 1);
                L++;
            }
            res = Math.max(res, R - L + 1);
            R++;
        }
        return res;
    }

}

package december_2025;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberIII {

    private static final char[][] PAIRS = {
            {'0', '0'},
            {'1', '1'},
            {'8', '8'},
            {'6', '9'},
            {'9', '6'}
    };

    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        int minLen = low.length();
        int maxLen = high.length();

        for (int len = minLen; len <= maxLen; len++) {
            List<String> list = generate(len, len);

            for (String s : list) {
                if ((s.length() == minLen && s.compareTo(low) < 0)) continue;
                if ((s.length() == maxLen && s.compareTo(high) > 0)) continue;
                count++;
            }
        }

        return count;
    }

    private List<String> generate(int n, int total) {
        if (n == 0) return List.of("");
        if (n == 1) return List.of("0", "1", "8");

        List<String> middles = generate(n - 2, total);
        List<String> result = new ArrayList<>();

        for (String mid : middles) {
            for (char[] p : PAIRS) {

                // liczba nie może zaczynać się od '0', jeśli długość > 1
                if (p[0] == '0' && n == total) continue;

                result.add(p[0] + mid + p[1]);
            }
        }

        return result;
    }

}

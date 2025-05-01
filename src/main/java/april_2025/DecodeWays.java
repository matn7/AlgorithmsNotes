package april_2025;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    // bottom-up
    // O(n) time | O(n) spaCE
    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp.put(i, 0);
            } else {
                dp.put(i, dp.getOrDefault(i + 1, 0));
            }

            if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                dp.put(i, dp.get(i) + dp.getOrDefault(i + 2, 0));
            }
        }
        return dp.get(0);
    }

    // top-down
    // O(n) time | O(n) space
    public int numDecodings2(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);
        return dfs(0, s, dp);
    }

    private int dfs(int i, String s, Map<Integer, Integer> dp) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }
        if (s.charAt(i) == '0') {
            return 0;
        }

        int res = dfs(i + 1, s, dp);
        if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
            res += dfs(i + 2, s, dp);
        }
        dp.put(i, res);
        return res;
    }

}

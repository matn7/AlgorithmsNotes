package june_2025;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public static void main(String[] args) {
        String s = "226";

        DecodeWays decodeWays = new DecodeWays();
        int result = decodeWays.numDecodings(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);

        return dfs(s, 0, dp);
    }

    private int dfs(String s, int i, Map<Integer, Integer> dp) {
        if (i == s.length()) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if (dp.containsKey(i)) {
            return dp.get(i);
        }
        int res = dfs(s, i + 1, dp);
        if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
            res += dfs(s, i + 2, dp);
        }
        dp.put(i, res);
        return res;
    }


}

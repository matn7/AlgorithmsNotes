package october_2025;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public static void main(String[] args) {
        String s = "12";

        DecodeWays decodeWays = new DecodeWays();
        int result = decodeWays.numDecodings(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int numDecodings(String s) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(s, 0, memo);
    }

    private int dfs(String s, int i, Map<Integer, Integer> memo) {
        if (i == s.length()) {
            return 1;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        if (i > s.length()) {
            return 0;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        int count = dfs(s, i + 1, memo); // check one digit value
        if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
            count += dfs(s, i + 2, memo); // check two digit value
        }
        memo.put(i, count);
        return count;
    }

}

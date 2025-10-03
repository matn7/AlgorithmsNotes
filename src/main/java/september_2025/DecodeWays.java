package september_2025;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public static void main(String[] args) {
        String s = "11106";
        DecodeWays decodeWays = new DecodeWays();
        int result = decodeWays.numDecodings(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int numDecodings(String s) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(s.length(), 1);

        return helper(s, 0, memo);
    }

    private int helper(String s, int i, Map<Integer, Integer> memo) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        int count = helper(s, i + 1, memo);
        if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
            count += helper(s, i + 2, memo);
        }
        memo.put(i, count);
        return count;
    }




}

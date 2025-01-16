package december_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumDecodings {

    public static void main(String[] args) {

        String s = "226";

        NumDecodings numDecodings = new NumDecodings();
        int result = numDecodings.numDecodings(s);
        System.out.println(result);

    }

    public int numDecodings(String s) {
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
        int res = 0;
        res += dfs(i + 1, s, dp);
        if (i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
            res += dfs(i + 2, s, dp);
        }
        dp.put(i, res);
        return res;
    }

}

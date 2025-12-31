package december_2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StrobogrammaticNumberIII2 {

    public static void main(String[] args) {
        String low = "50", high = "100";

        StrobogrammaticNumberIII2 strobogrammaticNumberIII2 = new StrobogrammaticNumberIII2();
        int result = strobogrammaticNumberIII2.strobogrammaticInRange(low, high);
        System.out.println(result);
    }

    public int strobogrammaticInRange(String low, String high) {

        int count = 0;
        int minLen = low.length();
        int maxLen = high.length();

        for (int len = minLen; len <= maxLen; len++) {
            List<String> list = build(len, len);

            for (String s : list) {
                if (s.length() == minLen && s.compareTo(low) < 0) {
                    continue;
                }
                if (s.length() == maxLen && s.compareTo(high) > 0) {
                    continue;
                }
                count++;
            }
        }

        return count;

    }

    private List<String> build(int n, int totalLen) {
        if (n == 0) {
            return List.of("");
        }
        if (n == 1) {
            return List.of("0", "1", "8");
        }
        List<String> mids = build(n - 2, totalLen);
        List<String> res = new ArrayList<>();

        for (String mid : mids) {
            if (n != totalLen) {
                res.add("0" + mid + "0");
            }
            res.add("1" + mid + "1");
            res.add("6" + mid + "9");
            res.add("8" + mid + "8");
            res.add("9" + mid + "6");
        }
        return res;
    }

}

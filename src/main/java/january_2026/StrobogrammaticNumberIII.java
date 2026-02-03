package january_2026;

import udemy.faang.LevelOrder;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberIII {

    public static void main(String[] args) {
        String low = "50";
        String high = "100";

        StrobogrammaticNumberIII strobogrammaticNumberIII = new StrobogrammaticNumberIII();
        int result = strobogrammaticNumberIII.strobogrammaticInRange(low, high);
        System.out.println(result);
    }

    // (5^(n/2)) time | O(5^(n/2)) space
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;

        for (int i = low.length(); i <= high.length(); i++) {
            List<String> numbers = generate(i, i);
            for (String num : numbers) {
                if (num.length() == low.length() && num.compareTo(low) < 0) {
                    continue;
                }
                if (num.length() == high.length() && num.compareTo(high) > 0) {
                    continue;
                }
                count++;
            }
        }

        return count;
    }

    private List<String> generate(int n, int totalLen) {
        if (n == 0) {
            return List.of("");
        }
        if (n == 1) {
            return List.of("0", "1", "8");
        }
        List<String> mids = generate(n - 2, totalLen);
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

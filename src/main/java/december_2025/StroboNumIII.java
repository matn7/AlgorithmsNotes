package december_2025;

import java.util.ArrayList;
import java.util.List;

public class StroboNumIII {

    public static void main(String[] args) {
        String low = "50";
        String high = "100";

        StroboNumIII stroboNumIII = new StroboNumIII();
        int result = stroboNumIII.strobogrammaticInRange(low, high);
        System.out.println(result);
    }

    // O(5 ^ (n/2)) time | O(5 ^ (n/2)) space
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;

        for (int i = low.length(); i <= high.length(); i++) {
            List<String> numbers = build(i, i);

            for (String s : numbers) {
                if (s.length() == low.length() && s.compareTo(low) < 0) {
                    continue;
                }
                if (s.length() == high.length() && s.compareTo(high) > 0) {
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

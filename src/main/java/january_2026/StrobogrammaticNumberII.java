package january_2026;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {

    // O(5 ^ (n/2)) time | O(5 ^ (n/2)) space
    public List<String> findStrobogrammatic(int n) {
        return generate(n, n);
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
        for (String num : mids) {
            if (n != totalLen) {
                res.add("0" + num + "0");
            }
            res.add("1" + num + "1");
            res.add("6" + num + "9");
            res.add("8" + num + "8");
            res.add("9" + num + "6");
        }
        return res;
    }


}

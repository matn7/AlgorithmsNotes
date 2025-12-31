package december_2025;

import java.util.ArrayList;
import java.util.List;

public class StroboNum2 {


    // O(5 ^ (n/2)) time | O(5 ^ (n/2)) space
    public List<String> findStrobogrammatic(int n) {
        return build(n, n);
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

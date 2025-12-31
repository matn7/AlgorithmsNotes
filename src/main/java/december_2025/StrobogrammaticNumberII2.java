package december_2025;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII2 {

    public static void main(String[] args) {
        int n = 2;

        StrobogrammaticNumberII2 strobogrammaticNumberII2 = new StrobogrammaticNumberII2();
        List<String> result = strobogrammaticNumberII2.findStrobogrammatic(n);
        System.out.println(result);
    }

    static List<String> prevPrevVals = new ArrayList<>();
    static List<String> prevVals = new ArrayList<>();

    static {
        prevPrevVals.add("0");
        prevPrevVals.add("1");
        prevPrevVals.add("8");

        prevVals.add("11");
        prevVals.add("69");
        prevVals.add("96");
        prevVals.add("88");
    }


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

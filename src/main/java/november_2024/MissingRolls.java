package november_2024;

import java.util.ArrayList;
import java.util.List;

public class MissingRolls {

    public static void main(String[] args) {
        int[] rolls = {3,2,4,3};
        int mean = 4;
        int n = 2;

        MissingRolls missingRolls = new MissingRolls();
        missingRolls.missingRolls(rolls, mean, n);
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int mTotal = 0;
        for (int r : rolls) {
            mTotal += r;
        }
        int nTotal = (mean * (n + m)) - mTotal;
        if (nTotal < n || nTotal > n * 6) {
            return new int[] {};
        }
        List<Integer> result = new ArrayList<>();
        while (nTotal > 0) {
            int dice = Math.min(nTotal - n + 1, 6);
            result.add(dice);
            nTotal -= dice;
            n -= 1;
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }

}

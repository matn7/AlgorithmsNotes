package november_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MatchSticks {

    // O(4^n) time
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        List<Integer> matchArr = new ArrayList<>();
        for (int n : matchsticks) {
            sum += n;
            matchArr.add(n);
        }
        if (sum % 4 != 0) {
            return false;
        }
        int length = sum / 4;
        int[] sides = new int[4];

        matchArr.sort(Comparator.reverseOrder());
        return backtrack(0, matchArr, sides, length);
    }

    private boolean backtrack(int i, List<Integer> matchArr, int[] sides, int length) {
        if (i == matchArr.size()) {
            return true;
        }
        for (int j = 0; j < 4; j++) {
            if (sides[j] + matchArr.get(i) <= length) {
                sides[j] += matchArr.get(i);
                if (backtrack(i + 1, matchArr, sides, length)) {
                    return true;
                }
                sides[j] -= matchArr.get(i);
            }
        }
        return false;
    }

}










